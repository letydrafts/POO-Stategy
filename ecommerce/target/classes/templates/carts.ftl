<#include "partials/header.ftl">
<h1>Carrinhos</h1>
<p><a class="btn btn-primary" href="/carts/new">Novo carrinho</a></p>
<table class="table table-striped">
  <thead>
    <tr>
      <th>ID</th>
      <th>Descrição</th>
      <th>Total</th>
      <th>Criado Em</th>
      <th>Ações</th>
    </tr>
  </thead>
  <tbody>
  <#list carts as c>
    <tr>
      <td>${c_index+1}</td>
      <td>${c.description}</td>
      <td>R$ ${c.total}</td>
      <td>${c.createdOn?string("yyyy-MM-dd HH:mm")}</td>
      <td>
        <a class="btn btn-sm btn-secondary" href="/carts/${c_index+1}">Ver</a>
        <a class="btn btn-sm btn-danger" href="/carts/${c_index+1}/close">Fechar</a>
      </td>
    </tr>
  </#list>
  </tbody>
</table>
<#include "partials/footer.ftl">