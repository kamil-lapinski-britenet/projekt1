package pl.britenet.campus.service;

import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.database.object.Images;
import pl.britenet.campus.database.object.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ProductService {
    private final DatabaseService databaseService;

    public ProductService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public List<Product> getProducts() {
        return this.databaseService.performSQL("SELECT product.productId, product.name, product.description, product.price, images.imageId, images.paths FROM product LEFT JOIN images ON product.productId = images.productId;", resultSet -> {
            List<Product> productList = new ArrayList<>();
            try {
                while (resultSet.next()) {
                    Images images = new Images(resultSet.getInt("imageId"));
                    images.setPaths(resultSet.getString("paths"));
                    Product product = new Product(resultSet.getInt("productId"));
                    product.setName(resultSet.getString("name"));
                    product.setDescription(resultSet.getString("description"));
                    product.setPrice(resultSet.getDouble("price"));
                    product.setImages(images);
                    productList.add(product);
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return productList;
        });
    }
//"SELECT * FROM product"
    public Optional<Product> getProduct(int productId) {
        Product retrievedProduct = this.databaseService.performSQL(String.format("SELECT * FROM product WHERE productId = %d", productId), resultSet -> {
            try {
                if (resultSet.next()) {
                    Product product = new Product(resultSet.getInt("productId"));
                    product.setName(resultSet.getString("name"));
                    product.setDescription(resultSet.getString("description"));
                    product.setPrice(resultSet.getDouble("price"));
                    return product;
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return null;
        });

        return Optional.of(retrievedProduct);
    }

    public void insertProduct(Product product) {
        this.databaseService.performDML(String.format("INSERT INTO product (name, description, price) VALUES ('%s', '%s', +'" + product.getPrice()+ "')",
                product.getName(), product.getDescription()));
    }

    public void deleteProduct (int productId) {
        this.databaseService.performDML(String.format("SET foreign_key_checks=0"));
        this.databaseService.performDML(String.format("DELETE FROM product WHERE productId = %d", productId));
        this.databaseService.performDML(String.format("SET foreign_key_checks=1"));
    }

    public void updateProduct (Product product) {
            this.databaseService.performDML(String.format("UPDATE product SET name = '%s', description = '%s', price = " +product.getPrice()+" WHERE productId = %d", product.getName(), product.getDescription(),product.getProductId()));

        }



}
