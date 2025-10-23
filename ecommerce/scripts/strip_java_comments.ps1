# PowerShell script to remove Java comments (//, /* */ and /** */) from files under src/main/java
# This script attempts to preserve string and char literals.

$root = Join-Path $PSScriptRoot '..\src\main\java' | Resolve-Path
Write-Host "Root: $root"

Get-ChildItem -Path $root -Recurse -Filter *.java | ForEach-Object {
    $path = $_.FullName
    $text = Get-Content -Raw -Encoding UTF8 $path

    $out = ''
    $i = 0
    $n = $text.Length
    $state = 'normal'
    while ($i -lt $n) {
        $ch = $text[$i]
        $nxt = if ($i+1 -lt $n) { $text[$i+1] } else { '' }
        switch ($state) {
            'normal' {
                if ($ch -eq '/' -and $nxt -eq '/') { $state='line_comment'; $i += 2; continue }
                elseif ($ch -eq '/' -and $nxt -eq '*') { $state='block_comment'; $i += 2; continue }
                elseif ($ch -eq '"') { $out += $ch; $state='string'; $i++; continue }
                elseif ($ch -eq "'") { $out += $ch; $state='char'; $i++; continue }
                else { $out += $ch; $i++; continue }
            }
            'line_comment' {
                if ($ch -eq "`n" -or $ch -eq "`r") { $out += $ch; $state='normal' }
                $i++
                continue
            }
            'block_comment' {
                if ($ch -eq '*' -and $nxt -eq '/') { $i += 2; $state='normal'; continue }
                $i++
                continue
            }
            'string' {
                $out += $ch
                if ($ch -eq '\\') { if ($i+1 -lt $n) { $out += $text[$i+1]; $i += 2; continue } }
                elseif ($ch -eq '"') { $state = 'normal' }
                $i++
                continue
            }
            'char' {
                $out += $ch
                if ($ch -eq '\\') { if ($i+1 -lt $n) { $out += $text[$i+1]; $i += 2; continue } }
                elseif ($ch -eq "'") { $state = 'normal' }
                $i++
                continue
            }
        }
    }

    if ($out -ne $text) {
        Set-Content -Path $path -Value $out -Encoding UTF8
        Write-Host "Stripped comments from $path"
    }
}
Write-Host "Done." 
