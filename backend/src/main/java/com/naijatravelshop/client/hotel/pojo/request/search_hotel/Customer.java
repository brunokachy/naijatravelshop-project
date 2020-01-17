package com.naijatravelshop.client.hotel.pojo.request.search_hotel;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created by Bruno on
 * 12/08/2019
 */
@Data
@XmlRootElement(name = "customer")
@XmlType(propOrder={"username", "password", "id", "source", "product", "request"})
public class Customer  implements Serializable {

    private String username;

    private String password;

    private String id;

    private String source;

    private String product;

    private Request request;
}
