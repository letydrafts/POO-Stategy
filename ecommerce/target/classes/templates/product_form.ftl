<#include "partials/header.ftl">
<h1>Novo produto</h1>
<form action="/products" method="post">
  <div class="mb-3">
    <label class="form-label">Nome</label>
    <input class="form-control" name="name" />
  </div>
  <div class="mb-3">
    <label class="form-label">Preço</label>
    <input class="form-control" name="price" />
  </div>
  <div class="mb-3">
    <label class="form-label">Estoque</label>
    <input class="form-control" name="stock" />
  </div>
  <button class="btn btn-primary">Salvar</button>
</form>
<#include "partials/footer.ftl">