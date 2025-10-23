package com.letydrafts.controllers;

import com.letydrafts.models.Admin;
import com.letydrafts.repository.AdminRepository;
import io.javalin.http.Context;

import java.util.List;

public class AdminsController {

    private final AdminRepository repository = new AdminRepository();

    public void list(Context ctx) {
        List<Admin> all = repository.getAll();
        ctx.json(all);
    }
    public void getById(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Admin a = repository.getById(id);
        if (a == null) ctx.status(404).result("Admin not found");
        else ctx.json(a);
    }

    public void create(Context ctx) {
        String email = ctx.formParam("email");
        String name = ctx.formParam("name");
        Admin admin = new Admin(email, name);
        boolean ok = repository.add(admin);
        ctx.status(ok ? 201 : 400).result(ok ? "Created" : "Invalid admin");
    }

    public void delete(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        boolean ok = repository.delete(id);
        ctx.status(ok ? 200 : 404).result(ok ? "Deleted" : "Not found");
    }
}
