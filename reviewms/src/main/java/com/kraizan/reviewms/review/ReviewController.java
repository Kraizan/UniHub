package com.kraizan.reviewms.review;

import com.kraizan.reviewms.review.messaging.ReviewMessageProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;
    private final ReviewMessageProducer reviewMessageProducer;

    public ReviewController(ReviewService reviewService, ReviewMessageProducer reviewMessageProducer) {
        this.reviewService = reviewService;
        this.reviewMessageProducer = reviewMessageProducer;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(@RequestParam Long sellerId) {
        List<Review> reviews = reviewService.getAllReviews(sellerId);
        if (reviews.isEmpty()) {
            return new ResponseEntity<>(reviews, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(reviews, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<String> addReview(@RequestParam Long sellerId, @RequestBody Review review) {
        boolean isAdded = reviewService.addReview(sellerId, review);
        if (isAdded) {
            reviewMessageProducer.sendMessage(review);
            return new ResponseEntity<>("Review added successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to add review", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        Review review = reviewService.getReviewById(id);
        if (review != null) {
            return new ResponseEntity<>(review, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateReview(@PathVariable Long id, @RequestBody Review review) {
        boolean isUpdated = reviewService.updateReview(id, review);
        if (isUpdated) {
            return new ResponseEntity<>("Review updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update review", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable Long id) {
        boolean isDeleted = reviewService.deleteReview(id);
        if (isDeleted) {
            return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to delete review", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/averageRating")
    public ResponseEntity<Double> getAverageRating(@RequestParam Long sellerId){
        List<Review> reviews = reviewService.getAllReviews(sellerId);
        return new ResponseEntity<>(reviews.stream().mapToDouble(Review::getRating).average().orElse(0.0), HttpStatus.OK);
    }
}

