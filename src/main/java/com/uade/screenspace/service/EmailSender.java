package com.uade.screenspace.service;

import org.springframework.stereotype.Service;

@Service
public class EmailSender implements IEmailSender {
    @Override
    public boolean sendPasswordResetCode(String email, String code) {
        return true;
    }
}
