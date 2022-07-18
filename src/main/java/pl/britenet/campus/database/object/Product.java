package pl.britenet.campus.database.object;

import pl.britenet.campus.Constants;

public class Product {
    public int getProductId() {
        return productId;
    }

    private final int productId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }





    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private String name;
    private String description;

    private double price;

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    private Images images;
    private int imageId;

    public Product(){
        this.productId = Constants.INVALID_ID;
    }

    public Product(int productId){
        this.productId = productId;
    }

    public Product(int productId, String name, String description, double price) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return " id: " + productId + " nazwa: " + name + " opis: " + " cena: " + price;
    }

}
