package com.letydrafts.controllers;

import com.letydrafts.models.Cart;
import com.letydrafts.models.Product;
import com.letydrafts.repository.CartRepository;
import com.letydrafts.repository.ProductRepository;
import io.javalin.http.Context;

import java.time.LocalDateTime;
import java.util.List;

public class CartsController {

    private final CartRepository cartRepository = new CartRepository();
    private final ProductRepository productRepository = new ProductRepository();

    public void list(Context ctx) {
        List<Cart> all = cartRepository.findAll();
        ctx.json(all);
    }

    public void getById(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Cart cart = cartRepository.findById(id);
        if (cart == null) ctx.status(404).result("Cart not found");
        else ctx.json(cart);
    }

    public void create(Context ctx) {
        Cart cart = new Cart(LocalDateTime.now());
        String clientParam = ctx.formParam("clientId");
        Integer clientId = null;
        if (clientParam != null && !clientParam.isBlank()) {
            try { clientId = Integer.parseInt(clientParam); } catch (NumberFormatException e) { clientId = null; }
        }
        boolean ok = cartRepository.createForClient(cart, clientId);
        ctx.status(ok ? 201 : 400).result(ok ? "Created" : "Create failed");
    }

    public void update(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        ctx.status(400).result("Use specific endpoints to add/remove products or close cart");
    }

    public void close(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        boolean ok = cartRepository.closeCart(id);
        ctx.status(ok ? 200 : 404).result(ok ? "Closed" : "Not found");
    }

    public void addProduct(Context ctx) {
        int cartId = Integer.parseInt(ctx.pathParam("id"));
        int productId = Integer.parseInt(ctx.formParam("productId"));

        Product p = productRepository.getProductById(productId);
        if (p == null) {
            ctx.status(404).result("Product not found");
            return;
        }

        boolean ok = cartRepository.addProduct(cartId, p);
        ctx.status(ok ? 200 : 404).result(ok ? "Added" : "Add failed");
    }

    public void removeProduct(Context ctx) {
        int cartId = Integer.parseInt(ctx.pathParam("id"));
        int productId = Integer.parseInt(ctx.formParam("productId"));

        Product p = productRepository.getProductById(productId);
        if (p == null) {
            ctx.status(404).result("Product not found");
            return;
        }

        boolean ok = cartRepository.removeProduct(cartId, p);
        ctx.status(ok ? 200 : 404).result(ok ? "Removed" : "Remove failed");
    }
}

//testing
