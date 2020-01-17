package com.naijatravelshop.service.jwt.pojo.response;

import java.io.Serializable;

/**
 * Created by Bruno on
 * 19/07/2019
 */
public class JwtResponse implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;
    private final String token;
    private final Long expirationTime;

    public JwtResponse(String token, Long expirationTime) {
        this.token = token;
        this.expirationTime = expirationTime;
    }

    public String getToken() {
        return this.token;
    }

    public Long getExpirationTime(){ return this.expirationTime;}
}
