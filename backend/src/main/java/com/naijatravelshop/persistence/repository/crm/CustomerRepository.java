package com.naijatravelshop.persistence.repository.crm;

import com.naijatravelshop.persistence.model.crm.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by Bruno on
 * 28/07/2019
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Optional<Customer> findCustomerByEmail(String email);
}
