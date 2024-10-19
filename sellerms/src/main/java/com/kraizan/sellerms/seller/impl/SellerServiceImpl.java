package com.kraizan.sellerms.seller.impl;

import com.kraizan.sellerms.seller.Seller;
import com.kraizan.sellerms.seller.SellerRepository;
import com.kraizan.sellerms.seller.SellerService;
import com.kraizan.sellerms.seller.clients.ReviewClient;
import com.kraizan.sellerms.seller.dto.ReviewMessage;
import jakarta.ws.rs.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService {
    private final SellerRepository sellerRepository;
    private final ReviewClient reviewClient;

    public SellerServiceImpl(SellerRepository sellerRepository, ReviewClient reviewClient) {
        this.sellerRepository = sellerRepository;
        this.reviewClient = reviewClient;
    }

    @Override
    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    @Override
    public boolean createSeller(Seller seller) {
        try {
            seller.setRating(0.0);
            sellerRepository.save(seller);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public Seller getSellerById(Long id) {
        return sellerRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateSeller(Long id, Seller updatedSeller) {
        Optional<Seller> sellerOptional = sellerRepository.findById(id);
        if(sellerOptional.isPresent()){
            Seller seller = sellerOptional.get();
            seller.setName(updatedSeller.getName());
            seller.setDescription(updatedSeller.getDescription());
            sellerRepository.save(seller);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteSeller(Long id) {
        try {
            sellerRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void updateSellerRating(ReviewMessage reviewMessage) {
        Seller seller = sellerRepository.findById(reviewMessage.getSellerId()).orElseThrow(() -> new NotFoundException("Seller not found"));
        Double averageRating = reviewClient.getAverageRating(reviewMessage.getSellerId());
        seller.setRating(averageRating);
        sellerRepository.save(seller);
    }
}
