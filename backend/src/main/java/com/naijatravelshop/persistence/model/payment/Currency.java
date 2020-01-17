package com.naijatravelshop.persistence.model.payment;

import com.naijatravelshop.persistence.model.portal.Country;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Bruno on
 * 06/05/2019
 */
@Entity
@Table(name = "currency")
public class Currency implements Serializable {
    private String name;
    private String code;
    private Boolean active = false;
    private String htmlSymbol;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Country country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getHtmlSymbol() {
        return htmlSymbol;
    }

    public void setHtmlSymbol(String htmlSymbol) {
        this.htmlSymbol = htmlSymbol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
