package pl.britenet.campus.command.cartproduct;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.database.object.CartProducts;
import pl.britenet.campus.database.object.Order;
import pl.britenet.campus.service.CartProductsService;


import java.util.Optional;
import java.util.Scanner;

public class GetCartProductCommand extends Command {

    private final CartProductsService cartProductsService;

    public GetCartProductCommand(CartProductsService cartProductsService) {
        super(Constants.COMMAND_GET_CARTPRODUCT);
        this.cartProductsService = cartProductsService;
    }

    @Override
    public void execute ()  {

        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        Optional<CartProducts> cartProducts = this.cartProductsService.getCartProduct(Integer.parseInt(id));
        cartProducts.ifPresent(value -> System.out.println(String.valueOf(value.getAmount())));

    }

}
