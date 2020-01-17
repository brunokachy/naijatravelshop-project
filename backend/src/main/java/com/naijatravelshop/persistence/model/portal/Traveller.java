package com.naijatravelshop.persistence.model.portal;

import com.naijatravelshop.persistence.model.enums.AgeGroupType;
import com.naijatravelshop.persistence.model.enums.Gender;
import com.naijatravelshop.persistence.model.hotel.RoomOffer;
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
@Table(name = "traveller")
public class Traveller implements Serializable {
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    private Timestamp dateOfBirth;
    private AgeGroupType ageGroup;
    private String title;
    private Integer age;
    private String middleName;
    private Gender gender;
    private String nationality;
    @ManyToOne
    private RoomOffer roomOffer;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private Reservation reservation;
}
