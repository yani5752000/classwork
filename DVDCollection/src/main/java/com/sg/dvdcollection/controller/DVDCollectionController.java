/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdcollection.controller;

import com.sg.dvdcollection.dao.DVDCollectionDao;
import com.sg.dvdcollection.dao.DVDCollectionDaoException;
import com.sg.dvdcollection.dao.DVDCollectionDaoFileImpl;
import com.sg.dvdcollection.dto.DVD;
import com.sg.dvdcollection.ui.DVDCollectionView;
import com.sg.dvdcollection.ui.UserIO;
import com.sg.dvdcollection.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author faridasadpour
 */
public class DVDCollectionController {
    private DVDCollectionView view;
    private UserIO io;
    private DVDCollectionDao dao = new DVDCollectionDaoFileImpl();
    
    public DVDCollectionController(DVDCollectionDao dao, DVDCollectionView view) {
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
                        createDVD();
                        break;
                    case 2:
                        removeDVD();
                        break;
                    case 3:
                        editDVD();
                        break;
                    case 4:
                        listDVDs();
                        break;
                    case 5:
                        viewDVD();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (DVDCollectionDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
        
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void createDVD() throws DVDCollectionDaoException {
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayCreateSuccessBanner();
    }
    
    private void listDVDs() throws DVDCollectionDaoException {
        view.displayDisplayAllBanner();
        List<DVD> dVDList = dao.getAllDVDs();
        view.displayDVDList(dVDList);
    }
    
    private void viewDVD() throws DVDCollectionDaoException {
        view.displayDisplayDVDBanner();
        String title = view.getTitleChoice();
        DVD dVD = dao.getDVD(title);
        view.displayDVD(dVD);
    }
    
    private void removeDVD() throws DVDCollectionDaoException {
        view.displayRemoveDVDBanner();
        String title = view.getTitleChoice();
        DVD removedDVD = dao.removeDVD(title);
        view.displayRemoveResult(removedDVD);
    }
    
    private void editDVD() throws DVDCollectionDaoException {
        view.displayEditDVDBanner();
        DVD newDVD = view.getEditDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayEditSuccessBanner();
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
