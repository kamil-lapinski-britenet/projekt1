package pl.britenet.campus;

import pl.britenet.campus.command.*;
import pl.britenet.campus.command.cart.DeleteCartCommand;
import pl.britenet.campus.command.cart.GetCartCommand;
import pl.britenet.campus.command.cart.InsertCartCommand;
import pl.britenet.campus.command.cart.RetrieveCartsCommand;
import pl.britenet.campus.command.cartproduct.DeleteCartProductCommand;
import pl.britenet.campus.command.cartproduct.GetCartProductCommand;
import pl.britenet.campus.command.cartproduct.InsertCartProductCommand;
import pl.britenet.campus.command.cartproduct.RetrieveCartProductsCommand;
import pl.britenet.campus.command.images.InsertImageCommand;
import pl.britenet.campus.command.images.InsertImageProductCommand;
import pl.britenet.campus.command.order.DeleteOrderCommand;
import pl.britenet.campus.command.order.GetOrderCommand;
import pl.britenet.campus.command.order.InsertOrderCommand;
import pl.britenet.campus.command.order.RetrieveOrdersCommand;
import pl.britenet.campus.command.orderproduct.DeleteOrderProductCommand;
import pl.britenet.campus.command.orderproduct.GetOrderProductCommand;
import pl.britenet.campus.command.orderproduct.InsertOrderProductCommand;
import pl.britenet.campus.command.orderproduct.RetrieveOrderProductsCommand;
import pl.britenet.campus.command.product.*;
import pl.britenet.campus.command.user.*;
import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.service.*;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean isRunning = true;

        DatabaseService databaseService = new DatabaseService();
        ProductService productService = new ProductService(databaseService);
        UserService userService = new UserService(databaseService);
        CartService cartService = new CartService(databaseService);
        CartProductsService cartProductsService = new CartProductsService(databaseService);
        OrderService orderService = new OrderService(databaseService);
        OrderProductsService orderProductsService = new OrderProductsService(databaseService);
        ImagesService imagesService = new ImagesService(databaseService);
        CommandService commandService = new CommandService();

        commandService.registerCommand(new HelloCommand());

        commandService.registerCommand(new HelpCommand());

        commandService.registerCommand(new EndCommand());

        commandService.registerCommand(new RetrieveProductsCommand(productService));
        commandService.registerCommand(new GetProductCommand(productService));
        commandService.registerCommand(new InsertProductCommand(productService));
        commandService.registerCommand(new DeleteProductCommand(productService));
        commandService.registerCommand(new UpdateProductCommand(productService));

        commandService.registerCommand(new RetrieveUsersCommand(userService));
        commandService.registerCommand(new GetUserCommand(userService));
        commandService.registerCommand(new InsertUserCommand(userService));
        commandService.registerCommand(new DeleteUserCommand(userService));
        commandService.registerCommand(new UpdateUserCommand(userService));

        commandService.registerCommand(new RetrieveCartsCommand(cartService));
        commandService.registerCommand(new GetCartCommand(cartService));
        commandService.registerCommand(new InsertCartCommand(cartService));
        commandService.registerCommand(new DeleteCartCommand(cartService));


        commandService.registerCommand(new RetrieveCartProductsCommand(cartProductsService));
        commandService.registerCommand(new GetCartProductCommand(cartProductsService));
        commandService.registerCommand(new DeleteCartProductCommand(cartProductsService));
        commandService.registerCommand(new InsertCartProductCommand(cartProductsService));

        commandService.registerCommand(new RetrieveOrdersCommand(orderService));
        commandService.registerCommand(new GetOrderCommand(orderService));
        commandService.registerCommand(new InsertOrderCommand(orderService));
        commandService.registerCommand(new DeleteOrderCommand(orderService));

        commandService.registerCommand(new RetrieveOrderProductsCommand(orderProductsService));
        commandService.registerCommand(new GetOrderProductCommand(orderProductsService));
        commandService.registerCommand(new InsertOrderProductCommand(orderProductsService));
        commandService.registerCommand(new DeleteOrderProductCommand(orderProductsService));

        commandService.registerCommand(new InsertImageCommand(imagesService));
        commandService.registerCommand(new InsertImageProductCommand(imagesService));

        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            try {


            System.out.println("Wprowadz komende... lub napisz 'help' aby zobaczyc pomoc. 'end' zakonczy program ");
            String command = scanner.nextLine();
            Optional<Command> oCommand = commandService.getCommand(command);
            oCommand.orElseThrow().execute();

        }
            catch (NoSuchElementException elementException) {
                System.out.println("Niepoprawna komenda");

            }
        }
    }
}
