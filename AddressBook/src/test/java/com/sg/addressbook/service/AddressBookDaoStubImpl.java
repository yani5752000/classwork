/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.service;

import com.sg.addressbook.dao.AddressBookDao;
import com.sg.addressbook.dao.AddressBookPersistenceException;
import com.sg.addressbook.dto.Address;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author faridasadpour
 */
public class AddressBookDaoStubImpl implements AddressBookDao {
    public Address onlyAddress;

    public AddressBookDaoStubImpl() {
        onlyAddress = new Address();
        onlyAddress.setFirstName("Ada");
        onlyAddress.setLastName("Lovelace");
        onlyAddress.setStreetAddress("2 Hay Street");
        onlyAddress.setCity("London");
        onlyAddress.setProvince("Ontario");
        onlyAddress.setPostalCode("A1A 1A1");
    }

    public AddressBookDaoStubImpl(Address testAddress){
         this.onlyAddress = testAddress;
     }

    @Override
    public Address addAddress(String lastName, Address address)
                  throws AddressBookPersistenceException {
        if (lastName.equals(onlyAddress.getLastName())) {
            return onlyAddress;
        } else {
            return null;
        }
    }

    @Override
    public List<Address> getAllAddresses()
                 throws AddressBookPersistenceException {
        List<Address> addressList = new ArrayList<>();
        addressList.add(onlyAddress);
        return addressList;
    }
    
    @Override
    public int getAddressesCount() 
            throws AddressBookPersistenceException {
        List<Address> addressList = new ArrayList<>();
        addressList.add(onlyAddress);
        return addressList.size();
    }

    @Override
    public Address getAddress(String lastName)
                throws AddressBookPersistenceException {
        if (lastName.equals(onlyAddress.getLastName())) {
            return onlyAddress;
        } else {
            return null;
        }       
    }

    @Override
    public Address removeAddress(String lastName)
                throws AddressBookPersistenceException {
        if (lastName.equals(onlyAddress.getLastName())) {
            return onlyAddress;
        } else {
            return null;
        }
    }   
}
