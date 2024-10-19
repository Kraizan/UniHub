package com.kraizan.sellerms.seller.messaging;

import com.kraizan.sellerms.seller.SellerService;
import com.kraizan.sellerms.seller.dto.ReviewMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ReviewMessageConsumer {
    private final SellerService sellerService;

    public ReviewMessageConsumer(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @RabbitListener(queues = "sellerRatingQueue")
    public void consumeMessage(ReviewMessage reviewMessage){
        sellerService.updateSellerRating(reviewMessage);
    }
}
