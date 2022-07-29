package pl.britenet.campus.service;

import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.database.object.Cart;
import pl.britenet.campus.database.object.Order;
import pl.britenet.campus.database.object.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CartService {

    private final DatabaseService databaseService;

    public CartService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public List<Cart> getCarts() {
        return this.databaseService.performSQL("SELECT * FROM cart", resultSet -> {
            List<Cart> cartList = new ArrayList<>();
            try {
                while (resultSet.next()) {
                    Cart cart = new Cart(resultSet.getInt("cartId"));
                    cart.setCartPrice(resultSet.getDouble("cartPrice"));
                    cartList.add(cart);
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return cartList;
        });
    }

    public Optional<Cart> getCart(int cartId) {
        Cart retrievedCart = this.databaseService.performSQL(String.format("SELECT * FROM cart WHERE cartId = %d", cartId), resultSet -> {
            try {
                if (resultSet.next()) {
                    Cart cart = new Cart(resultSet.getInt("cartId"));
                    cart.setCartPrice(resultSet.getDouble("cartPrice"));
                    return cart;
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return null;
        });

        return Optional.of(retrievedCart);
    }

    public void insertCart(Cart cart) {
        User user = new User();

        this.databaseService.performDML(String.format("INSERT INTO cart (cartPrice, userId, productCartId) VALUES ('"+cart.getCartPrice()+"', '"+cart.getUserId()+"','"+cart.getProductCartId()+"')"));
    }

    public void deleteCart (int cartId) {
        this.databaseService.performDML(String.format("SET foreign_key_checks=0"));
        this.databaseService.performDML(String.format("DELETE FROM cart WHERE cartId = %d", cartId));
        this.databaseService.performDML(String.format("SET foreign_key_checks=1"));
    }

    public void updateCart (Cart cart) {

        this.databaseService.performDML(String.format("UPDATE cart SET cartPrice = "+cart.getCartPrice() +" WHERE cartId = %d", cart.getCartId()));

    }


}
