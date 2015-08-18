package com.nakedwines.services.customers.controller;

import com.nakedwines.services.customers.model.Customer;
import com.nakedwines.services.customers.repository.CustomerRepository;
import com.nakedwines.services.customers.responses.EmailAlreadyInUseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *  This Controller class exposes the registration
 *
 * Created by Jon Vallet on 17/08/15.
 */
@RestController
@RequestMapping("/register")
public class Registration {

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping(method = RequestMethod.POST)
    public Customer register(@RequestBody Customer customer) {

        checkIfEmailAlreadyExists(customer.email);

        return customerRepository.save(customer);
    }

    private void checkIfEmailAlreadyExists(String testEmail) {
        if (customerRepository.findByEmail(testEmail) != null){
            throw new EmailAlreadyInUseException("The email "+testEmail+" is already in use.");
        }
    }
}
