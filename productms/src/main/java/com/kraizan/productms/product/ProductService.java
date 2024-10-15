package com.kraizan.productms.product;

import com.kraizan.productms.product.dto.ProductSellerDTO;

import java.util.List;

public interface ProductService {
    List<ProductSellerDTO> getAllProducts();
    ProductSellerDTO getProductById(Long id);
    boolean addProduct(Product product);
    boolean updateProduct(Long id, Product updatedProduct);
    boolean deleteProduct(Long id);
}
