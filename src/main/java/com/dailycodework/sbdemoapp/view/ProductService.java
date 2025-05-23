package com.dailycodework.sbdemoapp.view;

import com.dailycodework.sbdemoapp.model.Product;
import com.dailycodework.sbdemoapp.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Component
public class ProductService implements CommandLineRunner {
    @Autowired
    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        final List<Product> products = Arrays.asList(
                new Product(1L, "Samsung", 100, "Some smart phones"),
                new Product(2L, "iPhone", 500, "Some smart phones"),
                new Product(3L, "Sneakers", 70, "Some smart shoes"),
                new Product(4L, "Dell", 200, "Some smart laptops"),
                new Product(5L, "HP", 100, "Some smart computer"));

        productRepository.saveAll(products);
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    /*
    @PostConstruct
    public List<Product> saveProducts(){
        return productRepository.saveAll(products);
    }*/
}
