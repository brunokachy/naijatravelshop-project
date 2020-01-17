package com.naijatravelshop.persistence.model.portal;

import com.naijatravelshop.persistence.model.enums.EntityStatus;

import javax.persistence.*;

/**
 * Created by Bruno on
 * 07/05/2019
 */
@Entity
@Table(name = "portal_user_role_map")
public class PortalUserRoleMap {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToOne
    private PortalUser portalUser;
    @ManyToOne
    private Role role;
    private EntityStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PortalUser getPortalUser() {
        return portalUser;
    }

    public void setPortalUser(PortalUser portalUser) {
        this.portalUser = portalUser;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public EntityStatus getStatus() {
        return status;
    }

    public void setStatus(EntityStatus status) {
        this.status = status;
    }
}
