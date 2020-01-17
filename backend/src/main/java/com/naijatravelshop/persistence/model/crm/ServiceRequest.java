package com.naijatravelshop.persistence.model.crm;

import com.naijatravelshop.persistence.model.enums.Priority;
import com.naijatravelshop.persistence.model.enums.ReservationType;
import com.naijatravelshop.persistence.model.enums.ServiceQueueName;
import com.naijatravelshop.persistence.model.enums.ServiceTaskSubject;
import com.naijatravelshop.persistence.model.visa.VisaRequest;
import com.naijatravelshop.persistence.model.generic.AuditModel;
import com.naijatravelshop.persistence.model.portal.PortalUser;
import com.naijatravelshop.persistence.model.portal.Reservation;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Bruno on
 * 28/07/2019
 */
@Getter
@Setter
@Entity
public class ServiceRequest extends AuditModel implements Serializable {

    private ReservationType serviceType;
    private String description;
    private Priority priority;
    private String requestId;
    private Timestamp dateClosed;
    @ManyToOne
    private PortalUser assignedTo;
    @ManyToOne
    private Customer customer;
    @OneToOne
    private Reservation reservation;
    @OneToOne
    private VisaRequest visaRequest;
    private ServiceQueueName name;
    private ServiceTaskSubject inboundCallSubject;

}
