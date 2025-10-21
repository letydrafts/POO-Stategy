package com.letydrafts.repository;

import com.letydrafts.dao.AdminDAO;
import com.letydrafts.models.Admin;
import java.util.List;

public class AdminRepository {

    private final AdminDAO adminDAO;

    public AdminRepository() {
        this.adminDAO = new AdminDAO();
    }

    public boolean add(Admin admin) {
        if (admin.getEmail() == null || admin.getName() == null) {
            System.out.println("invalid data.");
            return false;
        }
        return adminDAO.create(admin);
    }

    public Admin getById(int id) {
        return adminDAO.findById(id);
    }

    public List<Admin> getAll() {
        return adminDAO.findAll();
    }

    public boolean delete(int id) {
        return adminDAO.delete(id);
    }
}
