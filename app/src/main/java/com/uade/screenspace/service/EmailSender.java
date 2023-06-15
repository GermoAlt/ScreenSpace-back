package com.uade.screenspace.service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailSender implements IEmailSender {

    @Value("${app.sendgrid.key}")
    private String API_KEY;

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
