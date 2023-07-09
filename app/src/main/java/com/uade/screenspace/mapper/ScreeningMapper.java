package com.uade.screenspace.mapper;

import com.uade.screenspace.entity.Movie;
import com.uade.screenspace.entity.Screening;
import io.screenspace.model.SeatReserved;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.stream.Collectors;

public class ScreeningMapper {

    private static DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");

    public Movie modelToEntity(io.screenspace.model.Movie model){
        Movie modelMovie = new Movie();

        return modelMovie;
    }

    public static io.screenspace.model.Screening entityToModel(Screening entityScreening){
        return new io.screenspace.model.Screening()
                .id(entityScreening.getId())
                .date(dtf.print(entityScreening.getDate()))
                .movie(MovieMapper.entityToModel(entityScreening.getMovie()))
                .theater(TheaterMapper.entityToModel(entityScreening.getTheater()))
                .seatsReserved(entityScreening.getSeatsReserved()
                        .stream()
                        .map(s ->
                                new SeatReserved()
                                        .seatColumn(s.getSeatColumn())
                                        .seatRow(s.getSeatRow()))
                        .collect(Collectors.toList()));
    }
}
