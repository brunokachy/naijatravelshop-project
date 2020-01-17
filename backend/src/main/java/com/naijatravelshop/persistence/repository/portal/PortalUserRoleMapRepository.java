package com.naijatravelshop.persistence.repository.portal;

import com.naijatravelshop.persistence.model.enums.EntityStatus;
import com.naijatravelshop.persistence.model.portal.PortalUser;
import com.naijatravelshop.persistence.model.portal.PortalUserRoleMap;
import com.naijatravelshop.persistence.model.portal.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PortalUserRoleMapRepository extends CrudRepository<PortalUserRoleMap, Long> {

    List<PortalUserRoleMap> getAllByStatusAndPortalUserEquals(EntityStatus status, PortalUser portalUser);

    List<PortalUserRoleMap> getAllByRoleEquals(Role role);

}
