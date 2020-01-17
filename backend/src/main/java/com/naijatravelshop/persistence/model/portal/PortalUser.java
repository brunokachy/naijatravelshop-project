package com.naijatravelshop.persistence.model.portal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.naijatravelshop.persistence.model.enums.Gender;
import com.naijatravelshop.persistence.model.generic.AuditModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Bruno on
 * 06/05/2019
 */
@Entity
@Table(name = "portal_user")
public class PortalUser extends AuditModel implements Serializable {

    private String firstName;
    private String lastName;
    @Column(nullable = false)
    @JsonIgnore
    private String password;
    @Column(nullable = false)
    private boolean passwordReset = false;
    @Column(nullable = false, unique = true)
    private String email;
    private Timestamp dateOfBirth;
    private Gender gender;
    private String phoneNumber;
    private String title;
    private Timestamp lastPasswordUpdate;
    private Timestamp lastLogin;
    @OneToOne
    private Address address;
    @OneToOne
    private Image profileImage;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isPasswordReset() {
        return passwordReset;
    }

    public void setPasswordReset(boolean passwordReset) {
        this.passwordReset = passwordReset;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Timestamp dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getLastPasswordUpdate() {
        return lastPasswordUpdate;
    }

    public void setLastPasswordUpdate(Timestamp lastPasswordUpdate) {
        this.lastPasswordUpdate = lastPasswordUpdate;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Image getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(Image profileImage) {
        this.profileImage = profileImage;
    }
}
