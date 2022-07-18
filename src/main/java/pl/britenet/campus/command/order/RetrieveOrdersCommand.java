package pl.britenet.campus.command.order;

import pl.britenet.campus.Constants;
import pl.britenet.campus.Paginator;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.database.object.CartProducts;
import pl.britenet.campus.database.object.Order;
import pl.britenet.campus.service.OrderService;

import java.util.List;
import java.util.Scanner;

public class RetrieveOrdersCommand extends Command {

    private final OrderService orderService;

    public RetrieveOrdersCommand(OrderService orderService) {
        super(Constants.COMMAND_RETRIEVE_ORDERS);
        this.orderService = orderService;
    }

    @Override
    public void execute() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Ile rekordow na stronie?: ");
        int page = scan.nextInt();
        Paginator<Order> paginator = new Paginator<>(this.orderService.getOrders(), page, "Orders: ");
        paginator.Paginate();


//        List<Order> orderList = this.orderService.getOrders();
//        orderList.forEach( order -> {
//            System.out.println(order.getStatus());
//            System.out.println(order.getOrderDate());
//
//
//        } );
    }
    }


