package pl.britenet.campus.command.orderproduct;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.service.CartProductsService;
import pl.britenet.campus.service.OrderProductsService;

import java.util.Scanner;

public class DeleteOrderProductCommand extends Command {

    private final OrderProductsService orderProductsService;

    public DeleteOrderProductCommand(OrderProductsService orderProductsService) {
        super(Constants.COMMAND_DELETE_ORDERPRODUCT);
        this.orderProductsService = orderProductsService;
    }

    @Override
    public void execute (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("wprowadz id: ");
        String id = scanner.nextLine();
        this.orderProductsService.deleteOrderProduct(Integer.parseInt(id));

    }


}
