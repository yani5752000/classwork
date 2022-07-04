/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.service;

/**
 *
 * @author faridasadpour
 */
public class AddressBookDuplicateLastNameException extends Exception {
     public AddressBookDuplicateLastNameException(String message) {
        super(message);
    }

    public AddressBookDuplicateLastNameException(String message,
            Throwable cause) {
        super(message, cause);
    }
}
