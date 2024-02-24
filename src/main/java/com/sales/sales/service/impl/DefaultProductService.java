package com.sales.sales.service.impl;

import com.sales.sales.dto.ProductDto;
import com.sales.sales.exception.ClientNotFoundException;
import com.sales.sales.model.Product;
import com.sales.sales.repository.ProductRepository;
import com.sales.sales.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static java.lang.String.format;

/**
 * @author Reem Gharib
 */
@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService {

    private final ProductRepository productRepository;


    @Override
    public List<Product> getAllProducts() {

        List<Product> products = this.productRepository.findAll();

        return products;
    }

    @Override
    public Product createProduct(ProductDto product) {

        Product productEntity = Product.builder()
                .name(product.getName())
                .description(product.getDescription())
                .category(product.getCategory())
                .creationDate(LocalDateTime.now())
                .build();

        this.productRepository.save(productEntity);

        return productEntity;
    }

    @Override
    public Product updateProduct(ProductDto product, String id) {

        Product productEntity = this.productRepository.findById(Long.valueOf(id)).orElseThrow(
                () -> new ClientNotFoundException(format("Product not found by id : %s", id)));

        productEntity.setName(product.getName());
        productEntity.setDescription(product.getDescription());
        productEntity.setCategory(product.getCategory());

        this.productRepository.save(productEntity);

        return productEntity;
    }
}
