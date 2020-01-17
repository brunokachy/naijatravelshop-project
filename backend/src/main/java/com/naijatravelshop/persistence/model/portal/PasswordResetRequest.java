package com.naijatravelshop.persistence.model.portal;

import com.naijatravelshop.persistence.model.generic.AuditModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Bruno on
 * 07/05/2019
 */
@Entity
@Table(name = "password_reset_request")
public class PasswordResetRequest extends AuditModel implements Serializable {
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String resetCode;
    private String username;
    private String resetUrl;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResetCode() {
        return resetCode;
    }

    public void setResetCode(String resetCode) {
        this.resetCode = resetCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getResetUrl() {
        return resetUrl;
    }

    public void setResetUrl(String resetUrl) {
        this.resetUrl = resetUrl;
    }
}
