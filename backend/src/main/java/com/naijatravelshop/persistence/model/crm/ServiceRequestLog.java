package com.naijatravelshop.persistence.model.crm;

import com.naijatravelshop.persistence.model.enums.ServiceTaskSubject;
import com.naijatravelshop.persistence.model.enums.ServiceTaskType;
import com.naijatravelshop.persistence.model.generic.AuditModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Bruno on
 * 28/07/2019
 */
@Getter
@Setter
@Entity
public class ServiceRequestLog extends AuditModel implements Serializable {

    @ManyToOne
    private ServiceRequestActorHistory actor;

    private ServiceTaskSubject subject;

    private String description;

    private String resolution;

    private Timestamp followUpDate;

    private ServiceTaskType taskType;

}
