package com.nakedwines.services.customers.repository;

import com.nakedwines.services.customers.model.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Jon Vallet on 17/08/15.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findByEmail(String email);
}
