package com.uade.screenspace.service;

import com.uade.screenspace.entity.Cinema;
import com.uade.screenspace.entity.Movie;
import com.uade.screenspace.entity.Review;
import com.uade.screenspace.entity.User;
import com.uade.screenspace.exceptions.EntityNotFound;
import com.uade.screenspace.mapper.CinemaMapper;
import com.uade.screenspace.mapper.ReviewMapper;
import com.uade.screenspace.repository.MovieRepository;
import com.uade.screenspace.repository.ReviewRepository;
import io.screenspace.model.CreateReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService implements IReviewService{
    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ReviewMapper reviewMapper;
    @Override
    public List<io.screenspace.model.Review> getReviewsByMovie(String movieId) {
        List<Review> reviews = reviewRepository.findByMovieId(movieId);
        if (reviews.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No reviews found for the movie");
        }
        return reviews.stream()
                .map(reviewMapper::mapToReviewModel)
                .collect(Collectors.toList());
    }

    @Override
    public void createReview(String movieId, CreateReviewRequest reviewRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new EntityNotFound("Movie not found"));
        reviewRequest.setMovieId(movieId);
        Review reviewEntity = reviewMapper.mapCreateReviewRequestToReview(reviewRequest, authentication.getPrincipal());
        movie.getRatings().add(reviewEntity.getRating());
        reviewRepository.save(reviewEntity);
        movieRepository.save(movie);
    }
}
