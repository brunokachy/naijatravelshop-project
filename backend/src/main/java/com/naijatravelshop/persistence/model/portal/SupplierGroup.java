package com.naijatravelshop.persistence.model.portal;

import com.naijatravelshop.persistence.model.enums.EntityStatus;
import com.naijatravelshop.persistence.model.enums.SupplierGroupType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Bruno on
 * 06/05/2019
 */
@Entity
@Table(name = "supplier_group")
public class SupplierGroup implements Serializable {
    @Column(nullable = false)
    private SupplierGroupType name;
    private String description;
    @Column(nullable = false)
    private EntityStatus status;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public SupplierGroupType getName() {
        return name;
    }

    public void setName(SupplierGroupType name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EntityStatus getStatus() {
        return status;
    }

    public void setStatus(EntityStatus status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
