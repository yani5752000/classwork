/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.controller;

import com.sg.addressbook.dao.AddressBookDao;
import com.sg.addressbook.dao.AddressBookPersistenceException;
import com.sg.addressbook.dao.AddressBookDaoFileImpl;
import com.sg.addressbook.dto.Address;
import com.sg.addressbook.service.AddressBookDataValidationException;
import com.sg.addressbook.service.AddressBookDuplicateLastNameException;
import com.sg.addressbook.service.AddressBookServiceLayer;
import com.sg.addressbook.ui.AddressBookView;
import com.sg.addressbook.ui.UserIO;
import com.sg.addressbook.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author faridasadpour
 */
public class AddressBookController {
    private AddressBookView view;
    private AddressBookServiceLayer service;
    
    public AddressBookController(AddressBookServiceLayer service, AddressBookView view) {
        this.service = service;
        this.view = view;
    }
   

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        
        try {
            while (keepGoing) {
            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    createAddress();
                    break;
                case 2:
                    removeAddress();
                    break;
                case 3:
                    viewAddress();
                    break;
                case 4:
                    viewAddressesCount();
                    break;
                case 5:
                    listAddresses();
                    break;
                    case 6:
                editAddress();
                    break;
                case 7:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }

        }
        exitMessage();
        } catch (AddressBookPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
        
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void createAddress() throws AddressBookPersistenceException {
        view.displayCreateAddressBanner();
        boolean hasErrors = false;
        
        do {
            Address newAddress = view.getNewAddressInfo();
            try {
                service.createAddress(newAddress);
                view.displayCreateSuccessBanner();
                hasErrors = false;
            } catch (AddressBookDuplicateLastNameException | AddressBookDataValidationException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);
        
        
    }
    
    private void listAddresses() throws AddressBookPersistenceException {
        view.displayDisplayAllBanner();
        List<Address> addressList = service.getAllAddresses();
        view.displayAddressList(addressList);
    }
    
    private void viewAddress() throws AddressBookPersistenceException {
        view.displayDisplayAddressBanner();
        String lastName = view.getLastNameChoice();
        Address address = service.getAddress(lastName);
        view.displayAddress(address);
    }
    
    private void removeAddress() throws AddressBookPersistenceException {
        view.displayRemoveAddressBanner();
        String lastName = view.getLastNameChoice();
        Address removedAddress = service.removeAddress(lastName);
        view.displayRemoveResult(removedAddress);
    }
    
    private void viewAddressesCount() throws AddressBookPersistenceException {
        view.displayAddressesCountBanner();
        List<Address> addressList = service.getAllAddresses();
        view.displayAddressesCount(addressList);
    }
    
    private void editAddress() throws AddressBookPersistenceException {
        view.displayEditAddressBanner();
        boolean hasErrors = false;
        
        do {
            Address newAddress = view.getEditAddressInfo();
            try {
                service.editAddress(newAddress);
                view.displayEditSuccessBanner();
                hasErrors = false;
            } catch (AddressBookDataValidationException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);
        
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
