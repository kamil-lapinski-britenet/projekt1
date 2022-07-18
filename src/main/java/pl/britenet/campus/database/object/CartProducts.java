package pl.britenet.campus.database.object;

import pl.britenet.campus.Constants;

import java.util.ArrayList;

public class CartProducts {
    private final int cartProductsId;
    private int amount;
    private int cartId;
    private int productId;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    private Product product;
    private Cart cart;
    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public CartProducts() {
        this.cartProductsId = Constants.INVALID_ID;
    }

    public CartProducts(int cartProductsId, int amount) {
        this.cartProductsId = cartProductsId;
        this.amount = amount;
    }

    public CartProducts(int cartProductsId) {
        this.cartProductsId = cartProductsId;
    }

    public int getCartProductsId() {
        return cartProductsId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString(){
        return "nazwa produktu: " + product.getName() +" | cena produktu: "+
                  product.getPrice()+" zl | ilosc produktow: " + amount+" | id koszyka: "+
                 cart.getCartId()+" |cena koszyka: " + cart.getCartPrice() + " zl";
    }
}
