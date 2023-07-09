package com.uade.screenspace.service;

import com.uade.screenspace.entity.SeatReserved;
import io.screenspace.model.CreateReviewRequest;
import io.screenspace.model.Review;

import java.util.List;

public interface IReviewService {
    List<Review> getReviewsByMovie(String movieId);

    void createReview(String movieId, CreateReviewRequest review);
}
