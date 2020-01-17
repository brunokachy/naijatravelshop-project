package com.naijatravelshop.persistence.model.generic;

import com.naijatravelshop.persistence.model.enums.EntityStatus;

import javax.persistence.*;

/**
 * Created by Bruno on
 * 15/04/2019
 */
@MappedSuperclass
public abstract class BasicModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private EntityStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EntityStatus getStatus() {
        return status;
    }

    public void setStatus(EntityStatus status) {
        this.status = status;
    }
}
