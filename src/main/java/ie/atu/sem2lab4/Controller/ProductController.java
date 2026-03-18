package ie.atu.sem2lab4.Controller;

import ie.atu.sem2lab4.Model.Product;
import ie.atu.sem2lab4.Service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping("/allProducts")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchByName( @RequestParam @NotBlank(message = "The search cannot be empty") String name) {
        List<Product> result = productService.getAllProducts().stream().filter(product -> product.getName().toLowerCase().contains(name.toLowerCase())).toList();

        return ResponseEntity.ok().body(result);
    }
}
