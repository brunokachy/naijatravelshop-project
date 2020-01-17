package com.naijatravelshop.persistence.model.payment;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Bruno on
 * 06/05/2019
 */
@Entity
@Table(name = "bank")
public class Bank implements Serializable {

    private String name;
    private String code;
    private String shortName;
    private String iswBankCode;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getIswBankCode() {
        return iswBankCode;
    }

    public void setIswBankCode(String iswBankCode) {
        this.iswBankCode = iswBankCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
