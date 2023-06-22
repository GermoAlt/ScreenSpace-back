package com.uade.screenspace.controller;

import io.screenspace.api.ScreeningsApi;
import io.screenspace.model.CreateScreeningRequest;
import io.screenspace.model.Screening;
import io.screenspace.model.TimeSlot;
import io.screenspace.model.UpdateScreeningRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@RestController
public class ScreeningController implements ScreeningsApi {
    @Override
    public ResponseEntity<Screening> createScreening(@Valid CreateScreeningRequest createScreeningRequest) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteScreeningById(String screeningId) {
        return null;
    }

    @Override
    public ResponseEntity<Screening> getScreeningByID(String screeningId) {
        return null;
    }

    @Override
    public ResponseEntity<List<TimeSlot>> searchAvailabilityForScreening(@NotNull @Valid Integer theater, @NotNull @Valid String movieTitle, @NotNull @Valid LocalDate date) {
        return null;
    }

    @Override
    public ResponseEntity<List<Screening>> searchScreenings(@Valid Integer cinema, @Valid String movieTitle, @Valid String genre, @Valid String score, @Valid String latitute, @Valid String longitude) {
        return null;
    }

    @Override
    public ResponseEntity<Screening> updateScreening(String screeningId, @Valid UpdateScreeningRequest updateScreeningRequest) {
        return null;
    }
}
