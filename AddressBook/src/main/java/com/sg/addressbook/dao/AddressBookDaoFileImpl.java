/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dao;

import com.sg.addressbook.dto.Address;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author faridasadpour
 */
public class AddressBookDaoFileImpl implements AddressBookDao {
    private Map<String, Address> addresses = new HashMap<>();
    private final String ADDRESS_FILE;
    public static final String DELIMITER = "::";
    
    public AddressBookDaoFileImpl(){
        ADDRESS_FILE = "addresses.txt";
    }

    public AddressBookDaoFileImpl(String addressesTextFile){
        ADDRESS_FILE = addressesTextFile;
    }

    @Override
    public Address addAddress(String lastName, Address address) 
            throws AddressBookPersistenceException {
        loadAddresses();
        Address prevAddress = addresses.put(lastName, address);
        writeAddresses();
        return prevAddress;
    }
    @Override
    public List<Address> getAllAddresses() 
            throws AddressBookPersistenceException {
        loadAddresses();
        return new ArrayList<Address>(addresses.values());
    }

    @Override
    public int getAddressesCount() 
            throws AddressBookPersistenceException {
        loadAddresses();
        return addresses.size();
    }

    @Override
    public Address getAddress(String lastName) 
            throws AddressBookPersistenceException {
        loadAddresses();
        return addresses.get(lastName);
    }

    @Override
    public Address removeAddress(String lastName) throws 
            AddressBookPersistenceException {
        loadAddresses();
        Address removedAddress = addresses.remove(lastName);
        writeAddresses();
        return removedAddress;
    }
    
    private Address unmarshallAddress(String addressAsText){
        
        String[] addressTokens = addressAsText.split(DELIMITER);

        
        Address addressFromFile = new Address();

        
        
        addressFromFile.setFirstName(addressTokens[0]);
        addressFromFile.setLastName(addressTokens[1]);
        addressFromFile.setStreetAddress(addressTokens[2]);
        addressFromFile.setCity(addressTokens[3]);
        addressFromFile.setProvince(addressTokens[4]);
        addressFromFile.setPostalCode(addressTokens[5]);

        
        return addressFromFile;
    }
    
    private void loadAddresses() throws AddressBookPersistenceException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ADDRESS_FILE)));
        } catch (FileNotFoundException e) {
            throw new AddressBookPersistenceException(
                    "-_- Could not load roster data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentStudent holds the most recent student unmarshalled
        Address currentAddress;
        // Go through ROSTER_FILE line by line, decoding each line into a 
        // Student object by calling the unmarshallStudent method.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a Student
            currentAddress = unmarshallAddress(currentLine);

            // We are going to use the student id as the map key for our student object.
            // Put currentStudent into the map using student id as the key
            addresses.put(currentAddress.getLastName(), currentAddress);
        }
        // close scanner
        scanner.close();
    }
    private String marshallAddress(Address anAddress){
        
        String addressAsText = anAddress.getFirstName() + DELIMITER;
        addressAsText += anAddress.getLastName() + DELIMITER;
        addressAsText += anAddress.getStreetAddress() + DELIMITER;
        addressAsText += anAddress.getCity() + DELIMITER;
        addressAsText += anAddress.getProvince() + DELIMITER;
        addressAsText += anAddress.getPostalCode();

        return addressAsText;
    }
    
    /**
 * Writes all students in the roster out to a ROSTER_FILE.  See loadRoster
 * for file format.
 * 
 * @throws ClassRosterDaoException if an error occurs writing to the file
 */
private void writeAddresses() throws AddressBookPersistenceException {
 
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ADDRESS_FILE));
        } catch (IOException e) {
            throw new AddressBookPersistenceException(
                    "Could not save address data.", e);
        }

        
        String addressAsText;
        List<Address> addressList = this.getAllAddresses();
        for (Address currentAddress : addressList) {
            // turn a Student into a String
            addressAsText = marshallAddress(currentAddress);
            // write the Student object to the file
            out.println(addressAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }
}
