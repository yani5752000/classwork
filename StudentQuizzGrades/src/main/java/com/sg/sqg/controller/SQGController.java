/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.sqg.controller;

import com.sg.sqg.dao.SQGDao;
import com.sg.sqg.dao.SQGDaoException;
import com.sg.sqg.dao.SQGDaoFileImpl;
import com.sg.sqg.dto.Student;
import com.sg.sqg.ui.SQGView;
import com.sg.sqg.ui.UserIO;
import com.sg.sqg.ui.UserIOConsoleImpl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author faridasadpour
 */
public class SQGController {
    private SQGView view;
    private SQGDao dao;
    
    public SQGController(SQGDao dao, SQGView view) {
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
                        listStudents();
                        break;
                    case 2:
                        createStudent();
                        break;
                    case 3:
                        removeStudent();
                        break;
                    case 4:
                        viewStudentGrades();
                        break;
                    case 5:
                        viewStudentAverageQuizScore();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (SQGDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void createStudent() throws SQGDaoException{
        view.displayCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getName(), newStudent.getGrades());
        view.displayCreateSuccessBanner();
    }
    
    private void listStudents() throws SQGDaoException{
        view.displayDisplayAllBanner();
        List<String> studentList = dao.getAllStudents();
        view.displayStudentList(studentList);
    }
    
    private void viewStudentGrades() throws SQGDaoException{
        view.displayDisplayStudentGradesBanner();
        String studentName = view.getStudentNameChoice();
        ArrayList<Integer> grades = dao.getStudentGrades(studentName);
        view.displayStudentGrades(grades);
    }
    
    private void removeStudent() throws SQGDaoException{
        view.displayRemoveStudentBanner();
        String studentName = view.getStudentNameChoice();
        ArrayList<Integer> removedStudentGrades = dao.removeStudent(studentName);
        view.displayRemoveResult(removedStudentGrades);
    }
    
    private void viewStudentAverageQuizScore() throws SQGDaoException{
        view.displayStudentGradesAverageBanner();
        String studentName = view.getStudentNameChoice();
        double average = dao.getStudentGradesAverage(studentName);
        view.displayStudentGradesAverage(average);
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
