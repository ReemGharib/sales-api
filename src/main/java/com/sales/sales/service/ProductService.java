package com.sales.sales.service;

import com.sales.sales.dto.ProductDto;
import com.sales.sales.model.Product;

import java.util.List;

/**
 * @author Reem Gharib
 */
public interface ProductService {

    List<Product> getAllProducts();

    Product createProduct(ProductDto product);

    Product updateProduct(ProductDto product, String id);
}
