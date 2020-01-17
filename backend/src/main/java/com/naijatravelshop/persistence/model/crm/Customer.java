package com.naijatravelshop.persistence.model.crm;

import com.naijatravelshop.persistence.model.enums.Gender;
import com.naijatravelshop.persistence.model.generic.AuditModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Bruno on
 * 28/07/2019
 */
@Getter
@Setter
@Entity
public class Customer extends AuditModel implements Serializable {

    private String firstName;
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    private Timestamp dateOfBirth;
    private Gender gender;
    private String phoneNumber;
    private String title;
    private boolean subscribed;
}
