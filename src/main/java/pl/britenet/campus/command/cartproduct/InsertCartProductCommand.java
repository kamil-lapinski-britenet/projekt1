package pl.britenet.campus.command.cartproduct;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.database.object.Cart;
import pl.britenet.campus.database.object.CartProducts;
import pl.britenet.campus.service.CartProductsService;
import pl.britenet.campus.service.CartService;

import java.util.Scanner;

public class InsertCartProductCommand extends Command {

    private final CartProductsService cartProductsService;

    public InsertCartProductCommand(CartProductsService cartProductsService) {
        super(Constants.COMMAND_INSERT_CARTPRODUCT);
        this.cartProductsService = cartProductsService;
    }

    @Override
    public void execute() {
        System.out.println("wprowadz ilosc: ");
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        CartProducts cartProducts = new CartProducts();
        cartProducts.setAmount(amount);
        this.cartProductsService.insertCartProduct(cartProducts);


    }


}
