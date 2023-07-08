package com.uade.screenspace.mapper;

import io.screenspace.model.Reservation;
import io.screenspace.model.SeatReserved;

import java.util.stream.Collectors;

public class ReservationMapper {

    public static Reservation entityToModel(com.uade.screenspace.entity.Reservation entity){
        return new Reservation()
                .code(entity.getId())
                .screening(ScreeningMapper.entityToModel(entity.getScreening()))
                .seatsReserved(
                        entity.getSeatsReserved().stream().map(s -> new SeatReserved().seatRow(s.getSeatRow()).seatColumn(s.getSeatColumn())).collect(Collectors.toList())
                );
    }

}
