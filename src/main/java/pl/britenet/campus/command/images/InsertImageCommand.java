package pl.britenet.campus.command.images;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.database.object.Images;
import pl.britenet.campus.database.object.User;
import pl.britenet.campus.service.ImagesService;
import pl.britenet.campus.service.UserService;

import java.awt.*;
import java.util.Scanner;

public class InsertImageCommand extends Command {

    private final ImagesService imagesService;

    public InsertImageCommand(ImagesService imagesService) {
        super(Constants.COMMAND_INSERT_IMAGEUSER);
        this.imagesService = imagesService;
    }

    @Override
    public void execute() {
        System.out.println("wprowadz sciezke i id usera: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int paths = scanner.nextInt();
        Images images = new Images();
        images.setPaths(name);
        images.setUserId(paths);

        this.imagesService.insertUserImage(images);
    }

}
