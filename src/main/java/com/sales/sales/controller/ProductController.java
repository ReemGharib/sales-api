package com.sales.sales.controller;

import com.sales.sales.dto.ProductDto;
import com.sales.sales.model.Product;
import com.sales.sales.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Reem Gharib
 */
@RequiredArgsConstructor
@RequestMapping("products")
@Controller
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {

        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> persistProduct(@RequestBody ProductDto product) {

        return new ResponseEntity<>(this.productService.createProduct(product), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody ProductDto product, @PathVariable(name = "id") String id) {

        return new ResponseEntity<>(this.productService.updateProduct(product, id), HttpStatus.CREATED);
    }
}
