/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.service;

import com.sg.addressbook.dao.AddressBookPersistenceException;
import com.sg.addressbook.dto.Address;
import java.util.List;

/**
 *
 * @author faridasadpour
 */
public interface AddressBookServiceLayer {
    void createAddress(Address address) throws
            AddressBookDuplicateLastNameException,
            AddressBookDataValidationException,
            AddressBookPersistenceException;
    
    void editAddress(Address address) throws
            AddressBookDataValidationException,
            AddressBookPersistenceException;
 
    List<Address> getAllAddresses() throws
            AddressBookPersistenceException;
    
    int getAddressesCount() throws
            AddressBookPersistenceException;
 
    Address getAddress(String lastName) throws
            AddressBookPersistenceException;
 
    Address removeAddress(String lastName) throws
            AddressBookPersistenceException;
}
