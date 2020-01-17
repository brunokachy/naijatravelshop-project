package com.naijatravelshop.persistence.repository.payment;

import com.naijatravelshop.persistence.model.payment.Currency;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyRepository extends CrudRepository<Currency, Long> {
}
