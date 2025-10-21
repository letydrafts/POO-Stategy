package com.letydrafts.controllers;

import com.letydrafts.models.Client;
import com.letydrafts.repository.ClientRepository;
import io.javalin.http.Context;

import java.util.List;

public class ClientsController {

    private final ClientRepository repository = new ClientRepository();

    public void list(Context ctx) {
        List<Client> all = repository.getAll();
        ctx.json(all);
    }

    public void getById(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Client c = repository.getById(id);
        if (c == null) ctx.status(404).result("Client not found");
        else ctx.json(c);
    }

    public void create(Context ctx) {
        String email = ctx.formParam("email");
        String name = ctx.formParam("name");
        Client client = new Client(email, name);
        boolean ok = repository.add(client);
        ctx.status(ok ? 201 : 400).result(ok ? "Created" : "Invalid client");
    }

    public void delete(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        boolean ok = repository.delete(id);
        ctx.status(ok ? 200 : 404).result(ok ? "Deleted" : "Not found");
    }
}
