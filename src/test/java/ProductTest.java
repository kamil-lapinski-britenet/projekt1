
import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.database.object.Product;
import pl.britenet.campus.service.ProductService;
import org.junit.jupiter.api.*;

import java.util.List;

public class ProductTest {
    private ProductService productService;
    private DatabaseService databaseService;

    @BeforeEach
    public void setup() {
        this.databaseService = new DatabaseService();
        this.productService = new ProductService(databaseService);

    }

    @Test
    public void getProductsTest() {
        assert !this.productService.getProducts().isEmpty();
    }

    @Test
    public void getProductTest() {
       Product product = new Product(1, "test", "test", 1);
        productService.insertProduct(product);
        List<Product> newlist  = productService.getProducts();
        assert this.productService.getProduct(newlist.get(newlist.size()-1).getProductId()).isPresent();
        productService.deleteProduct(newlist.get(newlist.size()-1).getProductId());
    }

    @Test
    public void deleteProductTest() {
        Product product = new Product(1, "test", "test", 1);
        productService.insertProduct(product);
        List<Product> newlist  = productService.getProducts();
        productService.deleteProduct(newlist.get(newlist.size()-1).getProductId());
        assert this.productService.getProducts().size() < newlist.size();
    }

    @Test
    public void insertProductTest() {
        List<Product> newlist  = productService.getProducts();
        Product product = new Product(1, "test", "test", 1);
        productService.insertProduct(product);
        List<Product> newlistTwo  = productService.getProducts();
        assert newlistTwo.size() > newlist.size();
        productService.deleteProduct(newlistTwo.get(newlistTwo.size()-1).getProductId());
    }

}