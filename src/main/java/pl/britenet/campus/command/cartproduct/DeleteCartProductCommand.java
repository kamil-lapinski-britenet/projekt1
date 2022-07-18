package pl.britenet.campus.command.cartproduct;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.service.CartProductsService;
import pl.britenet.campus.service.CartService;

import java.util.Scanner;

public class DeleteCartProductCommand extends Command {

    private final CartProductsService cartProductsService;

    public DeleteCartProductCommand(CartProductsService cartProductsService) {
        super(Constants.COMMAND_DELETE_CARTPRODUCT);
        this.cartProductsService = cartProductsService;
    }

    @Override
    public void execute (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("wprowadz id: ");
        String id = scanner.nextLine();
        this.cartProductsService.deleteCartProduct(Integer.parseInt(id));

    }
}
