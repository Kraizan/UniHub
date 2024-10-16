package com.kraizan.sellerms.seller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sellers")
public class SellerController {
    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping
    public ResponseEntity<List<Seller>> getAllSellers() {
        List<Seller> sellers = sellerService.getAllSellers();
        if (sellers.isEmpty()) {
            return new ResponseEntity<>(sellers, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(sellers, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<String> createSeller(@RequestBody Seller seller) {
        boolean isCreated = sellerService.createSeller(seller);
        if (isCreated) {
            return new ResponseEntity<>("Seller created successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to create seller", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seller> getSellerById(@PathVariable Long id) {
        Seller seller = sellerService.getSellerById(id);
        if (seller != null) {
            return new ResponseEntity<>(seller, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateSeller(@PathVariable Long id, @RequestBody Seller updatedSeller) {
        boolean isUpdated = sellerService.updateSeller(id, updatedSeller);
        if (isUpdated) {
            return new ResponseEntity<>("Seller updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update seller", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSeller(@PathVariable Long id) {
        boolean isDeleted = sellerService.deleteSeller(id);
        if (isDeleted) {
            return new ResponseEntity<>("Seller deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to delete seller", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}