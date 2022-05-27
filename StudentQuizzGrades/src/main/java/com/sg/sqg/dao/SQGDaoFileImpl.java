/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.sqg.dao;

import com.sg.sqg.dto.Student;
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
import java.util.Set;

/**
 *
 * @author faridasadpour
 */
public class SQGDaoFileImpl implements SQGDao {
    private Map<String, ArrayList<Integer>> students = new HashMap<>();
    public static final String SQG_FILE = "sqg.txt";
    public static final String DELIMITER = "::";

    @Override
    public ArrayList<Integer> addStudent(String studentName, ArrayList<Integer> grades) 
     throws SQGDaoException {
        loadSQG();
        ArrayList<Integer> prevGrades = students.put(studentName, grades);
        writeSQG();
        return prevGrades;
    }

    @Override
    public List<String> getAllStudents() 
    throws SQGDaoException {
       loadSQG();
       return new ArrayList<String>(students.keySet());
   }

    @Override
    public ArrayList<Integer> getStudentGrades(String studentName) 
    throws SQGDaoException {
       loadSQG();
       return students.get(studentName);
   }

    @Override
    public ArrayList<Integer> removeStudent(String studentName) 
    throws SQGDaoException {
       loadSQG();
       ArrayList<Integer> removedStudentGrades = students.remove(studentName);
       writeSQG();
       return removedStudentGrades;
   }

    @Override
    public double getStudentGradesAverage(String studentName) 
    throws SQGDaoException {
        loadSQG();
        ArrayList<Integer> grades = students.get(studentName);
        if(grades == null){
            return -1.00;
        }
        if(grades.size() == 0){
            return -2.00;
        }
        int total = 0;
        for(int i = 0; i < grades.size(); i++){
            total += grades.get(i);
        }
        return ((double) total) / grades.size();
    }
    
    private Student unmarshallStudent(String studentAsText){
        // studentAsText is expecting a line read in from our file.
        // For example, it might look like this:
        // 1234::Ada::Lovelace::Java-September1842
        //
        // We then split that line on our DELIMITER - which we are using as ::
        // Leaving us with an array of Strings, stored in studentTokens.
        // Which should look like this:
        // ______________________________________
        // |    |   |        |                  |
        // |1234|Ada|Lovelace|Java-September1842|
        // |    |   |        |                  |
        // --------------------------------------
        //  [0]  [1]    [2]         [3]
        String[] studentTokens = studentAsText.split(DELIMITER);

        // Given the pattern above, the student Id is in index 0 of the array.
        String studentName = studentTokens[0];

        // Which we can then use to create a new Student object to satisfy
        // the requirements of the Student constructor.
        Student studentFromFile = new Student(studentName);

        // However, there are 3 remaining tokens that need to be set into the
        // new student object. Do this manually by using the appropriate setters.

        // Index 1 - FirstName
        ArrayList<Integer> grades = new ArrayList<Integer>();
        for(int i = 1 ;i < studentTokens.length; i ++){
            grades.add(Integer.parseInt(studentTokens[i]));
        }
        studentFromFile.setGrades(grades);

        // We have now created a student! Return it!
        return studentFromFile;
    }
    
    private void loadSQG() throws SQGDaoException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(SQG_FILE)));
        } catch (FileNotFoundException e) {
            throw new SQGDaoException(
                    "-_- Could not load roster data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentStudent holds the most recent student unmarshalled
        Student currentStudent;
        // Go through ROSTER_FILE line by line, decoding each line into a 
        // Student object by calling the unmarshallStudent method.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a Student
            currentStudent = unmarshallStudent(currentLine);

            // We are going to use the student id as the map key for our student object.
            // Put currentStudent into the map using student id as the key
            students.put(currentStudent.getName(), currentStudent.getGrades());
        }
        // close scanner
        scanner.close();
    }
    
    private String marshallStudent(Student aStudent){
        // We need to turn a Student object into a line of text for our file.
        // For example, we need an in memory object to end up like this:
        // 4321::Charles::Babbage::Java-September1842

        // It's not a complicated process. Just get out each property,
        // and concatenate with our DELIMITER as a kind of spacer. 

        // Start with the student id, since that's supposed to be first.
        String studentAsText = aStudent.getName();

        // add the rest of the properties in the correct order:
        
        ArrayList<Integer> grades = aStudent.getGrades();
        for(int i = 0; i < grades.size(); i++){
            studentAsText += DELIMITER + grades.get(i);
        }


        // We have now turned a student to text! Return it!
        return studentAsText;
    }
    
    /**
    * Writes all students in the roster out to a ROSTER_FILE.  See loadRoster
    * for file format.
    * 
    * @throws ClassRosterDaoException if an error occurs writing to the file
    */
    private void writeSQG() throws SQGDaoException {
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and 
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to 
        // handle any errors that occur.
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(SQG_FILE));
        } catch (IOException e) {
            throw new SQGDaoException(
                    "Could not save student data.", e);
        }

        // Write out the Student objects to the roster file.
        // NOTE TO THE APPRENTICES: We could just grab the student map,
        // get the Collection of Students and iterate over them but we've
        // already created a method that gets a List of Students so
        // we'll reuse it.
        String studentAsText;
//        Map<String, ArrayList<Integer>> theStudents = students;
        for (String studentName : students.keySet()) {
            Student currentStudent = new Student(studentName);
            currentStudent.setGrades(students.get(studentName));
            // turn a Student into a String
            studentAsText = marshallStudent(currentStudent);
            // write the Student object to the file
            out.println(studentAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }
}
