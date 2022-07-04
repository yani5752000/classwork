/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.service;

import com.sg.addressbook.dao.AddressBookAuditDao;
import com.sg.addressbook.dao.AddressBookPersistenceException;

/**
 *
 * @author faridasadpour
 */
public class AddressBookAuditDaoStubImpl implements AddressBookAuditDao {
    @Override
    public void writeAuditEntry(String entry) throws AddressBookPersistenceException {
        //do nothing . . .
    }
}
