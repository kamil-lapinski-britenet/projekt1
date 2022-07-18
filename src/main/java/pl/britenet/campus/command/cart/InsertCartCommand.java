package pl.britenet.campus.command.cart;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.database.object.Cart;
import pl.britenet.campus.service.CartService;

import java.util.Scanner;

public class InsertCartCommand extends Command {

    private final CartService cartService;

    public InsertCartCommand(CartService cartService) {
        super(Constants.COMMAND_INSERT_CART);
        this.cartService = cartService;
    }

    @Override
    public void execute() {
        System.out.println("wprowadz cene koszyka: ");
        Scanner scanner = new Scanner(System.in);
        double price = scanner.nextDouble();
        Cart cart = new Cart();
        cart.setCartPrice(price);
        this.cartService.insertCart(cart);


    }

}
