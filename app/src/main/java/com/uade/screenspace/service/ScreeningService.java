package com.uade.screenspace.service;

import com.uade.screenspace.auth.LoggedUserGetter;
import com.uade.screenspace.entity.Screening;
import com.uade.screenspace.exceptions.EntityNotFound;
import com.uade.screenspace.repository.CinemaRepository;
import com.uade.screenspace.repository.MovieRepository;
import com.uade.screenspace.repository.ScreeningRepository;
import com.uade.screenspace.repository.TheaterRepository;
import io.screenspace.model.CreateScreeningRequest;
import io.screenspace.model.TimeSlot;
import io.swagger.models.auth.In;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScreeningService implements IScreeningService {

    public static String START_HOUR = "08:00:00";
    public static String END_HOUR = "20:00:00";

    @Autowired
    private ScreeningRepository screeningRepository;
    @Autowired
    private CinemaRepository cinemaRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private TheaterRepository theaterRepository;
    @Autowired
    private LoggedUserGetter userGetter;

    @Override
    public Screening createScreening(CreateScreeningRequest createScreeningRequest) {

        Screening screening = new Screening();
        screening.setTheater(theaterRepository.findById(createScreeningRequest.getTheaterId()).orElseThrow(() -> new EntityNotFound(String.format("No theater found with id %s", createScreeningRequest.getTheaterId()))));
        screening.setMovie(movieRepository.findById(createScreeningRequest.getMovieId()).orElseThrow(() -> new EntityNotFound(String.format("No movie found with id %s", createScreeningRequest.getMovieId()))));
        screening.setDate(DateTime.parse(createScreeningRequest.getDate(), DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss")));
        return screeningRepository.save(screening);
    }

    @Override
    public void deleteScreening(String screeningId) {
        var foundScreening = screeningRepository.findById(screeningId).orElseThrow(() -> new EntityNotFound(String.format("No screening found with id %s", screeningId)));
        if (!foundScreening.getTheater().getUser().getId().equals(userGetter.get().getId()))
            throw new EntityNotFound(String.format("No screening found with id %s", screeningId));
        screeningRepository.delete(foundScreening);
    }

    @Override
    public Screening getScreeningByID(String screeningId) {
        var foundScreening = screeningRepository.findById(screeningId).orElseThrow(() -> new EntityNotFound(String.format("No screening found with id %s", screeningId)));
        if (!foundScreening.getTheater().getUser().getId().equals(userGetter.get().getId()))
            throw new EntityNotFound(String.format("No screening found with id %s", screeningId));
        return foundScreening;
    }

    @Override
    public List<Screening> searchScreenings(String cinema, String movieTitle, String genre, String score, String latitute, String longitude) {
        var screenings = screeningRepository.findAll();
        if (cinema != null){
            screenings = screenings.stream().filter(s -> s.getTheater().getCinema().getId().equals(cinema)).collect(Collectors.toList());
        }
        if (movieTitle != null){
            screenings = screenings.stream().filter(s -> s.getMovie().getTitle().equals(cinema)).collect(Collectors.toList());
        }
        return screenings;
    }

    @Override
    public List<TimeSlot> searchAvailabilityForScreening(String theater, String movieTitle, String date) {
        DateTime searchedDate = DateTime.parse(date, DateTimeFormat.forPattern("dd/MM/yyyy")).withTimeAtStartOfDay();
        var screenings = screeningRepository.findAll()
                .stream()
                .filter(s -> s.getTheater().getId().equals(theater) && s.getDate().withTimeAtStartOfDay().equals(searchedDate))
                .collect(Collectors.toList());
        if (screenings.isEmpty()){
            return List.of(new TimeSlot().start(START_HOUR).end(END_HOUR));
        }

        for (Screening screening : screenings){
            LocalTime ScreeningStart = screening.getDate().toLocalTime();
        }
        return null;
    }
}
