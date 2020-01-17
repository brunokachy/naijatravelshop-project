package com.naijatravelshop.persistence.repository.payment;

import com.naijatravelshop.persistence.model.payment.PaymentHistory;
import com.naijatravelshop.persistence.model.portal.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PaymentHistoryRepository extends CrudRepository<PaymentHistory, Long> {

    Optional<PaymentHistory> findPaymentHistoryByReservation(Reservation reservation);
}
