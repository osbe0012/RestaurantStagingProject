package com.revature.driver.Security.Exceptions;

/**This exception should be throw whenever the authentication infastructure discovers 
 * a required field is empty or null. For example, it would be appropriatwe to throw this exception 
 * when a null username is supplied to an AccountDetails object,
 */
public class EmptyAuthenticationFieldException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public EmptyAuthenticationFieldException() {
        super("Attempted to use a null or empty field in authentication when said field is required to be not null or empty.");
    }

    public EmptyAuthenticationFieldException(String msg){
        super(msg);
    }
}
