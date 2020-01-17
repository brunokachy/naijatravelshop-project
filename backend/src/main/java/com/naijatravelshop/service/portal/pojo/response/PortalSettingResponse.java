package com.naijatravelshop.service.portal.pojo.response;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Bruno on
 * 21/09/2019
 */
@Getter
@Setter
public class PortalSettingResponse {

    private String exchangeRate;

    private AffiliateAccountDetail affiliateAccountDetail;

    private DOTWDetail dotwDetail;

    private FlutterwaveDetail flutterwaveDetail;
}
