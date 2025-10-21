package com.letydrafts.controllers;

import com.letydrafts.models.Product;
import com.letydrafts.repository.ProductRepository;
import io.javalin.http.Context;

import java.util.List;

public class ProductsController {

    private final ProductRepository repository = new ProductRepository();

    public void list(Context ctx) {
        List<Product> products = repository.getAllProducts();
        ctx.json(products);
    }

    public void getById(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Product p = repository.getProductById(id);
        if (p == null) ctx.status(404).result("Product not found");
        else ctx.json(p);
    }

    public void create(Context ctx) {
        String name = ctx.formParam("name");
        Double price = Double.parseDouble(ctx.formParam("price"));
        Product p = new Product(name, price);
        boolean ok = repository.addProduct(p);
        ctx.status(ok ? 201 : 400).result(ok ? "Created" : "Invalid product");
    }

    public void update(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        String name = ctx.formParam("name");
        Double price = Double.parseDouble(ctx.formParam("price"));

        Product newP = new Product(name, price);
        boolean ok = repository.updateProduct(id, newP);
        ctx.status(ok ? 200 : 400).result(ok ? "Updated" : "Update failed");
    }

    public void delete(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        boolean ok = repository.deleteProduct(id);
        ctx.status(ok ? 200 : 404).result(ok ? "Deleted" : "Not found");
    }
}
