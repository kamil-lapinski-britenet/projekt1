package pl.britenet.campus.command.cart;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.database.object.Cart;
import pl.britenet.campus.database.object.Product;
import pl.britenet.campus.service.CartService;
import pl.britenet.campus.service.ProductService;

import java.util.Optional;
import java.util.Scanner;

public class GetCartCommand extends Command {

    private final CartService cartService;

    public GetCartCommand(CartService cartService) {
        super(Constants.COMMAND_GET_CART);
        this.cartService = cartService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("wprowadz id: ");
        String id = scanner.nextLine();
        Optional<Cart> cart = this.cartService.getCart(Integer.parseInt(id));
        cart.ifPresent(value -> System.out.println(String.valueOf(value.getCartId())+ ' ' +
                value.getCartPrice()
        ) );


    }

}
