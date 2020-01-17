package com.naijatravelshop.persistence.model.portal;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Bruno on
 * 06/05/2019
 */
@Entity
@Getter
@Setter
@Table(name = "reservation_owner")
public class ReservationOwner implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private int age;
    private Timestamp dateOfBirth;
    private String phoneNumber;
    private String email;
    private String title;

    @ManyToOne
    private Address address;
    @ManyToOne
    private Country nationality;
}
