package com.nakedwines.services.customers.responses;

/**
 * Created by Jon Vallet on 17/08/15.
 */

public class EmailAlreadyInUseException extends RuntimeException {
    public EmailAlreadyInUseException(String msg){
        super(msg);
    }
}
