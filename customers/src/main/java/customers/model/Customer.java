package customers.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Jon Vallet on 17/08/15.
 */
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Email
    @Column(unique = true)
    public String email;

    protected Customer(){
    }

    public Customer(String email){
        this.email = email;
    }

    public Long getId() {
        return id;
    }

}
