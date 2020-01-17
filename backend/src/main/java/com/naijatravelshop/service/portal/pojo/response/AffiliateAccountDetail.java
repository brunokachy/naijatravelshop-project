package com.naijatravelshop.service.portal.pojo.response;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Bruno on
 * 23/05/2019
 */
@Getter
@Setter
public class AffiliateAccountDetail {

    private String publicKey;

    private String secretKey;

    private String affiliateCode;

    private String baseUrl;
}
