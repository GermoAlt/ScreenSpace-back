package com.uade.screenspace.service;

import com.uade.screenspace.auth.LoggedUserGetter;
import com.uade.screenspace.entity.Movie;
import com.uade.screenspace.entity.Rating;
import com.uade.screenspace.entity.Screening;
import com.uade.screenspace.exceptions.EntityNotFound;
import com.uade.screenspace.exceptions.ValidationError;
import com.uade.screenspace.repository.CinemaRepository;
import com.uade.screenspace.repository.MovieRepository;
import com.uade.screenspace.repository.ScreeningRepository;
import com.uade.screenspace.repository.TheaterRepository;
import io.screenspace.model.CreateScreeningRequest;
import io.screenspace.model.TimeSlot;
import io.screenspace.model.UpdateScreeningRequest;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.joda.time.Minutes;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

@Service
public class ScreeningService implements IScreeningService {

    public static String START_HOUR = "08:00:00";
    public static String END_HOUR = "20:00:00";
    public static double MAX_DISTANCE = 5;

    @Autowired
    private ScreeningRepository screeningRepository;
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

        var existentScreenings = findScreeningsForTheaterAndDate(createScreeningRequest.getTheaterId(), createScreeningRequest.getDate());
        checkOverlapping(screening, existentScreenings);

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
        if (userGetter.get().getOwner() && !foundScreening.getTheater().getUser().getId().equals(userGetter.get().getId()))
            throw new EntityNotFound(String.format("No screening found with id %s", screeningId));
        return foundScreening;
    }

    @Override
    public List<Screening> searchScreenings(String cinema, String movieTitle, String genre, String score, String latitude, String longitude) {
        var screenings = screeningRepository.findAll();
        screenings = screenings.stream().filter(s -> s.getDate().isAfter(DateTime.now())).collect(Collectors.toList());
        if (cinema != null){
            screenings = screenings.stream().filter(s -> s.getTheater().getCinema().getId().equals(cinema)).collect(Collectors.toList());
        }
        if (movieTitle != null){
            screenings = screenings.stream().filter(s -> s.getMovie().getTitle().contains(movieTitle)).collect(Collectors.toList());
        }
        if (genre != null){
            screenings = screenings.stream().filter(s -> s.getMovie().getGenre().contains(genre)).collect(Collectors.toList());
        }
        if (score != null){
            screenings = screenings.stream().filter(s -> s.getMovie().getRating() >= Double.parseDouble(score)).collect(Collectors.toList());
        }
        if (latitude != null && longitude != null){
            screenings = screenings.stream()
                    .filter(s ->
                            s.getTheater().getCinema().calculateDistanceToCinema(Double.parseDouble(latitude), Double.parseDouble(longitude)) <= MAX_DISTANCE
                    )
                    .collect(Collectors.toList());
        }
        return screenings;
    }

    @Override
    public List<TimeSlot> searchAvailabilityForScreening(String theater, String movieTitle, String date) {
        DateTime searchedDate = DateTime.parse(date, DateTimeFormat.forPattern("dd/MM/yyyy")).withTimeAtStartOfDay();
        Movie movie = movieRepository.findById(movieTitle).orElseThrow(() -> new EntityNotFound(String.format("No movie found with id %s", movieTitle)));
        List<TimeSlot> timeSlots = new ArrayList<>();
        int movieDuration = movie.getDuration();
        var screenings = findScreeningsForTheaterAndDate(theater, date.concat(" 00:00:00"));
        if (screenings.isEmpty()){
            return List.of(new TimeSlot().start(START_HOUR).end(END_HOUR));
        }

        LocalTime initialTime = searchedDate.withTime(LocalTime.parse(START_HOUR, DateTimeFormat.forPattern("HH:mm:ss"))).toLocalTime();
        LocalTime endTime = searchedDate.withTime(LocalTime.parse(END_HOUR, DateTimeFormat.forPattern("HH:mm:ss"))).toLocalTime();
        for (Screening screening : screenings){
            LocalTime screeningStart = screening.getDate().toLocalTime();
            int freeMinutes = Minutes.minutesBetween(initialTime, screeningStart).getMinutes();
            if (freeMinutes >= movieDuration){
                timeSlots.add(new TimeSlot().start(initialTime.toString(DateTimeFormat.forPattern("HH:mm:ss"))).end(screeningStart.toString(DateTimeFormat.forPattern("HH:mm:ss"))));
            }
            initialTime = screeningStart.plusMinutes(screening.getMovie().getDuration());
        }

        if(Minutes.minutesBetween(initialTime, endTime).getMinutes() >= movieDuration){
            timeSlots.add(new TimeSlot().start(initialTime.toString(DateTimeFormat.forPattern("HH:mm:ss"))).end(endTime.toString(DateTimeFormat.forPattern("HH:mm:ss"))));
        }

        return timeSlots;
    }

    @Override
    public Screening updateScreening(String screeningId, UpdateScreeningRequest updateScreeningRequest) {
        var existentScreening = screeningRepository.findById(screeningId).orElseThrow(() -> new EntityNotFound(String.format("No screening found with id %s", screeningId)));
        existentScreening.setTheater(theaterRepository.findById(updateScreeningRequest.getTheaterId()).orElseThrow(() -> new EntityNotFound(String.format("No theater found with id %s", updateScreeningRequest.getTheaterId()))));
        existentScreening.setMovie(movieRepository.findById(updateScreeningRequest.getMovieId()).orElseThrow(() -> new EntityNotFound(String.format("No movie found with id %s", updateScreeningRequest.getMovieId()))));
        existentScreening.setDate(DateTime.parse(updateScreeningRequest.getDate(), DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss")));

        var existentScreenings = findScreeningsForTheaterAndDate(updateScreeningRequest.getTheaterId(), updateScreeningRequest.getDate()).stream().filter(c -> !c.getId().equals(existentScreening.getId())).collect(Collectors.toList());
        checkOverlapping(existentScreening, existentScreenings);

        return screeningRepository.save(existentScreening);
    }

    @Override
    public List<Screening> screeningsForCinema(String cinemaId) {
        return searchScreenings(cinemaId, null, null, null, null, null);
    }

    private List<Screening> findScreeningsForTheaterAndDate(String theater, String date){
        DateTime searchedDate = DateTime.parse(date, DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss")).withTimeAtStartOfDay();
        return screeningRepository.findAll()
                .stream()
                .filter(s -> s.getTheater().getId().equals(theater) && s.getDate().withTimeAtStartOfDay().equals(searchedDate))
                .sorted(Comparator.comparing(Screening::getDate))
                .collect(Collectors.toList());
    }

    private void checkOverlapping(Screening screening, List<Screening> existentScreenings) {
        LocalTime start = screening.getDate().toLocalTime();
        LocalTime end = screening.getDate().toLocalTime().plusMinutes(screening.getMovie().getDuration());

        for (Screening existentScreening : existentScreenings){
            LocalTime existentScreeningStart = existentScreening.getDate().toLocalTime();
            LocalTime existentScreeningEnd = existentScreeningStart.plusMinutes(existentScreening.getMovie().getDuration());
            if (isOverlapping(start, end, existentScreeningStart, existentScreeningEnd)){
                throw new ValidationError(String.format("Movie %s already has a screening for this timeslot", screening.getMovie().getTitle()));
            }
        }
    }

    private boolean isOverlapping(LocalTime start1, LocalTime end1, LocalTime start2, LocalTime end2) {
        return !start1.isAfter(end2) && !start2.isAfter(end1);
    }

    public double calculateDistanceBetweenPointsWithPoint2D(double x1, double y1, double x2, double y2) {
        return org.apache.lucene.util.SloppyMath.haversinMeters(x1, y1, x2, y2) / 1000;
    }
}
