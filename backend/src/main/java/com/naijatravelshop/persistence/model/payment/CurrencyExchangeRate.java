package com.naijatravelshop.persistence.model.payment;

import com.naijatravelshop.persistence.model.portal.PortalUser;
import com.naijatravelshop.persistence.model.portal.SupplierGroup;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Bruno on
 * 06/05/2019
 */
@Entity
@Table(name = "currency_exchange_rate")
public class CurrencyExchangeRate implements Serializable {
    @Column(nullable = false)
    private Timestamp dateCreated;
    @Column(nullable = false)
    private Boolean current = true;
    private Long unitValueInKobo;
    private Long marketPriceValueInKobo = 0L;
    private Boolean currentHotelExchangeRate = false;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToOne
    private SupplierGroup supplierGroup;
    @ManyToOne
    private Currency currency;
    @ManyToOne
    private PortalUser createdBy;

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Boolean getCurrent() {
        return current;
    }

    public void setCurrent(Boolean current) {
        this.current = current;
    }

    public Long getUnitValueInKobo() {
        return unitValueInKobo;
    }

    public void setUnitValueInKobo(Long unitValueInKobo) {
        this.unitValueInKobo = unitValueInKobo;
    }

    public Long getMarketPriceValueInKobo() {
        return marketPriceValueInKobo;
    }

    public void setMarketPriceValueInKobo(Long marketPriceValueInKobo) {
        this.marketPriceValueInKobo = marketPriceValueInKobo;
    }

    public Boolean getCurrentHotelExchangeRate() {
        return currentHotelExchangeRate;
    }

    public void setCurrentHotelExchangeRate(Boolean currentHotelExchangeRate) {
        this.currentHotelExchangeRate = currentHotelExchangeRate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SupplierGroup getSupplierGroup() {
        return supplierGroup;
    }

    public void setSupplierGroup(SupplierGroup supplierGroup) {
        this.supplierGroup = supplierGroup;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public PortalUser getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(PortalUser createdBy) {
        this.createdBy = createdBy;
    }
}
