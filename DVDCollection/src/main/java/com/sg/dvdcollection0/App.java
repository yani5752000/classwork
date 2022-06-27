/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdcollection0;

import com.sg.dvdcollection.controller.DVDCollectionController;
import com.sg.dvdcollection.dao.DVDCollectionDao;
import com.sg.dvdcollection.dao.DVDCollectionDaoFileImpl;
import com.sg.dvdcollection.ui.DVDCollectionView;
import com.sg.dvdcollection.ui.UserIO;
import com.sg.dvdcollection.ui.UserIOConsoleImpl;

/**
 *
 * @author faridasadpour
 */
public class App {
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        DVDCollectionView myView = new DVDCollectionView(myIo);
        DVDCollectionDao myDao = new DVDCollectionDaoFileImpl();
        DVDCollectionController controller =
                new DVDCollectionController(myDao, myView);
        controller.run();
    }  
}
