package com.uade.screenspace.controller;

import com.uade.screenspace.mapper.ScreeningMapper;
import com.uade.screenspace.service.IScreeningService;
import io.screenspace.api.ScreeningsApi;
import io.screenspace.model.CreateScreeningRequest;
import io.screenspace.model.Screening;
import io.screenspace.model.TimeSlot;
import io.screenspace.model.UpdateScreeningRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ScreeningController implements ScreeningsApi {

    @Autowired
    IScreeningService screeningService;

    @Override
    public ResponseEntity<Screening> createScreening(@Valid CreateScreeningRequest createScreeningRequest) {
        return ResponseEntity.ok(ScreeningMapper.entityToModel(screeningService.createScreening(createScreeningRequest)));
    }

    @Override
    public ResponseEntity<Void> deleteScreeningById(String screeningId) {
        screeningService.deleteScreening(screeningId);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Screening> getScreeningByID(String screeningId) {
        return ResponseEntity.ok(ScreeningMapper.entityToModel(screeningService.getScreeningByID(screeningId)));
    }

    @Override
    public ResponseEntity<List<TimeSlot>> searchAvailabilityForScreening(@NotNull @Valid String theater, @NotNull @Valid String movieTitle, @NotNull @Valid String date) {
        return ResponseEntity.ok(screeningService.searchAvailabilityForScreening(theater, movieTitle, date));
    }

    @Override
    public ResponseEntity<List<Screening>> searchScreenings(@Valid String cinema, @Valid String movieTitle, @Valid String genre, @Valid String score, @Valid String latitute, @Valid String longitude) {
        return ResponseEntity.ok(
                screeningService.searchScreenings(cinema, movieTitle, genre, score, latitute, longitude)
                .stream()
                        .map(ScreeningMapper::entityToModel).collect(Collectors.toList())
        );
    }

    @Override
    public ResponseEntity<Screening> updateScreening(String screeningId, @Valid UpdateScreeningRequest updateScreeningRequest) {
        return ResponseEntity.ok(ScreeningMapper.entityToModel(screeningService.updateScreening(screeningId, updateScreeningRequest)));
    }
}
