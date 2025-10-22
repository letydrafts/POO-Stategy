package com.letydrafts.repository;

import com.letydrafts.dao.CartDAO;
import com.letydrafts.models.Cart;
import com.letydrafts.models.Product;

import java.util.List;

public class CartRepository {

    private final CartDAO cartDAO;

    public CartRepository() {
        this.cartDAO = new CartDAO();
    }

    public boolean create(Cart cart) {
        return cartDAO.create(cart);
    }

    public boolean createForClient(Cart cart, Integer clientId) {
        cart.setClientId(clientId);
        return cartDAO.create(cart);
    }

    public Cart findById(int id) {
        return cartDAO.findById(id);
    }

    public List<Cart> findAll() {
        return cartDAO.findAll();
    }

    public boolean update(Cart cart, int cartId) {
        return cartDAO.edit(cart, cartId);
    }

    public boolean closeCart(int cartId) {
        return cartDAO.delete(cartId);
    }

    public boolean addProduct(int cartId, Product product) {
        Cart cart = cartDAO.findById(cartId);
        if (cart == null) {
            System.out.println("Cart not found.");
            return false;
        }

        cart.getProducts().add(product);
        return cartDAO.edit(cart, cartId);
    }

    public boolean removeProduct(int cartId, Product product) {
        Cart cart = cartDAO.findById(cartId);
        if (cart == null) {
            System.out.println("Cart not found.");
            return false;
        }

        boolean removed = cart.getProducts().removeIf(p -> 
            p.getName().equals(product.getName()) && 
            p.getPrice().equals(product.getPrice())
        );

        if (!removed) {
            System.out.println("Product not found in cart.");
            return false;
        }

        return cartDAO.edit(cart, cartId);
    }
}
