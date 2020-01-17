package com.naijatravelshop.persistence.model.portal;

import com.naijatravelshop.persistence.model.enums.RoleType;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Bruno on
 * 07/05/2019
 */
@Entity
@Table(name = "role")
public class Role implements Serializable {
    @Column(nullable = false)
    private RoleType name;
    @Column(nullable = false)
    private String description;
    private String displayName;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public RoleType getName() {
        return name;
    }

    public void setName(RoleType name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
