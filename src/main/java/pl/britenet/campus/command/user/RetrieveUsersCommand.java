package pl.britenet.campus.command.user;

import pl.britenet.campus.Constants;
import pl.britenet.campus.Paginator;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.database.object.CartProducts;
import pl.britenet.campus.database.object.User;
import pl.britenet.campus.service.UserService;

import java.sql.SQLSyntaxErrorException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class RetrieveUsersCommand extends Command {

    private final UserService userService;

    public RetrieveUsersCommand(UserService userService) {
        super(Constants.COMMAND_RETRIEVE_USERS);
        this.userService = userService;
    }

    @Override
    public void execute() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Ile rekordow na stronie?: ");
        int page = scan.nextInt();
        Paginator<User> paginator = new Paginator<>(this.userService.getUsers(), page, "Users: ");
        paginator.Paginate();

//            List<User> userList = this.userService.getUsers();
//            userList.forEach(user -> {
//                System.out.println(user.getUserId());
//                System.out.println("imie: " + user.getName());
//                System.out.println("nazwisko: " + user.getLastName());
//                System.out.println("e-mail: " + user.getMail());
//                System.out.println("adres: " + user.getAddress());
//                System.out.println("haslo: " + user.getPassword());
//                System.out.println("telefon: " + user.getTelephone());
//                System.out.println("zdjecie: " + user.getImages().getPaths());
//                System.out.println("--------------------------------------------");
//                System.out.println("aby zamknac wpisz -1");
//            });

        }
    }


