package com.uade.screenspace.service;

import com.uade.screenspace.auth.LoggedUserGetter;
import com.uade.screenspace.entity.Cinema;
import com.uade.screenspace.entity.Movie;
import com.uade.screenspace.entity.Screening;
import com.uade.screenspace.entity.Theater;
import com.uade.screenspace.exceptions.ValidationError;
import com.uade.screenspace.repository.CinemaRepository;
import com.uade.screenspace.repository.MovieRepository;
import com.uade.screenspace.repository.ScreeningRepository;
import com.uade.screenspace.repository.TheaterRepository;
import io.screenspace.model.CreateScreeningRequest;
import io.screenspace.model.TimeSlot;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ContextConfiguration(classes = {ScreeningService.class})
class ScreeningServiceTest {

    private static String TEST_THEATER_ID = "test-theater-id";
    private static String TEST_MOVIE_ID = "test-theater-id";

    @Autowired
    IScreeningService service;

    @MockBean
    CinemaRepository cinemaRepository;
    @MockBean
    TheaterRepository theaterRepository;
    @MockBean
    ScreeningRepository screeningRepository;
    @MockBean
    MovieRepository movieRepository;
    @MockBean
    LoggedUserGetter userGetter;

    private Theater theater;
    private Cinema cinema;
    private Movie movie;

    @BeforeEach
    void setUp() {
        movie = createMovie();
        theater = createTestTheater(TEST_THEATER_ID);
    }

    @Test
    void createScreening() {
        var expectedScreening = createScreening(theater, movie, "20/05/2023 12:00:00");
        CreateScreeningRequest request = new CreateScreeningRequest()
                .date("20/05/2023 12:00:00")
                .movieId(TEST_MOVIE_ID)
                .theaterId(TEST_THEATER_ID);
        when(movieRepository.findById(TEST_MOVIE_ID)).thenReturn(Optional.of(movie));
        when(theaterRepository.findById(TEST_THEATER_ID)).thenReturn(Optional.of(theater));
        when(screeningRepository.save(any(Screening.class))).thenReturn(expectedScreening);
        var result = service.createScreening(request);

        assertEquals(expectedScreening, result);
    }

    @Test
    void shouldNotCreateScreeningOverlappingWithAnother() {
        CreateScreeningRequest request = new CreateScreeningRequest()
                .date("20/05/2023 12:00:00")
                .movieId(TEST_MOVIE_ID)
                .theaterId(TEST_THEATER_ID);
        List<Screening> screenings = List.of(
                createScreening(theater, movie, "20/05/2023 13:00:00")
        );
        when(movieRepository.findById(TEST_MOVIE_ID)).thenReturn(Optional.of(movie));
        when(theaterRepository.findById(TEST_THEATER_ID)).thenReturn(Optional.of(theater));
        when(screeningRepository.findAll()).thenReturn(screenings);
        var exception = assertThrows(ValidationError.class, () -> service.createScreening(request));

        assertEquals(String.format("Movie %s already has a screening for this timeslot", movie.getTitle()), exception.getMessage());
    }

    @Test
    void deleteScreening() {
    }

    @Test
    void getScreeningByID() {
    }

    @Test
    void searchScreenings() {
    }

    @Test
    void searchAvailabilityForScreeningWhenScreeningsExists() {
        List<TimeSlot> expectedSlots = List.of(
                new TimeSlot().start("08:00:00").end("10:00:00"),
                new TimeSlot().start("17:00:00").end("20:00:00")

        );
        List<Screening> screenings = List.of(
                createScreening(theater, movie, "20/05/2023 12:00:00"),
                createScreening(theater, movie, "20/05/2023 10:00:00"),
                createScreening(theater, movie, "20/05/2023 15:00:00")
        );
        when(movieRepository.findById(movie.getId())).thenReturn(Optional.of(movie));
        when(screeningRepository.findAll()).thenReturn(screenings);

        var result = service.searchAvailabilityForScreening(theater.getId(), movie.getId(), "20/05/2023");

        assertEquals(expectedSlots, result);
    }

    @Test
    void searchAvailabilityForScreeningWhenScreeningsDoesNotExists() {
        List<TimeSlot> expectedSlots = List.of(
                new TimeSlot().start("08:00:00").end("20:00:00")
        );
        List<Screening> screenings = List.of(
                createScreening(createTestTheater("notThisTheater"), movie, "20/05/2023 12:00:00")
        );
        when(movieRepository.findById(movie.getId())).thenReturn(Optional.of(movie));
        when(screeningRepository.findAll()).thenReturn(screenings);

        var result = service.searchAvailabilityForScreening(theater.getId(), movie.getId(), "20/05/2023");

        assertEquals(expectedSlots, result);
    }


    private com.uade.screenspace.entity.Theater createTestTheater(String id){
        com.uade.screenspace.entity.Theater theater = new com.uade.screenspace.entity.Theater();
        theater.setName("testTheater");
        theater.setId(id);
        return theater;
    }

    private com.uade.screenspace.entity.Movie createMovie(){
        com.uade.screenspace.entity.Movie movie = new com.uade.screenspace.entity.Movie();
        movie.setTitle("title 1");
        movie.setId(TEST_MOVIE_ID);
        movie.setDuration(120);
        return movie;
    }

    private Screening createScreening(com.uade.screenspace.entity.Theater theater, Movie movie, String date){
        com.uade.screenspace.entity.Screening screening = new com.uade.screenspace.entity.Screening();
        screening.setDate(DateTime.parse(date, DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss")));
        screening.setMovie(movie);
        screening.setTheater(theater);
        return screening;
    }
}