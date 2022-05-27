/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.sqg.ui;

import com.sg.sqg.dto.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author faridasadpour
 */
public class SQGView {
    private UserIO io;
    
    public SQGView(UserIO io) {
    this.io = io;
}

    public int printMenuAndGetSelection() {
        io.print("1. List Students");
        io.print("2. Create New Student");
        io.print("3. Remove a Student");
        io.print("4. View a Student's List of Quiz Scores");
        io.print("5. View Average Quiz Score for a Given Student");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }
    
    public Student getNewStudentInfo() {
        String studentName = io.readString("Please enter Student's name");
        ArrayList<Integer> grades = new ArrayList<Integer>();
        io.print("Enter the student's grades. Enter -1 when done.");
        int grade;
        while(true){
            grade = io.readInt("Enter the student's grade. Enter -1 when done.");
            if(grade == -1){
                break;
            }
            grades.add(grade);
        }
        
        Student currentStudent = new Student(studentName);
        currentStudent.setGrades(grades);
      
        return currentStudent;
    }
    public void displayCreateStudentBanner() {
        io.print("=== Create Student ===");
    }
    public void displayCreateSuccessBanner() {
        io.readString(
                "Student successfully created.  Please hit enter to continue");
    }
    public void displayStudentList(List<String> studentList) {
        for (String currentStudent : studentList) {
            io.print(currentStudent);
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayDisplayAllBanner() {
        io.print("=== Display All Students ===");
    }
    
    public void displayDisplayStudentGradesBanner () {
        io.print("=== Display Student's Grades ===");
    }

    public String getStudentNameChoice() {
        return io.readString("Please enter the Student Name.");
    }

    public void displayStudentGrades(ArrayList<Integer> grades) {
        if (grades != null && grades.size() != 0) {
            for(int i = 0; i < grades.size(); i++){
                io.print(grades.get(i));
            }
        } else if(grades != null && grades.size() == 0){
            io.print("This student has no grades.");
        } else {
            io.print("No such student.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayRemoveStudentBanner () {
        io.print("=== Remove Student ===");
    }
    

    public void displayRemoveResult(ArrayList<Integer> returnedGrades) {
        if(returnedGrades != null){
          io.print("Student successfully removed.");
        }else{
          io.print("No such student.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayStudentGradesAverageBanner () {
        io.print("=== View Grades Average for Student ===");
    }
    

    public void displayStudentGradesAverage(double average) {
        if (average == -1.00) {
            io.print("There is no such student.");
        } else if(average == -2.00){
            io.print("this student has no grades.");
        } else {
            io.print(average);
        }
        
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
