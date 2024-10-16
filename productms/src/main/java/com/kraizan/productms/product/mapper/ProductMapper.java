package com.kraizan.productms.product.mapper;

import com.kraizan.productms.product.Product;
import com.kraizan.productms.product.dto.ProductDTO;
import com.kraizan.productms.product.external.Review;
import com.kraizan.productms.product.external.Seller;

import java.util.List;

public class ProductMapper {
    public ProductDTO mapToProductSellerDTO(Product product, Seller seller, List<Review> reviews){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setSeller(seller);
        productDTO.setReviews(reviews);

        return productDTO;
    }
}
