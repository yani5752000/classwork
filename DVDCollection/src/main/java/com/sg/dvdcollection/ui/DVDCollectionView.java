/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdcollection.ui;

import com.sg.dvdcollection.dto.DVD;
import java.util.List;

/**
 *
 * @author faridasadpour
 */
public class DVDCollectionView {
    private UserIO io;
    
    public DVDCollectionView(UserIO io) {
    this.io = io;
}

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
            io.print("1. Add DVD");
            io.print("2. Remove DVD");
            io.print("3. Edit A DVD info");
            io.print("4. List all the DVDs");
            io.print("5. Display a DVD's info");
            io.print("6. Exit");

        return io.readInt("Please select from the"
                    + " above choices.", 1, 6);
    }
    
    public DVD getNewDVDInfo() {
        String title = io.readString("Please enter the title");
        String releaseDate = io.readString("Please enter Release Date");
        String mPAARating = io.readString("Please enter MPAA Rating");
        String director = io.readString("Please enter Ditrector's name");
        String studio = io.readString("Please enter Studio");
        String userRating = io.readString("Please enter user rating");
        DVD currentDVD = new DVD(title);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setmPAARating(mPAARating);
        currentDVD.setDirector(director);
        currentDVD.setStudio(studio);
        currentDVD.setUserRating(userRating);
        
        return currentDVD;
    }
    
    public void displayCreateDVDBanner() {
        io.print("=== Create DVD ===");
    }
    
    public void displayCreateSuccessBanner() {
        io.readString(
                "DVD successfully created.  Please hit enter to continue");
    }
    
    public void displayDVDList(List<DVD> dVDList) {
        for (DVD currentDVD : dVDList) {
            String dVDInfo = String.format("%s : %s %s %s %s %s",
                  currentDVD.getTitle(),
                  currentDVD.getReleaseDate(),
                  currentDVD.getmPAARating(),
                  currentDVD.getDirector(),
                  currentDVD.getStudio(),
                  currentDVD.getUserRating());
                  
            io.print(dVDInfo);
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayDisplayAllBanner() {
        io.print("=== Display All DVDs ===");
    }
    
    public void displayDisplayDVDBanner () {
        io.print("=== Display DVD ===");
    }

    public String getTitleChoice() {
        return io.readString("Please enter the Title.");
    }

    public void displayDVD(DVD dVD) {
        if (dVD != null) {
            io.print(dVD.getTitle());
            io.print(dVD.getReleaseDate());
            io.print(dVD.getmPAARating());
            io.print(dVD.getDirector());
            io.print(dVD.getStudio());
            io.print(dVD.getUserRating());
            
            io.print("");
        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayRemoveDVDBanner () {
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveResult(DVD dVDRecord) {
        if(dVDRecord != null){
          io.print("Student successfully removed.");
        }else{
          io.print("No such student.");
        }
        io.readString("Please hit enter to continue.");
    }
    
     public DVD getEditDVDInfo() {
        String title = io.readString("Please enter Title of the DVD you want to edit");
        String releaseDate = io.readString("Please enter Release Date");
        String mPAARating = io.readString("Please enter MPAA Rating");
        String director = io.readString("Please enter Director");
        String studio = io.readString("Please enter Studio");
        String userRating = io.readString("Please enter User Rating");
        DVD currentDVD = new DVD(title);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setmPAARating(mPAARating);
        currentDVD.setDirector(director);
        currentDVD.setStudio(studio);
        currentDVD.setUserRating(userRating);
        
        return currentDVD;
    }
    
    public void displayEditDVDBanner() {
        io.print("=== Edit DVD ===");
    }
    
    public void displayEditSuccessBanner() {
        io.readString(
                "DVD successfully edited.  Please hit enter to continue");
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
