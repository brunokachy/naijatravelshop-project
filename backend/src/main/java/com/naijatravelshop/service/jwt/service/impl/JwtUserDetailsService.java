package com.naijatravelshop.service.jwt.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Bruno on
 * 19/07/2019
 */
@Service
public class JwtUserDetailsService  implements UserDetailsService {
    @Value("${jwt.username}")
    private String username;

    @Value("${jwt.password}")
    private String password;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (this.username.equals(username)) {
            return new User(this.username, this.password,
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
