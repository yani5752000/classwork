/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dao;

import com.sg.addressbook.dto.Address;
import java.util.List;

/**
 *
 * @author faridasadpour
 */
public interface AddressBookDao {
    /**
     * Adds the given address to the address book and associates it with the given
     * last name. If there is already a address associated with the given
     * last name it will return that address object, otherwise it will
     * return null.
     *
     * @param last name id with which student is to be associated
     * @param address to be added to the roster
     * @return the address object previously associated with the given  
     * last name if it exists, null otherwise
     * @throws AddressBookPersistenceException
     */
    Address addAddress(String lastName, Address address) throws AddressBookPersistenceException;

    /**
     * Returns a List of all addresses in the address book.
     *
     * @return List containing all addresses in the address book.
     * @throws AddressBookPersistenceException
     */
    List<Address> getAllAddresses() throws AddressBookPersistenceException;
    
    /**
     * Returns number of all addresses in the address book.
     *
     * @return int for the number of all addresses in the address book.
     * @throws AddressBookPersistenceException
     */
    int getAddressesCount() throws AddressBookPersistenceException;

    /**
     * Returns the address object associated with the given last name.
     * Returns null if no such address exists
     *
     * @param last name ID of the address to retrieve
     * @return the Address object associated with the given last name,  
     * null if no such address exists
     * @throws AddressBookPersistenceException
     */
    Address getAddress(String lastName) throws AddressBookPersistenceException;

    /**
     * Removes from the address book the address associated with the given last name.
     * Returns the address object that is being removed or null if
     * there is no address associated with the given last name
     *
     * @param lastName id of address to be removed
     * @return Address object that was removed or null if no address
     * was associated with the given last name
     * @throws AddressBookPersistenceException
     */
    Address removeAddress(String lastName) throws AddressBookPersistenceException;
}
