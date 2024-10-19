package com.kraizan.reviewms.review.dto;

public class ReviewMessage {
    private Long id;
    private String title;
    private String description;
    private double rating;
    private Long sellerId;

    public ReviewMessage(Long id, String title, String description, double rating, Long sellerId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.sellerId = sellerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
}
