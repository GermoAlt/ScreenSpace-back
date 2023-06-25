package com.uade.screenspace.mapper;

import com.uade.screenspace.entity.Cinema;
import io.screenspace.model.CreateCinemaRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
public interface CinemaMapper {

    CinemaMapper INSTANCE = Mappers.getMapper(CinemaMapper.class);

    @Mapping(source = "name" , target = "name")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "geolocation", target = "geoLocation")
    @Mapping(source = "screeningsByDay", target = "screeningsByDay")
    @Mapping(source = "pricePerFunction", target = "pricePerFunction")
    @Mapping(source = "screeningsByDay", target = "screeningsByDay")
    Cinema mapToCinema(io.screenspace.model.Cinema cinemaModel);

    @Mapping(source = "name" , target = "name")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "geoLocation", target = "geolocation")
    @Mapping(source = "screeningsByDay", target = "screeningsByDay")
    @Mapping(source = "pricePerFunction", target = "pricePerFunction")
    @Mapping(source = "screeningsByDay", target = "screeningsByDay")
    io.screenspace.model.Cinema mapToCinemaModel(Cinema cinema);

    Cinema mapCreateCinemaRequestToCinema (CreateCinemaRequest createCinemaRequest, Object user);




}
