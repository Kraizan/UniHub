package com.kraizan.reviewms.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long sellerId);
    boolean addReview(Long sellerId, Review review);
    Review getReviewById(Long id);
    boolean updateReview(Long id, Review updatedReview);
    boolean deleteReview(Long id);
}
