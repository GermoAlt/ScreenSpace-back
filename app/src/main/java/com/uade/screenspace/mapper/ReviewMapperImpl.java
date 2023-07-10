package com.uade.screenspace.mapper;

import com.uade.screenspace.entity.*;
import io.screenspace.model.CreateReviewRequest;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapperImpl implements ReviewMapper{

    @Override
    public io.screenspace.model.Review mapToReviewModel(Review review) {
        io.screenspace.model.Review reviewModel = new io.screenspace.model.Review();
        reviewModel.setComment(mapToCommentModel(review.getComment()));
        reviewModel.setRating(mapToRatingModel(review.getRating()));
        reviewModel.setMovieId(review.getMovieId());
        reviewModel.setId(review.getId());
        return reviewModel;
    }

    @Override
    public Review mapCreateReviewRequestToReview(CreateReviewRequest createReviewRequest, Object principalUser) {
        Review review = new Review();
        review.setRating(mapToRating(createReviewRequest.getRating(), principalUser));
        review.setComment(mapToComment(createReviewRequest.getComment()));
        review.setMovieId(createReviewRequest.getMovieId());
        return review;
    }

    private Rating mapToRating(io.screenspace.model.Rating ratingModel, Object principalUser) {
        Rating rating = new Rating();
        rating.setRating(ratingModel.getRating());
        rating.setUser((User)principalUser);
        return rating;
    }

    private Comment mapToComment(io.screenspace.model.Comment commentModel) {
        return new Comment(commentModel.getComment());
    }

    private io.screenspace.model.Rating mapToRatingModel(Rating rating) {
        io.screenspace.model.Rating ratingModel = new io.screenspace.model.Rating();
        ratingModel.setRating(rating.getRating());
        return ratingModel;
    }

    private io.screenspace.model.Comment mapToCommentModel(Comment comment) {
        io.screenspace.model.Comment commentModel = new io.screenspace.model.Comment();
        commentModel.setComment(comment.getComment());
        return commentModel;
    }

    public io.screenspace.model.User mapToUser(User user) {
        if (user == null) {
            return null;
        }
        io.screenspace.model.User userModel = new io.screenspace.model.User();
        userModel.setEmail(user.getEmail());
        return userModel;
    }
}
