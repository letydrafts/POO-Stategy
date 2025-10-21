<#include "partials/header.ftl">
<h1>Clientes</h1>
<p><a class="btn btn-primary" href="/clients/new">Novo cliente</a></p>
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
  <#list clients as c>
    <tr>
      <td>${c_index+1}</td>
      <td>${c.name}</td>
      <td>${c.email}</td>
      <td>
        <a class="btn btn-sm btn-secondary" href="/clients/${c_index+1}">Ver</a>
        <a class="btn btn-sm btn-danger" href="/clients/${c_index+1}/delete">Remover</a>
      </td>
    </tr>
  </#list>
  </tbody>
</table>
<#include "partials/footer.ftl">