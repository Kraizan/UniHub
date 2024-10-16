package com.kraizan.productms.product.clients;

import com.kraizan.productms.product.external.Seller;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "SELLERMS" + "/api/v1")
public interface SellerClient {

    @GetMapping("/sellers/{id}")
    Seller getSeller(@PathVariable Long id);
}
