package mateacademy.internetshop;

import java.util.List;
import mateacademy.internetshop.lib.Injector;
import mateacademy.internetshop.model.Product;
import mateacademy.internetshop.service.ProductService;

public class Application {
    private static Injector injector = Injector.getInstance("mateacademy.internetShop");

    public static void main(String[] args) {
        ProductService productService = (ProductService) injector.getInstance(ProductService.class);
        initializedDb(productService);
        List<Product> allProducts = productService.getAll();
        for (Product product : allProducts) {
            System.out.println(product.toString());
        }
    }

    public static void initializedDb(ProductService productService) {
        Product product1 = new Product("BMV", 70_00);
        Product product2 = new Product("Audi", 77_0);
        Product product3 = new Product("Opel", 10_0);
        productService.create(product1);
        productService.create(product2);
        productService.create(product3);
    }
}
