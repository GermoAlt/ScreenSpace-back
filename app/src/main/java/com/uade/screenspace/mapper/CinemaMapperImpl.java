package com.uade.screenspace.mapper;

import com.uade.screenspace.entity.*;
import io.screenspace.model.CreateCinemaRequest;
import io.screenspace.model.GeoLocation;
import io.screenspace.model.UpdateCinemaRequest;
import org.springframework.stereotype.Component;

@Component
public class CinemaMapperImpl implements CinemaMapper{
    @Override
    public Cinema mapToCinema(io.screenspace.model.Cinema cinemaModel) {
        Cinema cinema = new Cinema();
        cinema.setName(cinemaModel.getName());
        cinema.setAddress(mapToAddress(cinemaModel.getAddress()));
        cinema.setGeolocation(mapToGeolocation(cinemaModel.getGeoLocation()));
        /*cinema.setScreeningsByDay(cinemaModel.getScreeningsByDay());*/
        return cinema;
    }

    @Override
    public io.screenspace.model.Cinema mapToCinemaModel(Cinema cinema) {
        io.screenspace.model.Cinema cinemaModel = new io.screenspace.model.Cinema();
        cinemaModel.setId(cinema.getId());
        cinemaModel.setName(cinema.getName());
        cinemaModel.setAddress(mapToAddressModel(cinema.getAddress()));
        cinemaModel.setGeoLocation(mapToGeolocationModel(cinema.getGeolocation()));
        cinemaModel.setOwner(mapToOwnerModel(cinema.getOwner()));
        return cinemaModel;
    }

    @Override
    public Cinema mapCreateCinemaRequestToCinema(CreateCinemaRequest createCinemaRequest, Object user) {
        Cinema cinema = new Cinema();
        cinema.setName(createCinemaRequest.getName());
        cinema.setAddress(mapToAddress(createCinemaRequest.getAddress()));
        cinema.setGeolocation(mapToGeolocation(createCinemaRequest.getGeoLocation()));
        cinema.setOwner((User) user);
        return cinema;
    }

    @Override
    public Cinema mapCreateCinemaToUpdateCinema(UpdateCinemaRequest updateCinemaRequest, Cinema cinema) {
        cinema.setAddress(mapToAddress(updateCinemaRequest.getAddress()));
        cinema.setName(updateCinemaRequest.getName());
        cinema.setGeolocation(mapToGeolocation(updateCinemaRequest.getGeoLocation()));
        return cinema;
    }

    private Address mapToAddress(io.screenspace.model.Address addressModel) {
        Address address = new Address();
        address.setStreet(addressModel.getStreet());
        address.setNumber(addressModel.getNumber());
        address.setNeighborhood(addressModel.getNeighborhood());
        address.setCity(addressModel.getCity());
        address.setProvince(addressModel.getProvince());
        address.setCountry(addressModel.getCountry());
        return address;
    }

    private io.screenspace.model.Address mapToAddressModel(Address address) {
        io.screenspace.model.Address addressModel = new io.screenspace.model.Address();
        addressModel.setStreet(address.getStreet());
        addressModel.setNumber(address.getNumber());
        addressModel.setNeighborhood(address.getNeighborhood());
        addressModel.setCity(address.getCity());
        addressModel.setProvince(address.getProvince());
        addressModel.setCountry(address.getCountry());
        return addressModel;
    }

    public GeoLocation mapToGeolocationModel(Geolocation geolocation) {
        if (geolocation == null) {
            return null;
        }
        GeoLocation geolocationModel = new GeoLocation();
        geolocationModel.setLatitude(geolocation.getLatitude());
        geolocationModel.setLongitude(geolocation.getLongitude());
        return geolocationModel;
    }

    public Geolocation mapToGeolocation(GeoLocation geoLocation) {
        if (geoLocation == null) {
            return null;
        }
        Geolocation geolocation = new Geolocation();
        geolocation.setLatitude(geoLocation.getLatitude());
        geolocation.setLongitude(geoLocation.getLongitude());
        return geolocation;
    }


    public io.screenspace.model.User mapToOwnerModel(User owner) {
        if (owner == null) {
            return null;
        }
        io.screenspace.model.User ownerModel = new io.screenspace.model.User();
        ownerModel.setEmail(owner.getEmail());
        return ownerModel;
    }
}
