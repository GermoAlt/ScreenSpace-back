package com.uade.screenspace.controller;

import com.uade.screenspace.entity.Screening;
import com.uade.screenspace.mapper.CinemaMapper;
import com.uade.screenspace.mapper.MovieMapper;
import com.uade.screenspace.service.CinemaService;
import com.uade.screenspace.service.IMovieService;
import com.uade.screenspace.service.IScreeningService;
import io.screenspace.api.MoviesApi;
import io.screenspace.model.GetGenres200Response;
import io.screenspace.model.Movie;
import io.screenspace.model.MoviesPerCinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MovieController implements MoviesApi {

     @Autowired
     IMovieService movieService;
     @Autowired
    IScreeningService screeningService;
     @Autowired
    CinemaService cinemaService;

    @Override
    public ResponseEntity<Movie> getMovieById(String movieId) {
        return ResponseEntity.ok(MovieMapper.entityToModel(movieService.getMovieById(movieId)));
    }

    @Override
    public ResponseEntity<List<Movie>> getMovies(@Valid String movieTitle) {
        var foundMovies = movieService.getMoviesByTitle(movieTitle);
        return ResponseEntity.ok(foundMovies.stream().map(MovieMapper::entityToModel).collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<List<MoviesPerCinema>> searchMovies(@Valid String cinema, @Valid String movieTitle, @Valid String genre, @Valid String score, @Valid String latitute, @Valid String longitude, @Valid String maxDistance) {
        Double distance = maxDistance.isBlank() ? null : Double.parseDouble(maxDistance);
        var groupedByCinema = screeningService.searchScreenings(cinema, movieTitle, genre, score, latitute, longitude, distance)
                .stream()
                .collect(Collectors.groupingBy(c -> c.getTheater().getCinema().getId()));
        var response = groupedByCinema.entrySet().stream().map(f -> {
            var c = cinemaService.getCinemaById(f.getKey());
            return new MoviesPerCinema()
                    .cinema(CinemaMapper.INSTANCE.mapToCinemaModel(c))
                    .movies(f.getValue().stream().map(Screening::getMovie).distinct().map(MovieMapper::entityToModel).collect(Collectors.toList()))
                    .distance(latitute != null && longitude != null ? String.format("%.2f", c.calculateDistanceToCinema(Double.parseDouble(latitute), Double.parseDouble(longitude))) : null);
        }).collect(Collectors.toList());
        response.forEach(m -> m.setMovies(m.getMovies().stream().distinct().collect(Collectors.toList())));
        return ResponseEntity.ok(response);
    }
    @Override
    public ResponseEntity<GetGenres200Response> getGenres() {
        return ResponseEntity.ok(new GetGenres200Response().genres(movieService.getMovieGenres()));
    }
}
