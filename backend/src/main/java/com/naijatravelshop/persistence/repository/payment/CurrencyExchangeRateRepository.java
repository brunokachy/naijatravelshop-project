package com.naijatravelshop.persistence.repository.payment;

import com.naijatravelshop.persistence.model.payment.CurrencyExchangeRate;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyExchangeRateRepository extends CrudRepository<CurrencyExchangeRate, Long> {
}
