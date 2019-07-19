package javastart.javastart221;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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


    @GetMapping("/lista")
    public String productsInList(Model model) {

        model.addAttribute("products", productRepository.getProductList());
        model.addAttribute("price", productRepository.getTotalPrice());

        return "list";
    }


    @GetMapping("/tabela")
    public String productsInTable(Model model) {



        model.addAttribute("products", productRepository.getProductList());
        model.addAttribute("price", productRepository.getTotalPrice());


        return "table";
    }

    @RequestMapping("/add")
    public String addProduct(@RequestParam(defaultValue = "nieznany", required = true) String name
            , @RequestParam(required = true) double price) {

        getProductRepository().addProduct(new Product(name, price));
        return "redirect:/index.html";

    }


}
