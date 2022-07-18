package pl.britenet.campus.command.order;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.service.OrderService;
import pl.britenet.campus.service.UserService;

import java.util.Scanner;

public class DeleteOrderCommand extends Command {

    private final OrderService orderService;

    public DeleteOrderCommand(OrderService orderService) {
        super(Constants.COMMAND_DELETE_ORDER);
        this.orderService = orderService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("wprowadz id: ");
        String id = scanner.nextLine();
        this.orderService.deleteOrder(Integer.parseInt(id));



    }

}
