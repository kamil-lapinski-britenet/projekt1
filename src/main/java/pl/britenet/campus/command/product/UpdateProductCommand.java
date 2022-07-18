package pl.britenet.campus.command.product;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.database.object.Product;
import pl.britenet.campus.service.ProductService;

import java.util.Optional;
import java.util.Scanner;

public class UpdateProductCommand extends Command {

    private final ProductService productService;

    public UpdateProductCommand(ProductService productService) {
        super(Constants.COMMAND_UPDATE_PRODUCT);
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        System.out.println("ID:");
        int id = Integer.parseInt(scan.nextLine());
        final Product[] product = {new Product()};
        this.productService.getProduct(id).ifPresent(value ->
                product[0] = value
        );
        Product temp = product[0];
        System.out.println("Name:");
        temp.setName(scan.nextLine());
        System.out.println("Description:");
        temp.setDescription(scan.nextLine());
        System.out.println("Price:");
        temp.setPrice(Double.parseDouble(scan.nextLine()));
        productService.updateProduct(temp);
    }

}
