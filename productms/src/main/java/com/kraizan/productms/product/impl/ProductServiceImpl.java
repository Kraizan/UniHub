package com.kraizan.productms.product.impl;

import com.kraizan.productms.product.Product;
import com.kraizan.productms.product.ProductRepository;
import com.kraizan.productms.product.ProductService;
import com.kraizan.productms.product.clients.ReviewClient;
import com.kraizan.productms.product.clients.SellerClient;
import com.kraizan.productms.product.dto.ProductDTO;
import com.kraizan.productms.product.external.Review;
import com.kraizan.productms.product.external.Seller;
import com.kraizan.productms.product.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final SellerClient sellerClient;
    private final ReviewClient reviewClient;

    public ProductServiceImpl(ProductRepository productRepository, SellerClient sellerClient, ReviewClient reviewClient) {
        this.productRepository = productRepository;
        this.sellerClient = sellerClient;
        this.reviewClient = reviewClient;
    }

    private ProductDTO convertToProductSellerDTO(Product product){
        Seller seller = sellerClient.getSeller(product.getSellerId());
        List<Review> reviews = reviewClient.getReviews(product.getSellerId());
        ProductMapper productMapper = new ProductMapper();
        ProductDTO productDTO = productMapper.mapToProductSellerDTO(product, seller, reviews);
        return productDTO;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(this::convertToProductSellerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        assert product != null;
        return convertToProductSellerDTO(product);
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
