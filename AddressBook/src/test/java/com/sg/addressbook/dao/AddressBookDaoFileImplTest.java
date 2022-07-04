/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dao;

import java.io.FileWriter;
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
public class AddressBookDaoFileImplTest {
    AddressBookDao testDao;
    
    public AddressBookDaoFileImplTest() {
    }
    
    @BeforeEach
    public void setUp() throws Exception{
        String testFile = "testAddresses.txt";
        // Use the FileWriter to quickly blank the file
        new FileWriter(testFile);
        testDao = new AddressBookDaoFileImpl(testFile);
    }
    
}
