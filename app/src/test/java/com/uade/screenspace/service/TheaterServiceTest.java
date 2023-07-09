package com.uade.screenspace.service;

import com.uade.screenspace.entity.Cinema;
import com.uade.screenspace.entity.User;
import com.uade.screenspace.mapper.TheaterMapper;
import com.uade.screenspace.repository.CinemaRepository;
import com.uade.screenspace.repository.TheaterRepository;
import io.screenspace.model.SeatsLayout;
import io.screenspace.model.Theater;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ContextConfiguration(classes = {TheaterService.class})
class TheaterServiceTest {

    @Autowired
    ITheaterService service;

    @MockBean
    CinemaRepository cinemaRepository;
    @MockBean
    TheaterRepository theaterRepository;

    private static String TEST_THEATER_ID = "test-theater-id";
    private static String TEST_CINEMA_ID = "test-cinema-id";
    private static String TEST_USER_ID = "test-user-id";
    private io.screenspace.model.Theater theater;
    private Cinema cinema;
    private User user;

    @BeforeEach
    public void setup(){
        theater = createTestTheater();
        cinema = createTestCinema();
        user = createTestUser();
    }

    @Test
    void createTheater() {
        var createdId = TEST_THEATER_ID.concat("updated");
        var dbTheater = TheaterMapper.modelToEntity(theater.id(createdId));
        when(cinemaRepository.findByIdAndOwner(TEST_CINEMA_ID, user)).thenReturn(Optional.of(cinema));
        when(theaterRepository.save(any(com.uade.screenspace.entity.Theater.class))).thenReturn(dbTheater);

        var createdTheater = service.createTheater(theater, TEST_CINEMA_ID, user);

        assertEquals(createdId, theater.getId());
        assertEquals(theater.getName(), createdTheater.getName());
        assertEquals(theater.getIsTemporarilyClosed(), createdTheater.isTemporarilyClosed());
        assertFalse(cinema.getTheaters().isEmpty());
        assertEquals(cinema.getTheaters().get(0), dbTheater);
    }

    @Test
    void deleteTheater() {

    }

    @Test
    void findTheater() {
    }

    @Test
    void findTheatersByCinema() {
    }

    @Test
    void updateTheater() {
    }

    private io.screenspace.model.Theater createTestTheater(){
        return new Theater()
                .name("testTheater")
                .id(TEST_THEATER_ID)
                .seatsLayout(new SeatsLayout().numRows(1).numColumns(1))
                .pricePerFunction(2000D)
                .isTemporarilyClosed(false);
    }

    private Cinema createTestCinema(){
        Cinema cinema = new Cinema();
        cinema.setId(TEST_CINEMA_ID);
        cinema.setOwner(createTestUser());
        return cinema;
    }

    private User createTestUser(){
        User user = new User();
        user.setOwner(true);
        user.setId(TEST_USER_ID);
        return user;
    }
}