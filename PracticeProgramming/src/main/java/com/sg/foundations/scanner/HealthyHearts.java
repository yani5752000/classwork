/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.scanner;

import java.util.Scanner;

/**
 *
 * @author faridasadpour
 */
public class HealthyHearts {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int age, maxRate, lower, higher;
        System.out.println("What is your age?");
        age = Integer.parseInt(sc.nextLine());
        maxRate = 220 - age;
        lower = (int) Math.ceil(maxRate * 0.50f);
        higher = (int) Math.ceil(maxRate * 0.85f);
        System.out.println("Your maximum heart rate should be " + maxRate + " beats per minute.");
        System.out.println("Your target HR Zone is " + lower + "-" + higher + " beats per minute.");
        
    }
}
