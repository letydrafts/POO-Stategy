<#include "partials/header.ftl">
<h1>Novo admin</h1>
<form action="/admins" method="post">
  <div class="mb-3">
    <label class="form-label">Nome</label>
    <input class="form-control" name="name" />
  </div>
  <div class="mb-3">
    <label class="form-label">Email</label>
    <input class="form-control" name="email" />
  </div>
  <button class="btn btn-primary">Salvar</button>
</form>
<#include "partials/footer.ftl">