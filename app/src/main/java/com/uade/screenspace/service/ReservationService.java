package com.uade.screenspace.service;

import com.uade.screenspace.auth.LoggedUserGetter;
import com.uade.screenspace.entity.Reservation;
import com.uade.screenspace.exceptions.EntityNotFound;
import com.uade.screenspace.repository.CinemaRepository;
import com.uade.screenspace.repository.ReservationRepository;
import com.uade.screenspace.repository.ScreeningRepository;
import com.uade.screenspace.repository.TheaterRepository;
import io.screenspace.model.CreateReservationRequest;
import io.screenspace.model.SeatReserved;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService implements IReservationService {

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    TheaterRepository theaterRepository;
    @Autowired
    ScreeningRepository screeningRepository;
    @Autowired
    IEmailSender emailSender;
    @Autowired
    LoggedUserGetter userGetter;

    @Override
    public Reservation createReservation(CreateReservationRequest createReservationRequest) {
        Reservation reservation = new Reservation();
        var screening = screeningRepository.findById(createReservationRequest.getScreeningId()).orElseThrow(() -> new EntityNotFound(String.format("No screening found with id %s", createReservationRequest.getScreeningId())));
        reservation.setScreening(screening);
        reservation.setUser(userGetter.get());
        for (SeatReserved seatReserved : createReservationRequest.getSeatsReserved()) {
            var seat = new com.uade.screenspace.entity.SeatReserved();
            seat.setSeatColumn(seatReserved.getSeatColumn());
            seat.setSeatRow(seatReserved.getSeatRow());
            reservation.getSeatsReserved().add(seat);
            screening.getSeatsReserved().add(seat);
        }
        var createdReservation = reservationRepository.save(reservation);
        screeningRepository.save(screening);
        try{
            emailSender.sendReservationInfo(userGetter.get().getEmail(), createdReservation);
        } catch (Exception e) {

        }
        return createdReservation;
    }
}
