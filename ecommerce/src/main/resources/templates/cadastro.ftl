<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Produtos</title>
</head>
<body>
    <h1>Cadastro de Produtos</h1>
    <p>Preencha os campos abaixo para cadastrar um novo produto:</p>

    <form action="/produtos" method="POST">
        <label for="Nome Produto">Nome do Produto:</label>
        <input type="text" id="nome" name="nome" required><br><br>


        <label for="Preço Produto">Preço do Produto:</label>
        <input type="text" id="preco" name="preco" required><br><br>

        <button type="submit">Cadastrar Produto</button>
    </form>

</body>
</html>