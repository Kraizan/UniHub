package com.kraizan.reviewms.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
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
}

