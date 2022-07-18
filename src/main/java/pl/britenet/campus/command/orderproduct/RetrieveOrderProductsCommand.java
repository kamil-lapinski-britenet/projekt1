package pl.britenet.campus.command.orderproduct;

import pl.britenet.campus.Constants;
import pl.britenet.campus.Paginator;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.database.object.CartProducts;
import pl.britenet.campus.database.object.OrderProducts;
import pl.britenet.campus.service.CartProductsService;
import pl.britenet.campus.service.OrderProductsService;

import java.util.List;
import java.util.Scanner;

public class RetrieveOrderProductsCommand extends Command {

    private final OrderProductsService orderProductsService;

    public RetrieveOrderProductsCommand(OrderProductsService orderProductsService) {
        super(Constants.COMMAND_RETRIEVE_ORDERPRODUCTS);
        this.orderProductsService = orderProductsService;
    }

    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ile rekordow na stronie?: ");
        int page = scan.nextInt();
        Paginator<OrderProducts> paginator = new Paginator<OrderProducts>(this.orderProductsService.getOrderProducts(), page, "orderProducts");
        paginator.Paginate();
        //List<OrderProducts> orderProductsList = this.orderProductsService.getOrderProducts();
       /* orderProductsList.forEach( orderProducts -> {
            System.out.println(
                   "id zamowienia: "+ orderProducts.getOrderId()+ "| data zamowienia: " + orderProducts.getOrder().getOrderDate() +
                           " | status zamowienia: "+orderProducts.getOrder().getStatus()+" | nazwa produktu: " +orderProducts.getProduct().getName()+
                           " | cena produktu: " + orderProducts.getProduct().getPrice() + "zl"
            );
            System.out.println("--------------------------------------------");
        }
        );*/

    }
    }


