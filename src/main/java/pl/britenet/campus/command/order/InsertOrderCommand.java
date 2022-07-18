package pl.britenet.campus.command.order;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.database.object.Order;
import pl.britenet.campus.database.object.Product;
import pl.britenet.campus.service.OrderService;
import pl.britenet.campus.service.ProductService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InsertOrderCommand extends Command {

    private final OrderService orderService;

    public InsertOrderCommand(OrderService orderService) {
        super(Constants.COMMAND_INSERT_ORDER);
        this.orderService = orderService;
    }

    @Override
    public void execute() {
        System.out.println("status: ");
        Scanner scanner = new Scanner(System.in);



        Order order = new Order();

        String status = scanner.nextLine();
        order.setStatus(status);

        this.orderService.insertOrder(order);
    }

}
