/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.sqg.dao;

import com.sg.sqg.dto.Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author faridasadpour
 */
public interface SQGDao {
    /**
     * Adds the given grades to the List and associates it with the given
     * student name. If there are already grades already associated with the given
     * student name it will return those grades, otherwise it will
     * return null.
     *
     * @param studentName name with which student is to be associated
     * @param student student to be added to the list
     * @return the Student object previously associated with the given  
     * student id if it exists, null otherwise
     */
    ArrayList<Integer> addStudent(String studentName, ArrayList<Integer> grades) 
            throws SQGDaoException;

    /**
     * Returns a List of all students in the roster.
     *
     * @return List containing all students' names in the roster.
     */
    List<String> getAllStudents()
            throws SQGDaoException;

    /**
     * Returns the student's grades ArrayList associated with the given student name.
     * Returns null if no such student exists
     *
     * @param studentName of the student to retrieve
     * @return the ArrayList of grades associated with the given student name,  
     * null if no such student exists
     */
    
    ArrayList<Integer> getStudentGrades(String studentName)
            throws SQGDaoException;

    /**
     * Removes from the system the student associated with the given name.
     * Returns the grades ArrayList of the student that is being removed or null if
     * there is no student associated with the given name
     *
     * @param studentName id of student to be removed
     * @return the grades ArrayList of the student that is being removed or null if no student
     * was associated with the given student Name
     */
    ArrayList<Integer> removeStudent(String studentName)
            throws SQGDaoException;
    /**
     * Returns the student's grades' average double associated with the given student name.
     * Returns null if no such student exists
     *
     * @param studentName of the student to retrieve
     * @return the double grades average associated with the given student name,  
     * null if no such student exists
     */
    double getStudentGradesAverage(String studentName)
            throws SQGDaoException;
}
