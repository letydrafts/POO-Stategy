<#include "partials/header.ftl">
<h1>Novo Carrinho</h1>
<form action="/carts" method="post">
  <div class="mb-3">
    <label class="form-label">Descrição</label>
    <input class="form-control" name="description" />
  </div>
  <button class="btn btn-primary">Criar</button>
</form>
<#include "partials/footer.ftl">