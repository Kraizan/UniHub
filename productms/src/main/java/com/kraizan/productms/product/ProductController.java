package com.kraizan.productms.product;

import com.kraizan.productms.product.dto.ProductSellerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductSellerDTO>> getAllProducts() {
        List<ProductSellerDTO> productSellerDTO = productService.getAllProducts();
        if (productSellerDTO.isEmpty()) {
            return new ResponseEntity<>(productSellerDTO, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(productSellerDTO, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        boolean isAdded = productService.addProduct(product);
        if (isAdded) {
            return new ResponseEntity<>("Product added successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to add product", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductSellerDTO> getProductById(@PathVariable Long id) {
        ProductSellerDTO productSellerDTO = productService.getProductById(id);
        if (productSellerDTO != null) {
            return new ResponseEntity<>(productSellerDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        boolean isUpdated = productService.updateProduct(id, updatedProduct);
        if (isUpdated) {
            return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update product with id " + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        boolean isDeleted = productService.deleteProduct(id);
        if (isDeleted) {
            return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to delete product", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
