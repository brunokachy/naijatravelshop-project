package com.naijatravelshop.service.portal.pojo.request;

/**
 * Created by Bruno on
 * 18/05/2019
 */

public class PasswordDTO {
    private Long userId;

    private String oldPassword;

    private String newPassword;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
