package com.kraizan.productms.product.dto;

import com.kraizan.productms.product.Product;
import com.kraizan.productms.product.external.Seller;

import java.math.BigDecimal;

public class ProductSellerDTO {
    private Long id;
    private Long sellerId;
    private String name;
    private String description;
    private BigDecimal price;
    private Seller seller;

    public ProductSellerDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
