package javastart.javastart221;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> productList = new ArrayList<>();

    public ProductRepository() {
        addProduct(new Product("Proszek", 19.99));
        addProduct(new Product("Soda", 12.99));
        addProduct(new Product("Płyta Cd", 3.99));
    }

    List<Product> getProductList() {
        return productList;
    }


    void addProduct(Product product) {
        this.getProductList().add(product);
    }





    public Double getTotalPrice() {
        Double sum = 0.0;
        for (Product product : getProductList()) {
            sum += product.getPrice();
        }
        return sum;
    }
}
