package com.uade.screenspace.mapper;

import com.uade.screenspace.entity.Cinema;
import io.screenspace.model.CreateCinemaRequest;
import io.screenspace.model.UpdateCinemaRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CinemaMapper {

    CinemaMapper INSTANCE = Mappers.getMapper(CinemaMapper.class);

    @Mapping(source = "name" , target = "name")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "geolocation", target = "geoLocation")
    Cinema mapToCinema(io.screenspace.model.Cinema cinemaModel);

    @Mapping(source = "name" , target = "name")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "geoLocation", target = "geolocation")
    io.screenspace.model.Cinema mapToCinemaModel(Cinema cinema);

    Cinema mapCreateCinemaRequestToCinema (CreateCinemaRequest createCinemaRequest, Object user);

    Cinema mapCreateCinemaToUpdateCinema (UpdateCinemaRequest updateCinemaRequest, Cinema cinema);
}
