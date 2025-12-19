package com.arafat.career_hub.review;

import java.util.List;

public interface ReviewService {
    List<Review> getALlReviews(Long companyId);

    Boolean createReview(Long companyId, Review review);

    Review getReviewById(Long companyId, Long reviewId);
}
