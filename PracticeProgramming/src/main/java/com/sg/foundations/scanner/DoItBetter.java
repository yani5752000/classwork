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
public class DoItBetter {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int distance;
        System.out.println("How many kilometers can you run?");
        
        distance = Integer.parseInt(sc.nextLine());
        int myDist = 2 * distance + 1;
        System.out.println("I can run " + myDist + " kilometers.");
    }
}
