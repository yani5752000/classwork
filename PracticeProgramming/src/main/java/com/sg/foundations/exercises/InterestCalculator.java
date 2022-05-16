/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.exercises;

import java.util.Scanner;

/**
 *
 * @author faridasadpour
 */
public class InterestCalculator {
    public void calculateInterest(){
        Scanner sc = new Scanner(System.in);
        int interestRate, years;
        float principal;
        System.out.println("How much do you want to invest?");
        principal = (float) sc.nextInt();
        System.out.println("How many years are investing?");
        years = sc.nextInt();
        System.out.println("What is the annual interest rate % growth?");
        interestRate = sc.nextInt();
        float qRate = (interestRate / 4.00f);
        System.out.println("Calculating...");
        float increase;
        for(int i = 1; i <= years; i++){
            increase = principal * (1 + qRate / 100) * (1 + qRate / 100) * (1 + qRate / 100) * (1 + qRate / 100) - principal;
            System.out.println("Year " + i + ":");
            System.out.println("Began with $" + principal);
            System.out.println("Earned $" + increase);
            principal = principal * (1 + qRate / 100) * (1 + qRate / 100) * (1 + qRate / 100) * (1 + qRate / 100);
            
            System.out.println("Ended with $" + principal);
        }
    }
}
