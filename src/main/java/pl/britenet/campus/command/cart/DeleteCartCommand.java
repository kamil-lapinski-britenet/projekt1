package pl.britenet.campus.command.cart;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.service.CartService;

import java.util.Scanner;

public class DeleteCartCommand extends Command {

    private final CartService cartService;

    public DeleteCartCommand(CartService cartService) {
        super(Constants.COMMAND_DELETE_CART);
        this.cartService = cartService;
    }

    @Override
    public void execute (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("wprowadz id: ");
        String id = scanner.nextLine();
        this.cartService.deleteCart(Integer.parseInt(id));

    }

}
