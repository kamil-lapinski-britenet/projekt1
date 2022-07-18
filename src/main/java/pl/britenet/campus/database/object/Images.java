package pl.britenet.campus.database.object;

import pl.britenet.campus.Constants;

public class Images {
    private final int imageId;
    private int userId;
    private int productId;
    private String paths;
    private User user;
    private Product product;

    public Images(int imageId, int userId, int productId, String paths, User user, Product product) {
        this.imageId = imageId;
        this.userId = userId;
        this.productId = productId;
        this.paths = paths;
        this.user = user;
        this.product = product;
    }

    public int getImageId() {
        return imageId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getPaths() {
        return paths;
    }

    public void setPaths(String paths) {
        this.paths = paths;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Images(int imageId) {
        this.imageId = imageId;
    }
    public Images() {
        this.imageId = Constants.INVALID_ID;
    }


}
