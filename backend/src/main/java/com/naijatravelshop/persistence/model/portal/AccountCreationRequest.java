package com.naijatravelshop.persistence.model.portal;

import com.naijatravelshop.persistence.model.enums.Gender;
import com.naijatravelshop.persistence.model.generic.AuditModel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Bruno on
 * 06/05/2019
 */
@Entity
@Table(name = "account_creation_request")
public class AccountCreationRequest extends AuditModel implements Serializable {

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String username;
    private String password;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String passwordHashAlgorithm;
    @Column(nullable = false)
    private String activationCode;
    private Timestamp dateActivated;
    private boolean activated = false;
    private String phoneNumber;
    private Gender gender;
    private String verificationUrl;
    private String passwordSalt;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHashAlgorithm() {
        return passwordHashAlgorithm;
    }

    public void setPasswordHashAlgorithm(String passwordHashAlgorithm) {
        this.passwordHashAlgorithm = passwordHashAlgorithm;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public Timestamp getDateActivated() {
        return dateActivated;
    }

    public void setDateActivated(Timestamp dateActivated) {
        this.dateActivated = dateActivated;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getVerificationUrl() {
        return verificationUrl;
    }

    public void setVerificationUrl(String verificationUrl) {
        this.verificationUrl = verificationUrl;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }
}
