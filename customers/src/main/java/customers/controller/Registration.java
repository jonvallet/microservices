package customers.controller;

import customers.model.Customer;
import customers.repository.CustomerRepository;
import customers.responses.EmailAlreadyInUseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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

    public Customer register(String testEmail) {

        checkIfEmailAlreadyExists(testEmail);

        return customerRepository.save(new Customer(testEmail));
    }

    private void checkIfEmailAlreadyExists(String testEmail) {
        if (customerRepository.findByEmail(testEmail) != null){
            throw new EmailAlreadyInUseException("The email "+testEmail+" is already in use.");
        }
    }
}
