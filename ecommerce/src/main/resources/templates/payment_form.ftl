<#include "partials/header.ftl">
<h1>Processar Pagamento</h1>
<form action="/pagamento" method="post">
  <div class="mb-3">
    <label class="form-label">Tipo (cartao|pix|paypal)</label>
    <input class="form-control" name="tipo" />
  </div>
  <div class="mb-3">
    <label class="form-label">Valor</label>
    <input class="form-control" name="amount" />
  </div>
  <button class="btn btn-primary">Pagar</button>
</form>
<#include "partials/footer.ftl">