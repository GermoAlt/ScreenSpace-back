package com.uade.screenspace.service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.uade.screenspace.entity.Reservation;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailSender implements IEmailSender {

    private String API_KEY = System.getenv("app.sendgrid.key");//;

    @Value("${app.sendgrid.from}")
    private String FROM_EMAIL;

    @Override
    public boolean sendPasswordResetCode(String email, String code) throws IOException {
        String subject = "Reinicio de contraseña Screenspace";
        Content content = new Content("text/plain", String.format("Su codigo de reinicio de contraseña es : %s", code));
        return sendEmail(subject, content, email);
    }

    @Override
    public boolean sendRegistrationCode(String email, String code) throws IOException {
        String subject = "Confirmacion de registro de usuario";
        Content content = new Content("text/plain", String.format("Su codigo de confirmacion de registro es : %s", code));
        return sendEmail(subject, content, email);
    }

    @Override
    public boolean sendReservationInfo(String email, Reservation reservation) throws IOException {
        String subject = "Confirmacion de reserva";
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s <br>", reservation.getScreening().getMovie().getTitle()));
        builder.append(String.format("Codigo de reserva : %s <br>", reservation.getId()));
        builder.append(String.format("Funcion: %s <br>", reservation.getScreening().getDate().toString(DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss"))));
        builder.append(String.format("Cine : %s <br>", reservation.getScreening().getTheater().getCinema().getName()));
        builder.append(String.format("Direccion : %s <br>", reservation.getScreening().getTheater().getCinema().getAddress().getTextAddress()));
        builder.append(String.format("Cantidad de entradas : %d <br>", reservation.getSeatsReserved().size()));
        builder.append("Ubicaciones: <br>");
        reservation.getSeatsReserved().forEach(s -> {
            builder.append(String.format("Fila %s Butaca %s <br>", s.getSeatRow(), s.getSeatColumn()));
        });
        String importe = String.format("%.2f", reservation.getScreening().getTheater().getPricePerFunction() * reservation.getSeatsReserved().size());
        builder.append(String.format("Importe entradas : %s", importe));
        Content content = new Content("text/html", builder.toString());
        return sendEmail(subject, content, reservation.getUser().getEmail());
    }

    public boolean sendEmail(String subject, Content content, String email) throws IOException {
        Email from = new Email(FROM_EMAIL);
        Email to = new Email(email);
        Mail mail = new Mail(from, subject, to, content);
        SendGrid sg = new SendGrid(API_KEY);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }
        return true;
    }
}
