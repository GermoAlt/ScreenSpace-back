package com.uade.screenspace.service;

import java.io.IOException;

public interface IEmailSender {
    boolean sendPasswordResetCode(String email, String code) throws IOException;
}
