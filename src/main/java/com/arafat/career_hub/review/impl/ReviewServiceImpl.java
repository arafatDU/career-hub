package com.arafat.career_hub.review.impl;

import com.arafat.career_hub.company.Company;
import com.arafat.career_hub.company.CompanyService;
import com.arafat.career_hub.review.Review;
import com.arafat.career_hub.review.ReviewRepository;
import com.arafat.career_hub.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getALlReviews(Long companyId) {
        if(companyService.getCompanyById(companyId) != null)
            return reviewRepository.findByCompanyId(companyId);
        return null;
    }

    @Override
    public Boolean createReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if(company != null) {
            review.setId(null);
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReviewById(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream().filter(review -> review.getId().equals(reviewId)).findFirst().orElse(null);
    }
}
