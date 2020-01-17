package com.naijatravelshop.service.payment.pojo.Response;

/**
 * Created by Bruno on
 * 23/05/2019
 */
public class FlwAccountDetail {

    private String secretKey;

    private String publicKey;

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
}
