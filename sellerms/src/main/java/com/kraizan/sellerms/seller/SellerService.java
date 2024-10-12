package com.kraizan.sellerms.seller;

import java.util.List;

public interface SellerService {
    List<Seller> getAllSellers();
    boolean createSeller(Seller seller);
    Seller getSellerById(Long id);
    boolean updateSeller(Long id, Seller updatedSeller);
    boolean deleteSeller(Long id);
}
