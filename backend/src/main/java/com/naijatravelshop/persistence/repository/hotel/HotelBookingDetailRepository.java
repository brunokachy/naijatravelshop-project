package com.naijatravelshop.persistence.repository.hotel;

import com.naijatravelshop.persistence.model.hotel.HotelBookingDetail;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface HotelBookingDetailRepository extends CrudRepository<HotelBookingDetail, Long>{

    Optional<HotelBookingDetail> findFirstBySupplierReference(String supplierReference);
}
