/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdcollection.dao;

import com.sg.dvdcollection.dto.DVD;
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
public class DVDCollectionDaoFileImpl implements DVDCollectionDao {
    private Map<String, DVD> dVDs = new HashMap<>();
    public static final String DVDS_FILE = "dvds.txt";
    public static final String DELIMITER = "::";

    @Override
    public DVD addDVD(String title, DVD dVD) 
    throws DVDCollectionDaoException {
        loadDVDs();
        DVD prevDVD = dVDs.put(title, dVD);
        writeDVDs();
        return prevDVD;
    }

    @Override
    public List<DVD> getAllDVDs() 
     throws DVDCollectionDaoException {
        loadDVDs();
        return new ArrayList<DVD>(dVDs.values());
    }

    @Override
    public DVD getDVD(String title) 
     throws DVDCollectionDaoException {
        loadDVDs();
        return dVDs.get(title);
    }

    @Override
    public DVD removeDVD(String title) 
     throws DVDCollectionDaoException {
        loadDVDs();
        DVD removedDVD = dVDs.remove(title);
        writeDVDs();
        return removedDVD;
    }
    
    private DVD unmarshallDVD(String dVDAsText){
        
        String[] dVDTokens = dVDAsText.split(DELIMITER);

        
        String title = dVDTokens[0];

        
        DVD dVDFromFile = new DVD(title);

        
        dVDFromFile.setReleaseDate(dVDTokens[1]);
        dVDFromFile.setmPAARating(dVDTokens[2]);
        dVDFromFile.setDirector(dVDTokens[3]);
        dVDFromFile.setStudio(dVDTokens[4]);
        dVDFromFile.setUserRating(dVDTokens[5]);

        return dVDFromFile;
    }
    
    private void loadDVDs() throws DVDCollectionDaoException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(DVDS_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDCollectionDaoException(
                    "-_- Could not load roster data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentStudent holds the most recent student unmarshalled
        DVD currentDVD;
        
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
           
            currentDVD = unmarshallDVD(currentLine);

            dVDs.put(currentDVD.getTitle(), currentDVD);
        }
        // close scanner
        scanner.close();
    }
    
    private String marshallDVD(DVD aDVD){
        
        String dVDAsText = aDVD.getTitle() + DELIMITER;

        // add the rest of the properties in the correct order:

        
        dVDAsText += aDVD.getReleaseDate() + DELIMITER;
        dVDAsText += aDVD.getmPAARating() + DELIMITER;
        dVDAsText += aDVD.getDirector() + DELIMITER;
        dVDAsText += aDVD.getStudio() + DELIMITER;
        dVDAsText += aDVD.getUserRating();

        return dVDAsText;
    }
    
    /**
    * Writes all students in the roster out to a ROSTER_FILE.  See loadRoster
    * for file format.
    * 
    * @throws ClassRosterDaoException if an error occurs writing to the file
    */
   private void writeDVDs() throws DVDCollectionDaoException {
       
       PrintWriter out;

       try {
           out = new PrintWriter(new FileWriter(DVDS_FILE));
       } catch (IOException e) {
           throw new DVDCollectionDaoException(
                   "Could not save DVD data.", e);
       }

       
       String dVDAsText;
       List<DVD> dVDList = this.getAllDVDs();
       for (DVD currentDVD : dVDList) {
           
           dVDAsText = marshallDVD(currentDVD);
           
           out.println(dVDAsText);
           // force PrintWriter to write line to the file
           out.flush();
       }
       // Clean up
       out.close();
   }
}
