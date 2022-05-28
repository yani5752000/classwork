/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.ui;

import com.sg.addressbook.dto.Address;
import java.util.List;

/**
 *
 * @author faridasadpour
 */
public class AddressBookView {
    private UserIO io;
    
    public AddressBookView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Create Address");
        io.print("2. Remove an Address");
        io.print("3. View address");
        io.print("4. View the number of addresses");
        io.print("5. View all the addresses");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }
    
    public Address getNewAddressInfo() {
        String firstName = io.readString("Please enter First Name");
        String lastName = io.readString("Please enter Last Name");
        String streetAddress = io.readString("Please enter street address");
        String city = io.readString("Please enter City");
        String province = io.readString("Please enter Province");
        String postalCode = io.readString("Please enter Postal Code");
        Address currentAddress = new Address();
        currentAddress.setFirstName(firstName);
        currentAddress.setLastName(lastName);
        currentAddress.setStreetAddress(streetAddress);
        currentAddress.setCity(city);
        currentAddress.setProvince(province);
        currentAddress.setPostalCode(postalCode);
        return currentAddress;
    }
    
    public void displayCreateAddressBanner() {
        io.print("=== Create Adddress ===");
    }
    
    public void displayCreateSuccessBanner() {
        io.readString(
                "Address successfully created.  Please hit enter to continue");
    }
    
    public void displayAddressList(List<Address> addressList) {
        for (Address currentAddress : addressList) {
            String addressInfo = String.format("%s %s %s",
                  currentAddress.getFirstName() + " " + currentAddress.getLastName(),
                  currentAddress.getStreetAddress(),
                  currentAddress.getCity() + ", " + currentAddress.getProvince() + ", "
            + " " + currentAddress.getPostalCode());
            io.print(addressInfo);
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayDisplayAllBanner() {
        io.print("=== Display All Addresses ===");
    }
    
    public void displayDisplayAddressBanner () {
        io.print("=== Display Address ===");
    }

    public String getLastNameChoice() {
        return io.readString("Please enter the Last Name.");
    }

    public void displayAddress(Address address) {
        if (address != null) {
            io.print(address.getFirstName() + " " + address.getLastName());
            io.print(address.getStreetAddress());
            io.print(address.getCity());
            io.print(address.getProvince());
            io.print(address.getPostalCode());
            io.print("");
        } else {
            io.print("No such address.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayRemoveAddressBanner () {
        io.print("=== Remove Address ===");
    }

    public void displayRemoveResult(Address addressRecord) {
        if(addressRecord != null){
          io.print("Address successfully removed.");
        }else{
          io.print("No such address.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayAddressesCountBanner() {
        io.print("=== Number of Addresses ===");
    }
    
    public void displayAddressesCount(List<Address> addressList) {
        io.print(addressList.size());
        io.readString("Please hit enter to continue.");
    }
    
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
