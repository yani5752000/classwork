/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dao;

/**
 *
 * @author faridasadpour
 */
public class AddressBookDaoException extends Exception{
    
    public AddressBookDaoException(String message) {
        super(message);
    }
    
    public AddressBookDaoException(String message, Throwable cause) {
        super(message, cause);
    }
    
}