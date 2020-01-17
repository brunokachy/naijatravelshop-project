package com.naijatravelshop.persistence.repository.payment;

import com.naijatravelshop.persistence.model.payment.Bank;
import org.springframework.data.repository.CrudRepository;

public interface BankRepository extends CrudRepository<Bank, Long> {
}
