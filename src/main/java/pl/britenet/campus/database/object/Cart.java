package pl.britenet.campus.database.object;

import pl.britenet.campus.Constants;

public class Cart {
    private final int cartId;
    private double cartPrice;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductCartId() {
        return productCartId;
    }

    public void setProductCartId(int productCartId) {
        this.productCartId = productCartId;
    }

    private int userId;
    private int productCartId;


    public Cart() {
        this.cartId = Constants.INVALID_ID;
    }

    public Cart(int cartId){
        this.cartId = cartId;
    }

    public Cart(int cartId, double cartPrice) {
        this.cartId = cartId;
        this.cartPrice = cartPrice;
    }





    public int getCartId() {
        return cartId;
    }

    public double getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(double cartPrice) {
        this.cartPrice = cartPrice;
    }

    @Override
    public String toString() {
        return "id: " + cartId + " cena: "+cartPrice;
    }
}
