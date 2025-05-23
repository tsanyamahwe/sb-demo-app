
package com.dailycodework.sbdemoapp.view;

import com.dailycodework.sbdemoapp.model.Product;
import com.dailycodework.sbdemoapp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements CommandLineRunner {
    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        // Check if products already exist to avoid duplicates
        if (productRepository.count() == 0) {
            final List<Product> products = Arrays.asList(
                    new Product(null, "Samsung", 100, "Some smart phones"), // null ID for auto-generation
                    new Product(null, "iPhone", 500, "Some smart phones"),
                    new Product(null, "Sneakers", 70, "Some smart shoes"),
                    new Product(null, "Dell", 200, "Some smart laptops"),
                    new Product(null, "HP", 100, "Some smart computer"));

            productRepository.saveAll(products);
            System.out.println("Sample products loaded successfully!");
        } else {
            System.out.println("Products already exist, skipping data loading.");
        }
    }

    // Alternative method if you need to clear and reload data
    public void clearAndReloadProducts() throws Exception {
        productRepository.deleteAll();
        run(); // reload fresh data
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }
}