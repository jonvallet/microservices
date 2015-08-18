package com.nakedwines.services.customers.model;

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
