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
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author faridasadpour
 */
public class AddressBookServiceLayerImplTest {
    
    private AddressBookServiceLayer service;

    public AddressBookServiceLayerImplTest() {
        AddressBookDao dao = new AddressBookDaoStubImpl();
        AddressBookAuditDao auditDao = new AddressBookAuditDaoStubImpl();

        service = new AddressBookServiceLayerImpl(dao, auditDao);
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testCreateValidAddress() {
        // ARRANGE
        Address address = new Address();
        address.setFirstName("Charles");
        address.setLastName("Babbage");
        address.setStreetAddress("3 Nom Road");
        address.setCity("Brampton");
        address.setProvince("Nova Scotia");
        address.setPostalCode("G3G 3G3");
        
        // ACT
        try {
            service.createAddress(address);
        } catch (AddressBookDuplicateLastNameException
                | AddressBookDataValidationException
                | AddressBookPersistenceException e) {
        // ASSERT
            fail("Address was valid. No exception should have been thrown.");
        }
    }
    
    @Test
    public void testCreateDuplicateIdAddress() {
        // ARRANGE
        Address address = new Address();
        address.setFirstName("Ada1");
        address.setLastName("Lovelace");
        address.setStreetAddress("2 Hay1 Street");
        address.setCity("London1");
        address.setProvince("Ontario");
        address.setPostalCode("A1A 1A2");

        // ACT
        try {
            service.createAddress(address);
            fail("Expected DupeLastName Exception was not thrown.");
        } catch (AddressBookDataValidationException
                | AddressBookPersistenceException e) {
        // ASSERT
            fail("Incorrect exception was thrown.");
        } catch (AddressBookDuplicateLastNameException e){
            return;
        }
    }
    
    @Test
    public void testCreateAddressInvalidData() throws Exception {
        // ARRANGE
        Address address = new Address();
        address.setFirstName("");
        address.setLastName("Babbage");
        address.setStreetAddress("3 Nom Road");
        address.setCity("Brampton");
        address.setProvince("Nova Scotia");
        address.setPostalCode("G3G 3G3");

        // ACT
        try {
            service.createAddress(address);
            fail("Expected ValidationException was not thrown.");
        } catch (AddressBookDuplicateLastNameException
                | AddressBookPersistenceException e) {
        // ASSERT
            fail("Incorrect exception was thrown.");
        } catch (AddressBookDataValidationException e){
            return;
        }  
    }
    
    @Test
    public void testGetAllAddresses() throws Exception {
        // ARRANGE
        Address testClone = new Address();
        testClone.setFirstName("Ada");
        testClone.setLastName("Lovelace");
        testClone.setStreetAddress("2 Hay Street");
        testClone.setCity("London");
        testClone.setProvince("Ontario");
        testClone.setPostalCode("A1A 1A1");

        // ACT & ASSERT
        assertEquals( 1, service.getAllAddresses().size(), 
                                       "Should only have one addresst.");
        assertTrue( service.getAllAddresses().contains(testClone),
                                  "The one address should be Ada Lovelace's.");
    }
    
    @Test
    public void testGetAddressesCount() throws Exception {
        

        // ACT & ASSERT
        assertEquals( 1, service.getAllAddresses().size(), 
                                       "Should only have one address.");
    }
    
    @Test
    public void testGetAddress() throws Exception {
        // ARRANGE
        Address testClone = new Address();
        testClone.setFirstName("Ada");
        testClone.setLastName("Lovelace");
        testClone.setStreetAddress("2 Hay Street");
        testClone.setCity("London");
        testClone.setProvince("Ontario");
        testClone.setPostalCode("A1A 1A1");

        // ACT & ASSERT
        Address shouldBeAdaLovelace = service.getAddress("Lovelace");
        assertNotNull(shouldBeAdaLovelace, "Getting Lovelace should be not null.");
        assertEquals( testClone, shouldBeAdaLovelace,
                                       "Address stored under Lovelace should be Ada.");

        Address shouldBeNull = service.getAddress("Lovepage");    
        assertNull( shouldBeNull, "Getting Lovepage should be null.");

    }
    
    @Test
    public void testRemoveStudent() throws Exception {
        // ARRANGE
        Address testClone = new Address();
        testClone.setFirstName("Ada");
        testClone.setLastName("Lovelace");
        testClone.setStreetAddress("2 Hay Street");
        testClone.setCity("London");
        testClone.setProvince("Ontario");
        testClone.setPostalCode("A1A 1A1");

        // ACT & ASSERT
        Address shouldBeAdaLovelace = service.removeAddress("Lovelace");
        assertNotNull( shouldBeAdaLovelace, "Removing Lovelace should be not null.");
        assertEquals( testClone, shouldBeAdaLovelace, "Address removed from Lovelave should be Ada.");

        Address shouldBeNull = service.removeAddress("Lovepage");    
        assertNull( shouldBeNull, "Removing Lovepage should be null.");

    }
}
