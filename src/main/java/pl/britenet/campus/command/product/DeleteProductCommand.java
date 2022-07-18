package pl.britenet.campus.command.product;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;
import pl.britenet.campus.database.object.Product;
import pl.britenet.campus.service.ProductService;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;

public class DeleteProductCommand extends Command {

    private final ProductService productService;

    public DeleteProductCommand(ProductService productService) {
        super(Constants.COMMAND_DELETE_PRODUCT);
        this.productService = productService;
    }

    @Override
    public void execute() {


            Scanner scanner = new Scanner(System.in);
            System.out.println("wprowadz id: ");
            String id = scanner.nextLine();
            this.productService.deleteProduct(Integer.parseInt(id));



    }

}
