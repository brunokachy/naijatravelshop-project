package com.naijatravelshop.service.jwt.pojo.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by Bruno on
 * 19/07/2019
 */
@Getter
@Setter
@NoArgsConstructor
public class JwtRequest implements Serializable {
    private static final long serialVersionUID = 5926468583005150707L;
    private String username;
    private String password;

    public JwtRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
