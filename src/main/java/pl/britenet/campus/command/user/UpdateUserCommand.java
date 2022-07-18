package pl.britenet.campus.command.user;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.database.object.Product;
import pl.britenet.campus.database.object.User;
import pl.britenet.campus.service.ProductService;
import pl.britenet.campus.service.UserService;

import java.util.Optional;
import java.util.Scanner;

public class UpdateUserCommand extends Command {

    private final UserService userService;

    public UpdateUserCommand(UserService userService) {
        super(Constants.COMMAND_UPDATE_USER);
        this.userService = userService;
    }

    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        System.out.println("ID:");
        int id = Integer.parseInt(scan.nextLine());
        final User[] user = {new User()};
        this.userService.getUser(id).ifPresent(value ->
                user[0] = value
        );
        User temp = user[0];
        System.out.println("Name:");
        temp.setName(scan.nextLine());
        System.out.println("Lastname:");
        temp.setLastName(scan.nextLine());
        System.out.println("E-Mail:");
        temp.setMail(scan.nextLine());
        System.out.println("Address:");
        temp.setAddress(scan.nextLine());
        System.out.println("Password:");
        temp.setPassword(scan.nextLine());
        System.out.println("Telephone:");
        temp.setTelephone(scan.nextLine());
        userService.updateUser(temp);
    }

}
