package com.naijatravelshop.persistence.model.flight;

import com.naijatravelshop.persistence.model.enums.UnitType;
import com.naijatravelshop.persistence.model.generic.AuditModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Bruno on
 * 06/05/2019
 */
@Entity
@Table(name = "markup")
public class Markup extends AuditModel implements Serializable {
    @Column(nullable = false)
    private Double value;
    @Column(nullable = false)
    private UnitType  unit;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public UnitType getUnit() {
        return unit;
    }

    public void setUnit(UnitType unit) {
        this.unit = unit;
    }
}
