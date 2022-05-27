/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.sqg.dto;

import java.util.ArrayList;

/**
 *
 * @author faridasadpour
 */
public class Student {
    private String name;
    private ArrayList<Integer> grades;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getGrades(){
        return this.grades;
    }
    
    public void setGrades(ArrayList<Integer> grades){
        this.grades = grades;
    }
}
