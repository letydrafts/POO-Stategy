<#include "partials/header.ftl">
<h1>Detalhe do Carrinho</h1>
<p>Descrição: ${cart.description}</p>
<p>Total: R$ ${cart.total}</p>
<h3>Produtos</h3>
<ul class="list-group">
  <#list cart.products as p>
    <li class="list-group-item">${p.name} - R$ ${p.price}</li>
  </#list>
</ul>
<form action="/carts/${cart.id}/products" method="post" class="mt-3">
  <div class="mb-3">
    <label class="form-label">ID do produto</label>
    <input class="form-control" name="productId" />
  </div>
  <button class="btn btn-primary">Adicionar</button>
</form>
<#include "partials/footer.ftl">