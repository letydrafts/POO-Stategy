package com.letydrafts;

import com.letydrafts.models.Product;

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
    }
}