package pl.britenet.campus.command.user;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.database.object.Product;
import pl.britenet.campus.database.object.User;
import pl.britenet.campus.service.ImagesService;
import pl.britenet.campus.service.ProductService;
import pl.britenet.campus.service.UserService;

import java.util.Scanner;

public class InsertUserCommand extends Command {

    private final UserService userService;

    public InsertUserCommand(UserService userService) {
        super(Constants.COMMAND_INSERT_USER);
        this.userService = userService;
    }

    @Override
    public void execute() {
        System.out.println("wprowadz nazwe, nazwisko, mail, adres, haslo i telefon: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String lastname = scanner.nextLine();
        String mail = scanner.nextLine();
        String address = scanner.nextLine();
        String pass = scanner.nextLine();
        String tel = scanner.nextLine();

        User user = new User();
        user.setName(name);
        user.setLastName(lastname);
        user.setMail(mail);
        user.setAddress(address);
        user.setPassword(pass);
        user.setTelephone(tel);



        this.userService.insertUser(user);
    }
}
