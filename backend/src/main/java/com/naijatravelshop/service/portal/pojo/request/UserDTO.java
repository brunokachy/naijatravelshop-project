package com.naijatravelshop.service.portal.pojo.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by Bruno on
 * 17/05/2019
 */
@Getter
@Setter
public class UserDTO {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String phoneNumber;
    private String password;
    private Long id;
    private List<String> roles;

}
