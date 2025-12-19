package com.arafat.career_hub.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
        if(reviewService.getALlReviews(companyId) != null)
            return ResponseEntity.ok(reviewService.getALlReviews(companyId));
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> createReview(@PathVariable Long companyId, @RequestBody Review review) {
        Boolean isExistCompany = reviewService.createReview(companyId, review);
        if(isExistCompany) {
            return new ResponseEntity<>("Review Created Successfully", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Company not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long companyId, @PathVariable Long reviewId) {
        Review review = reviewService.getReviewById(companyId, reviewId);
        if(review != null)
            return ResponseEntity.ok(review);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
