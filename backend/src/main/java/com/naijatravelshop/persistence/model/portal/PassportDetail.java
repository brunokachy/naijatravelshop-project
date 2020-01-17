package com.naijatravelshop.persistence.model.portal;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Bruno on
 * 06/05/2019
 */
@Entity
@Table(name = "passport_detail")
public class PassportDetail implements Serializable {
    @Column(nullable = false)
    private String passportNumber;
    @Column(nullable = false)
    private Timestamp expiryDate;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToOne
    private Traveller owner;
    @ManyToOne
    private Country issuingAuthority;

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Traveller getOwner() {
        return owner;
    }

    public void setOwner(Traveller owner) {
        this.owner = owner;
    }

    public Country getIssuingAuthority() {
        return issuingAuthority;
    }

    public void setIssuingAuthority(Country issuingAuthority) {
        this.issuingAuthority = issuingAuthority;
    }
}
