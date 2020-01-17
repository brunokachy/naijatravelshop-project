package com.naijatravelshop.persistence.model.portal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.naijatravelshop.persistence.model.generic.AuditModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Bruno on
 * 19/07/2019
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "apiuser")
public class ApiUser extends AuditModel implements Serializable {
    @Column(nullable = false)
    @JsonIgnore
    private String password;
    @Column(nullable = false)
    private String username;
}
