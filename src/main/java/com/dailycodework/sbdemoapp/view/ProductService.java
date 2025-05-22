package com.dailycodework.sbdemoapp.view;

import com.dailycodework.sbdemoapp.model.Product;
import com.dailycodework.sbdemoapp.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    /*private final List<Product> products = Arrays.asList(
            new Product(1L, "Samsung", 100, "Some smart phones"),
            new Product(2L, "iPhone", 500, "Some smart phones"),
            new Product(3L, "Sneakers", 70, "Some smart shoes"),
            new Product(4L, "Dell", 200, "Some smart laptops"),
            new Product(5L, "HP", 100, "Some smart computer"));*/

    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    /*
    @PostConstruct
    public List<Product> saveProducts(){
        return productRepository.saveAll(products);
    }*/
}
