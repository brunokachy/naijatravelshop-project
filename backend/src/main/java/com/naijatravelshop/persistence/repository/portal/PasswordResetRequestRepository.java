package com.naijatravelshop.persistence.repository.portal;

import com.naijatravelshop.persistence.model.portal.PasswordResetRequest;
import org.springframework.data.repository.CrudRepository;

public interface PasswordResetRequestRepository extends CrudRepository<PasswordResetRequest, Long> {
}
