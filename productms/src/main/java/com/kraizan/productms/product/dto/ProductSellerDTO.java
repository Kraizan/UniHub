package com.kraizan.productms.product.dto;

import com.kraizan.productms.product.Product;
import com.kraizan.productms.product.external.Seller;

public class ProductSellerDTO {
    private Product product;
    private Seller seller;

    public ProductSellerDTO(Product product, Seller seller) {
        this.product = product;
        this.seller = seller;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
