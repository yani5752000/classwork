/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.controller;

import com.sg.addressbook.dao.AddressBookDao;
import com.sg.addressbook.dao.AddressBookDaoException;
import com.sg.addressbook.dao.AddressBookDaoFileImpl;
import com.sg.addressbook.dto.Address;
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
    private AddressBookDao dao;
    
    public AddressBookController(AddressBookDao dao, AddressBookView view) {
        this.dao = dao;
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
        } catch (AddressBookDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
        
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void createAddress() throws AddressBookDaoException {
        view.displayCreateAddressBanner();
        Address newAddress = view.getNewAddressInfo();
        dao.addAddress(newAddress.getLastName(), newAddress);
        view.displayCreateSuccessBanner();
    }
    
    private void listAddresses() throws AddressBookDaoException {
        view.displayDisplayAllBanner();
        List<Address> addressList = dao.getAllAddresses();
        view.displayAddressList(addressList);
    }
    
    private void viewAddress() throws AddressBookDaoException {
        view.displayDisplayAddressBanner();
        String lastName = view.getLastNameChoice();
        Address address = dao.getAddress(lastName);
        view.displayAddress(address);
    }
    
    private void removeAddress() throws AddressBookDaoException {
        view.displayRemoveAddressBanner();
        String lastName = view.getLastNameChoice();
        Address removedAddress = dao.removeAddress(lastName);
        view.displayRemoveResult(removedAddress);
    }
    
    private void viewAddressesCount() throws AddressBookDaoException {
        view.displayAddressesCountBanner();
        List<Address> addressList = dao.getAllAddresses();
        view.displayAddressesCount(addressList);
    }
    
    private void editAddress() throws AddressBookDaoException {
        view.displayEditAddressBanner();
        Address newAddress = view.getEditAddressInfo();
        dao.addAddress(newAddress.getLastName(), newAddress);
        view.displayEditSuccessBanner();
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
