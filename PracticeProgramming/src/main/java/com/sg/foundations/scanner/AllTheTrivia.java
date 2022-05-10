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
public class AllTheTrivia {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String unit, clo, volc, abund;
        System.out.println("What unit is equivalent to 1,024 Gigabytes?");
        unit = userInput.nextLine();
        System.out.println("Which planet is the only one that rotates clockwise in our Solar System?");
        clo = userInput.nextLine();
        System.out.println("The largest volcano ever discovered in our Solar System is located on which planet?");
        volc = userInput.nextLine();
        System.out.println("What is the most abundant element in the earth's atmosphere?");
        abund = userInput.nextLine();
        System.out.println("Wow, 1,024 Gigabytes is a " + volc + "!");
        System.out.println("I didn't know that the largest ever volcano was discovered on "+ unit + "!");
        System.out.println("That's amazing that " + clo + " is the most abundant element in the atmosphere...");
        System.out.println(abund + " is the only planet that rotates clockwise, neat!");
        
        
    }
    
}
