package com.naijatravelshop.persistence.repository.portal;

import com.naijatravelshop.persistence.model.enums.EntityStatus;
import com.naijatravelshop.persistence.model.portal.ApiUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by Bruno on
 * 19/07/2019
 */
public interface ApiUserRepository extends CrudRepository<ApiUser, Long> {
    Optional<ApiUser> findFirstByUsernameAndStatus(String username, EntityStatus status);
}
