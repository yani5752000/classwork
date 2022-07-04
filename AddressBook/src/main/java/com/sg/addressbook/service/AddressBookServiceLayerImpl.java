/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.service;

import com.sg.addressbook.dao.AddressBookAuditDao;
import com.sg.addressbook.dao.AddressBookDao;
import com.sg.addressbook.dao.AddressBookPersistenceException;
import com.sg.addressbook.dto.Address;
import java.util.List;

/**
 *
 * @author faridasadpour
 */
public class AddressBookServiceLayerImpl implements AddressBookServiceLayer {
    private AddressBookAuditDao auditDao;
    AddressBookDao dao;
   
    public AddressBookServiceLayerImpl(AddressBookDao dao, AddressBookAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }
    
    @Override
    public void createAddress(Address address) throws
            AddressBookDuplicateLastNameException,
            AddressBookDataValidationException,
            AddressBookPersistenceException {
        if (dao.getAddress(address.getLastName()) != null) {
            throw new AddressBookDuplicateLastNameException(
                    "ERROR: Could not create address.  Last name "
                    + address.getLastName()
                    + " already exists");
        }
        validateAddressData(address);
        dao.addAddress(address.getLastName(), address);
        auditDao.writeAuditEntry(
            "Address for " + address.getLastName() + " CREATED.");
    }
    
    @Override
    public void editAddress(Address address) throws
            AddressBookDataValidationException,
            AddressBookPersistenceException {
        validateAddressData(address);
        dao.addAddress(address.getLastName(), address);
        auditDao.writeAuditEntry(
            "Address for " + address.getLastName() + " edited.");
    }

    @Override
    public List<Address> getAllAddresses() throws
            AddressBookPersistenceException {
        return dao.getAllAddresses();
    }
    
    @Override
    public int getAddressesCount() throws
            AddressBookPersistenceException {
        return dao.getAddressesCount();
    }

    @Override
    public Address getAddress(String lastName) throws
            AddressBookPersistenceException {
        return dao.getAddress(lastName);
    }

    @Override
    public Address removeAddress(String lastName) throws
            AddressBookPersistenceException {
        Address removedAddress = dao.removeAddress(lastName);
        auditDao.writeAuditEntry(
            "Address for " + lastName + " was removed.");
        return removedAddress;
    }
    
    private void validateAddressData(Address address) throws
            AddressBookDataValidationException {

        if (address.getFirstName() == null
                || address.getFirstName().trim().length() == 0
                || address.getLastName() == null
                || address.getLastName().trim().length() == 0
                || address.getStreetAddress() == null
                || address.getStreetAddress().trim().length() == 0
                || address.getCity() == null
                || address.getCity().trim().length() == 0){

            throw new AddressBookDataValidationException(
                    "ERROR: All fields [First Name, Last Name, Street Address, City] are required.");
        }
    }
}
