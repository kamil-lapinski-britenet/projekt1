package pl.britenet.campus.service;

import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.database.object.Cart;
import pl.britenet.campus.database.object.CartProducts;
import pl.britenet.campus.database.object.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CartProductsService {

    private final DatabaseService databaseService;

    public CartProductsService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public List<CartProducts> getCartsProducts() {
        return this.databaseService.performSQL("SELECT cartproducts.cartProductsId, product.productId AS productId, product.name, product.price, cartproducts.amount, cart.cartId, cart.cartPrice FROM cartproducts LEFT JOIN product ON cartproducts.productId = product.productId LEFT JOIN cart ON cartproducts.cartId = cart.cartId;", resultSet -> {
            List<CartProducts> cartProductsList = new ArrayList<>();
            try {
                while (resultSet.next()) {
                    Product product = new Product((resultSet.getInt("productId")));
                    product.setName(resultSet.getString("product.name"));
                    product.setPrice(resultSet.getDouble("product.price"));
                    Cart cart = new Cart((resultSet.getInt("cart.cartId")));
                    cart.setCartPrice(resultSet.getDouble("cart.cartPrice"));
                    CartProducts cartProducts = new CartProducts(resultSet.getInt("cartProductsId"));
                    cartProducts.setAmount(resultSet.getInt("amount"));
                    cartProducts.setProduct(product);
                    cartProducts.setCart(cart);

                    cartProductsList.add(cartProducts);
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return cartProductsList;
        });
    }

    //"SELECT * FROM cartProducts"

    public Optional<CartProducts> getCartProduct(int cartProductId) {
        CartProducts retrievedCartProducts = this.databaseService.performSQL(String.format("SELECT * FROM cartProducts WHERE cartProductsId = %d", cartProductId), resultSet -> {
            try {
                if (resultSet.next()) {
                    CartProducts cartProducts = new CartProducts(resultSet.getInt("carProductId"));
                    cartProducts.setAmount(resultSet.getInt("amount"));
                    return cartProducts;
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return null;
        });

        return Optional.of(retrievedCartProducts);
    }

    public void insertCartProduct(CartProducts cartProducts) {
        this.databaseService.performDML(String.format("INSERT INTO cartProduct (amount) VALUES ("+cartProducts.getAmount()+")"));
    }

    public void deleteCartProduct (int cartProductId) {
        this.databaseService.performDML(String.format("SET foreign_key_checks=0"));
        this.databaseService.performDML(String.format("DELETE FROM cartProduct WHERE cartId = %d", cartProductId));
        this.databaseService.performDML(String.format("SET foreign_key_checks=1"));
    }

    public void updateCart (Cart cart,int cartId) {


    }


}
