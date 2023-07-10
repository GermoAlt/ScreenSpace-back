package com.uade.screenspace.mapper;

import com.uade.screenspace.entity.*;
import io.screenspace.model.CreateReviewRequest;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapperImpl implements ReviewMapper{
    @Override
    public Review mapToReview(io.screenspace.model.Review reviewModel) {
        Review review = new Review();
        review.setComment(reviewModel.getComment());
        review.setRating(reviewModel.getRating());
        return review;
    }

    @Override
    public io.screenspace.model.Review mapToReviewModel(Review review) {
        io.screenspace.model.Review reviewModel = new io.screenspace.model.Review();
        reviewModel.setComment(review.getComment());
        reviewModel.setRating(review.getRating());
        return reviewModel;
    }

    @Override
    public Review mapCreateReviewRequestToReview(CreateReviewRequest createReviewRequest, Object principal) {
        Review review = new Review();
        review.setRating(createReviewRequest.getRating());
        review.setComment(createReviewRequest.getComment());
        review.getRating().setUser((io.screenspace.model.User) principal);
        return review;
    }
}
