package com.kraizan.reviewms.review.messaging;

import com.kraizan.reviewms.review.Review;
import com.kraizan.reviewms.review.dto.ReviewMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReviewMessageProducer {
    private final RabbitTemplate rabbitTemplate;

    public ReviewMessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Review review){
        ReviewMessage reviewMessage = new ReviewMessage(review.getId(), review.getTitle(), review.getDescription(), review.getRating(), review.getSellerId());
        rabbitTemplate.convertAndSend("sellerRatingQueue", reviewMessage);
    }
}
