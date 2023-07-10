package com.uade.screenspace.mapper;

import com.uade.screenspace.entity.Review;
import io.screenspace.model.CreateReviewRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReviewMapper {

    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    io.screenspace.model.Review mapToReviewModel(Review review);

    Review mapCreateReviewRequestToReview (CreateReviewRequest createReviewRequest, Object principal);
}
