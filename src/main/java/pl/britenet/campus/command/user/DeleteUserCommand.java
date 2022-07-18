package pl.britenet.campus.command.user;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.service.ProductService;
import pl.britenet.campus.service.UserService;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DeleteUserCommand extends Command {

    private final UserService userService;

    public DeleteUserCommand(UserService userService) {
        super(Constants.COMMAND_DELETE_USER);
        this.userService = userService;
    }

    @Override
    public void execute() {


            Scanner scanner = new Scanner(System.in);
            System.out.println("wprowadz id: ");
            String id = scanner.nextLine();
            this.userService.deleteUser(Integer.parseInt(id));




    }

}
