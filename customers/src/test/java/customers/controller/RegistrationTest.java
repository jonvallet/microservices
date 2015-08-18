package customers.controller;

import customers.CustomersApiApplication;
import customers.model.Customer;
import customers.repository.CustomerRepository;
import customers.responses.EmailAlreadyInUseException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Jon Vallet on 17/08/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CustomersApiApplication.class)
public class RegistrationTest {

    public static final String TEST_EMAIL = "test@testdomain.com";
    @Autowired
    Registration registration;
    @Autowired
    CustomerRepository customerRepository;

    @After
    public void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    public void registerNewCustomer() {
        registration.register(TEST_EMAIL);
        Assert.assertNotNull(customerRepository.findByEmail(TEST_EMAIL));
    }

    @Test(expected = EmailAlreadyInUseException.class)
    public void registerAlreadyInUseEmailCustomer() {
        customerRepository.save(new Customer(TEST_EMAIL));
        registration.register(TEST_EMAIL);
    }

}
