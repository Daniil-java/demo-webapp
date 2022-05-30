package gb.webapp.demowebapp.Controllers;

import gb.webapp.demowebapp.Objects.Product;
import gb.webapp.demowebapp.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

//    @GetMapping("/products")
//    public List<Product> getAllProducts() {
//        return productService.getAllProducts();
//    }
//
//    @PutMapping("/products")
//    public Product setProduct(@RequestBody Product product) {
//        return productService.setProduct(product);
//    }

    @GetMapping(value = "/products")
    public String getAll(Model model) {
        productService.setProduct(new Product("beer", 10));
        model.addAttribute("prods", productService.getAllProducts());
        return "products";
    }

    @GetMapping("/form")
    public String getForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "form";
    }

    @PostMapping ("/form")
    public String setProductFromForm(Product product) {
        productService.setProduct(product);
        System.out.println("ANYTHING");
        product.getName();
        return "products";
    }


}
