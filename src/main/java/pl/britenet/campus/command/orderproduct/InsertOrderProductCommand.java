package pl.britenet.campus.command.orderproduct;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.database.object.Cart;
import pl.britenet.campus.database.object.OrderProducts;
import pl.britenet.campus.service.CartProductsService;
import pl.britenet.campus.service.CartService;
import pl.britenet.campus.service.OrderProductsService;

import java.util.Scanner;

public class InsertOrderProductCommand extends Command {

    private final OrderProductsService orderProductsService;

    public InsertOrderProductCommand(OrderProductsService orderProductsService) {
        super(Constants.COMMAND_INSERT_ORDERPRODUCT);
        this.orderProductsService = orderProductsService;
    }

    @Override
    public void execute() {
        System.out.println("wprowadz ilosc: ");
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        OrderProducts orderProducts = new OrderProducts();

        this.orderProductsService.insertOrderProduct(orderProducts);


    }


}
