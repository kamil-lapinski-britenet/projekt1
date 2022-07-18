package pl.britenet.campus.command.product;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.database.object.Product;
import pl.britenet.campus.service.OrderService;
import pl.britenet.campus.service.ProductService;

import java.util.Optional;
import java.util.Scanner;

public class InsertProductCommand extends Command {

    private final ProductService productService;

    public InsertProductCommand(ProductService productService) {
        super(Constants.COMMAND_INSERT_PRODUCT);
        this.productService = productService;
    }

    @Override
    public void execute() {
        System.out.println("wprowadz nazwe, opis i cene: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String description = scanner.nextLine();

        double price = scanner.nextDouble();
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);

        this.productService.insertProduct(product);
    }
}
