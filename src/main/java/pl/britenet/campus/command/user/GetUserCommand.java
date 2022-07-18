package pl.britenet.campus.command.user;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.database.object.User;
import pl.britenet.campus.service.UserService;

import java.util.Optional;
import java.util.Scanner;

public class GetUserCommand extends Command {

    private final UserService userService;

    public GetUserCommand(UserService userService) {
        super(Constants.COMMAND_GET_USER);
        this.userService = userService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("wprowadz id: ");
        String id = scanner.nextLine();
        Optional<User> user = this.userService.getUser(Integer.parseInt(id));
        user.ifPresent(value -> System.out.println(String.valueOf(value.getUserId())+ ' ' +
                value.getName() + ' ' + value.getLastName() + ' ' + value.getMail()  + ' ' + value.getAddress()
                + ' ' + value.getPassword()  + ' ' + value.getTelephone()
        ) );


    }
}