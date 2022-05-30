/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdcollection.dao;

import com.sg.dvdcollection.dto.DVD;
import java.util.List;

/**
 *
 * @author faridasadpour
 */
public interface DVDCollectionDao {
    /**
     * Adds the given DVD to the roster and associates it with the given
     * title. If there is already a DVD associated with the given
     * title it will return that DVD object, otherwise it will
     * return null.
     *
     * @param title title with which DVD is to be associated
     * @param DVD DVD to be added to the roster
     * @return the DVD object previously associated with the given  
     * DVD title if it exists, null otherwise
     */
    DVD addDVD(String title, DVD dVd) throws DVDCollectionDaoException;

    /**
     * Returns a List of all DVDs in the collection.
     *
     * @return List containing all DVDs in the collection.
     */
    List<DVD> getAllDVDs() throws DVDCollectionDaoException;

    /**
     * Returns the DVD object associated with the given title.
     * Returns null if no such DVD exists
     *
     * @param title title of the DVD to retrieve
     * @return the DVD object associated with the given title,  
     * null if no such DVD exists
     */
    DVD getDVD(String title) throws DVDCollectionDaoException;

    /**
     * Removes from the collection the DVD associated with the given title.
     * Returns the DVD object that is being removed or null if
     * there is no DVD associated with the given title
     *
     * @param title title of DVD to be removed
     * @return DVD object that was removed or null if no DVD
     * was associated with the given title
     */
    DVD removeDVD(String title) throws DVDCollectionDaoException;
}
