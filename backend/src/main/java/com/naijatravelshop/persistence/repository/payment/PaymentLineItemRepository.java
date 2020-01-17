package com.naijatravelshop.persistence.repository.payment;

import com.naijatravelshop.persistence.model.payment.PaymentLineItem;
import org.springframework.data.repository.CrudRepository;

public interface PaymentLineItemRepository extends CrudRepository<PaymentLineItem, Long> {
}
