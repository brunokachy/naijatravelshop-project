package com.naijatravelshop.persistence.repository.portal;

import com.naijatravelshop.persistence.model.enums.ProcessStatus;
import com.naijatravelshop.persistence.model.enums.ReservationType;
import com.naijatravelshop.persistence.model.portal.Reservation;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends PagingAndSortingRepository<Reservation, Long> {

    Optional<Reservation> findFirstByBookingNumberEqualsAndReservationTypeEquals(String bookingNumber, ReservationType reservationType);

    Optional<Reservation> findFirstByBookingNumberEquals(String bookingNumber);

    List<Reservation> getAllByReservationStatusEqualsAndDateCreatedBetween(ProcessStatus reservationStatus, Timestamp start, Timestamp stop);

    List<Reservation> getAllByReservationStatusEquals(ProcessStatus reservationStatus);

    List<Reservation> getAllByDateCreatedBetween(Timestamp start, Timestamp stop);
}
