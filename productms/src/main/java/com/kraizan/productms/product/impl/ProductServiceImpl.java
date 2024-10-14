package com.kraizan.productms.product.impl;

import com.kraizan.productms.product.Product;
import com.kraizan.productms.product.ProductRepository;
import com.kraizan.productms.product.ProductService;
import com.kraizan.productms.product.dto.ProductSellerDTO;
import com.kraizan.productms.product.external.Seller;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private ProductSellerDTO convertToProductSellerDTO(Product product){
        RestTemplate restTemplate = new RestTemplate();
        Seller seller = restTemplate.getForObject(
                "http://localhost:8081/api/v1/sellers/" + product.getSellerId(),
                Seller.class
            );
        return new ProductSellerDTO(product, seller);
    }

    @Override
    public List<ProductSellerDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(this::convertToProductSellerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public boolean addProduct(Product product) {
        try {
            productRepository.save(product);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateProduct(Long id, Product updatedProduct) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()){
            Product product = productOptional.get();
            product.setName(updatedProduct.getName());
            product.setDescription(updatedProduct.getDescription());
            product.setPrice(updatedProduct.getPrice());
            productRepository.save(product);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteProduct(Long id) {
        try {
            productRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
