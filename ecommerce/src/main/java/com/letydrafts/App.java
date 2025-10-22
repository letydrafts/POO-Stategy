package com.letydrafts;

import com.letydrafts.models.Product;
import com.letydrafts.repository.PaymentRepository;
import com.letydrafts.controllers.PaymentController;

import freemarker.template.Configuration;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.rendering.template.JavalinFreemarker;
import java.util.Map;

public class App {
    public static void main(String[] args) {

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_34);
        cfg.setClassForTemplateLoading(App.class, "/templates");
        cfg.setDefaultEncoding("UTF-8");

        Javalin app = Javalin.create(config -> {
            config.staticFiles.add(staticFiles -> {
                // staticFiles.directory = "/public";
                staticFiles.location = Location.CLASSPATH;
                config.fileRenderer(new JavalinFreemarker(cfg));
            });
        }).start(7070);

        app.get("/", ctx -> {
            Map<String, String> model = Map.of("nome", "Prof. Luiz");
            ctx.render("index.ftl", model);
        });

        app.get("/cadastro", ctx -> {
            ctx.render("cadastro.ftl");
        });

        app.post("/produtos", ctx -> {
            String nomeProduto = ctx.formParam("nome");
            Double precoProduto = Double.parseDouble(ctx.formParam("preco"));

            System.out.println("Nome do Produto: " + nomeProduto);
            System.out.println("Preço do Produto: " + precoProduto);

            Product produto = new Product(nomeProduto, precoProduto);
            ctx.render("produtos.ftl", Map.of("produto", produto));
        });


    PaymentRepository paymentRepository = new PaymentRepository();
    PaymentController paymentController = new PaymentController(paymentRepository);

    app.post("/pagamento", paymentController::process);

    var productsController = new com.letydrafts.controllers.ProductsController();
    var clientsController = new com.letydrafts.controllers.ClientsController();
    var cartsController = new com.letydrafts.controllers.CartsController();
    var adminsController = new com.letydrafts.controllers.AdminsController();

    // Template routes (register before parameterized routes to avoid collisions)
    app.get("/products/new", ctx -> ctx.render("product_form.ftl"));
    app.get("/products/view", ctx -> {
        var repo = new com.letydrafts.repository.ProductRepository();
        ctx.render("products.ftl", java.util.Map.of("produtos", repo.getAllProducts()));
    });

    // API-style JSON endpoints (existing)
    app.get("/products", productsController::list);
    app.get("/products/{id}", productsController::getById);
    app.post("/products", productsController::create);
    app.put("/products/{id}", productsController::update);
    app.delete("/products/{id}", productsController::delete);


    // Template routes first
    app.get("/clients/new", ctx -> ctx.render("client_form.ftl"));
    app.get("/clients/view", ctx -> {
        var repo = new com.letydrafts.repository.ClientRepository();
        ctx.render("clients.ftl", java.util.Map.of("clients", repo.getAll()));
    });

    // API-style JSON endpoints
    app.get("/clients", clientsController::list);
    app.get("/clients/{id}", clientsController::getById);
    app.post("/clients", clientsController::create);
    app.delete("/clients/{id}", clientsController::delete);


    // Template routes first
    app.get("/carts/new", ctx -> ctx.render("cart_form.ftl"));
    app.get("/carts/view", ctx -> {
        var repo = new com.letydrafts.repository.CartRepository();
        ctx.render("carts.ftl", java.util.Map.of("carts", repo.findAll()));
    });

    // API-style JSON endpoints
    app.get("/carts", cartsController::list);
    app.get("/carts/{id}", cartsController::getById);
    app.post("/carts", cartsController::create);
    app.put("/carts/{id}", cartsController::update);
    app.post("/carts/{id}/close", cartsController::close);
    app.post("/carts/{id}/products", cartsController::addProduct);
    app.delete("/carts/{id}/products", cartsController::removeProduct);


    // Template routes first
    app.get("/admins/new", ctx -> ctx.render("admin_form.ftl"));
    app.get("/admins/view", ctx -> {
        var repo = new com.letydrafts.repository.AdminRepository();
        ctx.render("admins.ftl", java.util.Map.of("admins", repo.getAll()));
    });

    // API-style JSON endpoints
    app.get("/admins", adminsController::list);
    app.get("/admins/{id}", adminsController::getById);
    app.post("/admins", adminsController::create);
    app.delete("/admins/{id}", adminsController::delete);

    // Payment form
    app.get("/pagamento/form", ctx -> ctx.render("payment_form.ftl"));
    app.post("/pagamento/form", ctx -> {
        // delegate to controller and show result template
        paymentController.process(ctx);
        ctx.render("payment_result.ftl", java.util.Map.of("message", "Pagamento enviado. Ver console/DB."));
    });
    }
}