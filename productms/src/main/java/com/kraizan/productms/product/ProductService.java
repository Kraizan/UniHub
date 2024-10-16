package com.kraizan.productms.product;

import com.kraizan.productms.product.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();
    ProductDTO getProductById(Long id);
    boolean addProduct(Product product);
    boolean updateProduct(Long id, Product updatedProduct);
    boolean deleteProduct(Long id);
}
