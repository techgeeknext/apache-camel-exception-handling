package com.techgeeknext.camel.custom.exceptions;

public class GenericCamelCustomException extends RuntimeException {

    private static final long serialVersionUID = 7607128449240157466L;
    public GenericCamelCustomException(String message){
        super(message);
    }
}
