package com.kraizan.productms.product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    boolean addProduct(Product product);
    boolean updateProduct(Long id, Product updatedProduct);
    boolean deleteProduct(Long id);
}
