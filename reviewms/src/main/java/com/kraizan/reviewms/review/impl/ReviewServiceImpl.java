package com.kraizan.reviewms.review.impl;

import com.kraizan.reviewms.review.Review;
import com.kraizan.reviewms.review.ReviewRepository;
import com.kraizan.reviewms.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews(Long sellerId) {
        return reviewRepository.findBySellerId(sellerId);
    }

    @Override
    public boolean addReview(Long sellerId, Review review) {
        if(sellerId != null && review != null){
            review.setSellerId(sellerId);
            reviewRepository.save(review);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateReview(Long id, Review updatedReview) {
        Review review = reviewRepository.findById(id).orElse(null);
        if(review != null) {
            review.setTitle(updatedReview.getTitle());
            review.setDescription(updatedReview.getDescription());
            review.setRating(updatedReview.getRating());
            reviewRepository.save(review);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean deleteReview(Long id) {
        Review review = reviewRepository.findById(id).orElse(null);
        if(review != null) {
            reviewRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }
}
