package pl.britenet.campus.command.product;

import pl.britenet.campus.Constants;
import pl.britenet.campus.Paginator;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.database.object.CartProducts;
import pl.britenet.campus.database.object.Product;
import pl.britenet.campus.database.object.User;
import pl.britenet.campus.service.ProductService;

import java.util.List;
import java.util.Scanner;

public class RetrieveProductsCommand extends Command {

    private final ProductService productService;

    public RetrieveProductsCommand(ProductService productService) {
        super(Constants.COMMAND_RETRIEVE_PRODUCTS);
        this.productService = productService;
    }

    @Override
    public void execute() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Ile rekordow na stronie?: ");
        int page = scan.nextInt();
        Paginator<Product> paginator = new Paginator<>(this.productService.getProducts(), page, "Products:");
        paginator.Paginate();

//            List<Product> productList = this.productService.getProducts();
//     productList.forEach( product -> {
//            System.out.println("nazwa: " + product.getName());
//            System.out.println("opis: " + product.getDescription());
//            System.out.println("cena: " + product.getPrice());
//            System.out.println("zdjecie: " + product.getImages().getPaths());
//            System.out.println("--------------------------------------------");
//            System.out.println("aby zamknac wpisz -1");
//        } );
    }}
