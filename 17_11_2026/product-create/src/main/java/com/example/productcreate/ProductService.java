package com.example.productcreate;



import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final List<Product> products = new ArrayList<>();
    private long nextId = 1L;

    public ProductService() {
        // Pre-populate with initial items so the next ID becomes 3
        products.add(new Product(nextId++, "Keyboard", 49.99));
        products.add(new Product(nextId++, "Mouse", 19.99));
    }

    public Product addProduct(Product product) {
        product.setId(nextId++); // Assign next ID and increment
        products.add(product);
        return product;
    }
}