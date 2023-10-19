package com.assignment.contactapp.exception;

public class ContactNotFoundException extends RuntimeException{
    public ContactNotFoundException(){
        super("Contact Not Found.");
    }

    public ContactNotFoundException(String message){
        super(message);
    }

    public ContactNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
