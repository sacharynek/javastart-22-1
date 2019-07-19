package javastart.javastart221;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController {

    private ProductRepository productRepository;

    private ProductRepository getProductRepository() {
        return productRepository;
    }

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @ResponseBody
    @GetMapping("/lista")
    public String productsInList() {
        List<Product> products;
        Double price;


        products = productRepository.getProductList();
        price = productRepository.getTotalPrice();


        return products.toString() + "<h2> Total Price = " + price + "</h2>";
    }

    @ResponseBody
    @GetMapping("/tabela")
    public String productsInTable() {
        List<Product> products;
        Double price;


        products = productRepository.getProductList();
        price = productRepository.getTotalPrice();


        return products.toString() + "<h2> Total Price = " + price + "</h2>";
    }

    @RequestMapping("/add")
    public String addProduct(@RequestParam(defaultValue = "nieznany", required = true) String name
            , @RequestParam(required = true) double price) {

        getProductRepository().addProduct(new Product(name, price));
        return "redirect:/index.html";

    }


}
