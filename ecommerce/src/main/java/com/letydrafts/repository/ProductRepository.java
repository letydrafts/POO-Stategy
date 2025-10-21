package com.letydrafts.repository;

import com.letydrafts.dao.ProductDAO;
import com.letydrafts.models.Product;

import java.util.List;

public class ProductRepository {
    private final ProductDAO productDAO;

    public ProductRepository() {
        this.productDAO = new ProductDAO();
    }

    public boolean addProduct(Product product) {
        if (product.getName() == null || product.getPrice() <= 0) {
            System.out.println("Product not found.");
            return false;
        }
        return productDAO.create(product);
    }

    public Product getProductById(int id) {
        return productDAO.findById(id);
    }

    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }

    public boolean updateProduct(int id, Product newProductData) {
        return productDAO.update(newProductData, id);
    }

    public boolean deleteProduct(int id) {
        return productDAO.delete(id);
    }


     public boolean decreaseStock(int id, int amount) {
        Product product = productDAO.findById(id);
        if (product == null) {
            System.out.println("Product not found.");
            return false;
        }

        int newStock = product.getStock() - amount;
        if (newStock < 0) {
            System.out.println("Insufficient stock.");
            return false;
        }

        product.setStock(newStock);
        return productDAO.update(product, id);
    }
}