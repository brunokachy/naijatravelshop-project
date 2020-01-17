package com.naijatravelshop.persistence.repository.crm;

import com.naijatravelshop.persistence.model.crm.ServiceRequest;
import com.naijatravelshop.persistence.model.portal.Reservation;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

/**
 * Created by Bruno on
 * 28/07/2019
 */
public interface ServiceRequestRepository extends PagingAndSortingRepository<ServiceRequest, Long> {

    Optional<ServiceRequest> findByReservation(Reservation reservation);
}
