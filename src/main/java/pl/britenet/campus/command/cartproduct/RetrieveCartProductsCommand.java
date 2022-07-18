package pl.britenet.campus.command.cartproduct;

import pl.britenet.campus.Constants;
import pl.britenet.campus.Paginator;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.database.object.CartProducts;
import pl.britenet.campus.database.object.OrderProducts;
import pl.britenet.campus.service.CartProductsService;

import java.util.List;
import java.util.Scanner;

public class RetrieveCartProductsCommand extends Command {

    private final CartProductsService cartProductsService;

    public RetrieveCartProductsCommand(CartProductsService cartProductsService) {
        super(Constants.COMMAND_RETRIEVE_CARTSPRODUCTS);
        this.cartProductsService = cartProductsService;
    }

    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ile rekordow na stronie?: ");
        int page = scan.nextInt();
        Paginator<CartProducts> paginator = new Paginator<>(this.cartProductsService.getCartsProducts(), page, "cartProducts");
        paginator.Paginate();



//      List<CartProducts> cartProductsList = this.cartProductsService.getCartsProducts();
//        cartProductsList.forEach( cartProducts -> {
//
//            System.out.println("nazwa produktu: " + cartProducts.getProduct().getName() +" | cena produktu: "+
//                    cartProducts.getProduct().getPrice()+" zl | ilosc produktow: " + cartProducts.getAmount()+" | id koszyka: "+
//                    cartProducts.getCart().getCartId()/*+" |cena koszyka: " + cartProducts.getCart().getCartPrice() + " zl"*/);
//            System.out.println("--------------------------------------------");
//        } );

    }
    }

