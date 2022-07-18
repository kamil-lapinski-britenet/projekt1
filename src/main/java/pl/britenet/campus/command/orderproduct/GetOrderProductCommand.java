package pl.britenet.campus.command.orderproduct;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.database.object.CartProducts;
import pl.britenet.campus.database.object.Order;
import pl.britenet.campus.database.object.OrderProducts;
import pl.britenet.campus.service.CartProductsService;
import pl.britenet.campus.service.OrderProductsService;


import java.util.Optional;
import java.util.Scanner;

public class GetOrderProductCommand extends Command {

    private final OrderProductsService orderProductsService;

    public GetOrderProductCommand(OrderProductsService orderProductsService) {
        super(Constants.COMMAND_GET_ORDERPRODUCT);
        this.orderProductsService = orderProductsService;
    }

    @Override
    public void execute ()  {

        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        Optional<OrderProducts> orderProducts = this.orderProductsService.getOrderProduct(Integer.parseInt(id));
        orderProducts.ifPresent(value -> System.out.println());
    }

}
