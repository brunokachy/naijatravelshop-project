package com.naijatravelshop.persistence.repository.payment;

import com.naijatravelshop.persistence.model.enums.EntityStatus;
import com.naijatravelshop.persistence.model.payment.BankAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {
 List<BankAccount> getBankAccountsByStatus(EntityStatus status);
}
