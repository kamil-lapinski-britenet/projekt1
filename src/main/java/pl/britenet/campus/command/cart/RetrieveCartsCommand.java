package pl.britenet.campus.command.cart;

import pl.britenet.campus.Constants;
import pl.britenet.campus.Paginator;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.database.object.Cart;
import pl.britenet.campus.database.object.CartProducts;
import pl.britenet.campus.service.CartService;

import java.util.List;
import java.util.Scanner;

public class RetrieveCartsCommand extends Command {

    private final CartService cartService;

    public RetrieveCartsCommand(CartService cartService) {
        super(Constants.COMMAND_RETRIEVE_CARTS);
        this.cartService = cartService;
    }

    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ile rekordow na stronie?: ");
        int page = scan.nextInt();
        Paginator<Cart> paginator = new Paginator<>(this.cartService.getCarts(), page, "cartProducts");
        paginator.Paginate();
//        List<Cart> cartList = this.cartService.getCarts();
//        cartList.forEach( cart -> {
//            System.out.println(cart.getCartPrice());
//
//
//        } );

    }
    }


