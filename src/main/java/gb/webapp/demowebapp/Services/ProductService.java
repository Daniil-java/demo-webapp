package gb.webapp.demowebapp.Services;

import gb.webapp.demowebapp.Objects.Product;
import gb.webapp.demowebapp.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product setProduct(Product product) {
        return productRepository.findById(productRepository.insert(product));
    }
}
