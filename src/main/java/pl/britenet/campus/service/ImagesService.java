package pl.britenet.campus.service;

import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.database.object.Images;
import pl.britenet.campus.database.object.Product;
import pl.britenet.campus.database.object.User;

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

    public void deleteImage (int imageId) {
        this.databaseService.performDML(String.format("SET foreign_key_checks=0"));
        this.databaseService.performDML(String.format("DELETE FROM images WHERE imageId = %d", imageId));
        this.databaseService.performDML(String.format("SET foreign_key_checks=1"));
    }

    public void updateImage (Images images) {
        this.databaseService.performDML(String.format("UPDATE images SET paths= '" +images.getPaths()+"' WHERE imageId = %d",images.getImageId()));

    }


}
