package com.naijatravelshop.persistence.model.visa;

import com.naijatravelshop.persistence.model.generic.AuditModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Bruno on
 * 04/11/2019
 */
@Entity
@Table(name = "visa_country")
@Getter
@Setter
public class VisaCountry extends AuditModel implements Serializable {

    @Column(nullable = false, unique = true)
    private String countryName;
}
