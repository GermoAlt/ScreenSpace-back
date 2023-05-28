package com.uade.screenspace.service;

public interface IEmailSender {
    boolean sendPasswordResetCode(String email, String code);
}
