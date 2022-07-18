package pl.britenet.campus.command.order;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.database.object.Order;
import pl.britenet.campus.service.OrderService;

import java.util.Optional;
import java.util.Scanner;

public class GetOrderCommand extends Command {

    private final OrderService orderService;

    public GetOrderCommand(OrderService orderService) {
        super(Constants.COMMAND_GET_ORDER);
        this.orderService = orderService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("wprowadz id: ");
        String id = scanner.nextLine();
        Optional<Order> order = this.orderService.getOrder(Integer.parseInt(id));
        order.ifPresent(value -> System.out.println(String.valueOf(value.getOrderId())+ ' ' +
                value.getStatus() + ' ' + value.getOrderDate()
        ) );


    }
}