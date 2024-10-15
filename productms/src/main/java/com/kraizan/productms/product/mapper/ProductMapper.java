package com.kraizan.productms.product.mapper;

import com.kraizan.productms.product.Product;
import com.kraizan.productms.product.dto.ProductSellerDTO;
import com.kraizan.productms.product.external.Seller;

public class ProductMapper {
    public ProductSellerDTO mapToProductSellerDTO(Product product, Seller seller){
        ProductSellerDTO productSellerDTO = new ProductSellerDTO();
        productSellerDTO.setId(product.getId());
        productSellerDTO.setName(product.getName());
        productSellerDTO.setDescription(product.getDescription());
        productSellerDTO.setPrice(product.getPrice());
        productSellerDTO.setSeller(seller);

        return productSellerDTO;
    }
}
