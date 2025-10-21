<#include "partials/header.ftl">
<h1>Produtos</h1>
<p><a class="btn btn-primary" href="/products/new">Novo produto</a></p>
<table class="table table-striped">
  <thead>
    <tr>
      <th>ID</th>
      <th>Nome</th>
      <th>Preço</th>
      <th>Estoque</th>
      <th>Ações</th>
    </tr>
  </thead>
  <tbody>
  <#list produtos as p>
    <tr>
      <td>${p_index + 1}</td>
      <td>${p.name}</td>
      <td>R$ ${p.price}</td>
      <td>${p.stock?if_exists?string}</td>
      <td>
        <a class="btn btn-sm btn-secondary" href="/products/${p_index+1}">Ver</a>
        <a class="btn btn-sm btn-danger" href="/products/${p_index+1}/delete">Remover</a>
      </td>
    </tr>
  </#list>
  </tbody>
</table>
<#include "partials/footer.ftl">