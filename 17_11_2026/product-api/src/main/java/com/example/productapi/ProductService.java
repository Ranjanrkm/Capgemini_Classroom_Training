package com.example.productapi;



import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();

    public ProductService() {
        // Adding the exact products from your requirement screenshot
        products.add(new Product(1L, "Keyboard", 49.99));
        products.add(new Product(2L, "Mouse", 19.99));
    }

    public List<Product> getAllProducts() {
        return products;
    }
}