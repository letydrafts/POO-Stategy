<#include "partials/header.ftl">
<h1>Administradores</h1>
<p><a class="btn btn-primary" href="/admins/new">Novo admin</a></p>
<table class="table table-striped">
  <thead>
    <tr>
      <th>ID</th>
      <th>Nome</th>
      <th>Email</th>
      <th>Ações</th>
    </tr>
  </thead>
  <tbody>
  <#list admins as a>
    <tr>
      <td>${a_index+1}</td>
      <td>${a.name}</td>
      <td>${a.email}</td>
      <td>
        <a class="btn btn-sm btn-danger" href="/admins/${a_index+1}/delete">Remover</a>
      </td>
    </tr>
  </#list>
  </tbody>
</table>
<#include "partials/footer.ftl">