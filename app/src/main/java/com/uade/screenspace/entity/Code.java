package com.uade.screenspace.entity;

import java.time.Instant;

public class Code {

    private String code;
    private Instant expirationDate;

    public Code(String code, Instant expirationDate) {
        this.code = code;
        this.expirationDate = expirationDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Instant getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Instant expirationDate) {
        this.expirationDate = expirationDate;
    }
}
