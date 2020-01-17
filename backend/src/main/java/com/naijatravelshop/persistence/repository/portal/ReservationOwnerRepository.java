package com.naijatravelshop.persistence.repository.portal;

import com.naijatravelshop.persistence.model.portal.ReservationOwner;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ReservationOwnerRepository extends CrudRepository<ReservationOwner, Long> {

    Optional<ReservationOwner> findFirstByEmailEquals(String email);
}
