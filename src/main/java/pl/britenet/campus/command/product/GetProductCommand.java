package pl.britenet.campus.command.product;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.database.object.Product;
import pl.britenet.campus.service.ProductService;

import java.util.Optional;
import java.util.Scanner;

public class GetProductCommand extends Command {

    private final ProductService productService;

    public GetProductCommand(ProductService productService) {
        super(Constants.COMMAND_GET_PRODUCT);
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("wprowadz id: ");
        String id = scanner.nextLine();
        Optional<Product> product = this.productService.getProduct(Integer.parseInt(id));
        product.ifPresent(value -> System.out.println(String.valueOf(value.getProductId())+ ' ' +
               value.getName() + ' ' + value.getDescription() + ' ' + value.getPrice()
               ) );


    }
}