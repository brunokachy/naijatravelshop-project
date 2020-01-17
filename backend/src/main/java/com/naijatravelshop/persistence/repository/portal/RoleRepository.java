package com.naijatravelshop.persistence.repository.portal;

import com.naijatravelshop.persistence.model.enums.RoleType;
import com.naijatravelshop.persistence.model.portal.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findFirstByNameEquals(RoleType roleType);

    Optional<Role> findFirstByDisplayName(String displayName);
}

