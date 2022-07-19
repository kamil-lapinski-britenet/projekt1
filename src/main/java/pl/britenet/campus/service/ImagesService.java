package pl.britenet.campus.service;

import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.database.object.Images;
import pl.britenet.campus.database.object.Order;
import pl.britenet.campus.database.object.Product;
import pl.britenet.campus.database.object.User;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ImagesService {

    private final DatabaseService databaseService;

    public ImagesService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public void insertUserImage(Images images) {
        this.databaseService.performDML(String.format("SET foreign_key_checks=0"));
        this.databaseService.performDML(String.format("" +
                        "INSERT INTO images (paths, userid) VALUES ('%s', %d)"
                , images.getPaths(), images.getUserId()));
        this.databaseService.performDML(String.format("SET foreign_key_checks=1"));

    }

    public void insertProductImage(Images images) {
        this.databaseService.performDML(String.format("" +
                        "INSERT INTO images (paths, productId) VALUES ('%s', %d)"
                , images.getPaths(), images.getProductId()));


    }

    public List<Images> getImages() {
        return this.databaseService.performSQL("SELECT * FROM images", resultSet -> {
            List<Images> imagesList = new ArrayList<>();
            try {
                while (resultSet.next()) {
                    Images images = new Images(resultSet.getInt("imageId"));
                    images.setPaths(resultSet.getString("paths"));
                    images.setUserId(resultSet.getInt("userId"));
                    images.setProductId(resultSet.getInt("productId"));
                    imagesList.add(images);
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return imagesList;
        });
    }

    public Optional<Images> getImage(int imageId) {
        Images retrieveImage = this.databaseService.performSQL(String.format("SELECT * FROM images WHERE imageId = %d", imageId), resultSet -> {
            try {
                if (resultSet.next()) {
                    Images images = new Images(resultSet.getInt("imageId"));
                    images.setPaths(resultSet.getString("paths"));
                    images.setUserId(resultSet.getInt("userId"));
                    images.setProductId(resultSet.getInt("productId"));
                    return images;
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return null;
        });

        return Optional.of(retrieveImage);
    }

    public void deleteImage (int imageId) {
        this.databaseService.performDML(String.format("SET foreign_key_checks=0"));
        this.databaseService.performDML(String.format("DELETE FROM images WHERE imageId = %d", imageId));
        this.databaseService.performDML(String.format("SET foreign_key_checks=1"));
    }

    public void updateImage (Images images) {
        this.databaseService.performDML(String.format("UPDATE images SET paths= '" +images.getPaths()+"' WHERE imageId = %d",images.getImageId()));

    }


}
