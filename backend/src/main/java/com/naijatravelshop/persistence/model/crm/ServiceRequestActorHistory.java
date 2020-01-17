package com.naijatravelshop.persistence.model.crm;

import com.naijatravelshop.persistence.model.generic.AuditModel;
import com.naijatravelshop.persistence.model.portal.PortalUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by Bruno on
 * 28/07/2019
 */
@Getter
@Setter
@Entity
public class ServiceRequestActorHistory extends AuditModel implements Serializable {

    @ManyToOne
    private PortalUser actor;

    @ManyToOne
    private ServiceRequest serviceRequest;

}
