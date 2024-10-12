package com.kraizan.sellerms.seller.impl;

import com.kraizan.sellerms.seller.Seller;
import com.kraizan.sellerms.seller.SellerRepository;
import com.kraizan.sellerms.seller.SellerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService {
    private final SellerRepository sellerRepository;

    public SellerServiceImpl(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    @Override
    public boolean createSeller(Seller seller) {
        try {
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
}
