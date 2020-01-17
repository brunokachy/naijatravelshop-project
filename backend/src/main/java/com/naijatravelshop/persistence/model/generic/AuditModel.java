package com.naijatravelshop.persistence.model.generic;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.sql.Timestamp;

/**
 * Created by Bruno on
 * 15/04/2019
 */
@MappedSuperclass
public abstract class AuditModel extends BasicModel {

    private Timestamp dateCreated;

    private Timestamp lastUpdated;


    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @PreUpdate
    @PrePersist
    public void updateTimestamp() {
        lastUpdated = new Timestamp(System.currentTimeMillis());
        if(dateCreated == null){
            dateCreated = new Timestamp(System.currentTimeMillis());
        }
    }


}
