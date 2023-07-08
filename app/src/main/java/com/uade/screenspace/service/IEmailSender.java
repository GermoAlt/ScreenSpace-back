package com.uade.screenspace.service;

import com.uade.screenspace.entity.Reservation;

import java.io.IOException;

public interface IEmailSender {
    boolean sendPasswordResetCode(String email, String code) throws IOException;

    boolean sendRegistrationCode(String email, String code) throws IOException;

    boolean sendReservationInfo(String email, Reservation reservation) throws IOException;
}
