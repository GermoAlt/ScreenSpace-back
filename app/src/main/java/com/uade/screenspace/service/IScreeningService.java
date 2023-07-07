package com.uade.screenspace.service;

import com.uade.screenspace.entity.Screening;
import io.screenspace.model.CreateScreeningRequest;
import io.screenspace.model.TimeSlot;
import io.screenspace.model.UpdateScreeningRequest;


import javax.validation.Valid;
import java.util.List;

public interface IScreeningService {

    Screening createScreening(CreateScreeningRequest createScreeningRequest);

    void deleteScreening(String screeningId);

    Screening getScreeningByID(String screeningId);

    List<Screening> searchScreenings(String cinema, String movieTitle, String genre, String score, String latitute, String longitude);

    List<TimeSlot> searchAvailabilityForScreening(String theater, String movieTitle, String date);

    Screening updateScreening(String screeningId, UpdateScreeningRequest updateScreeningRequest);

    List<Screening> screeningsForCinema(String cinemaId);
}
