package com.uade.screenspace.controller;

import com.uade.screenspace.service.ReviewService;
import io.screenspace.api.ReviewsApi;
import io.screenspace.model.CreateReview200Response;
import io.screenspace.model.CreateReviewRequest;
import io.screenspace.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewsController implements ReviewsApi {
    @Autowired
    ReviewService reviewService;

    public ResponseEntity<List<Review>> getReviewsByMovie(String movieId) {
        List<Review> reviews = reviewService.getReviewsByMovie(movieId);
        return ResponseEntity.ok(reviews);
    }

    public ResponseEntity<CreateReview200Response> createReview(String movieId, CreateReviewRequest review) {
        reviewService.createReview(movieId, review);
        return ResponseEntity.ok().build();
    }
}
