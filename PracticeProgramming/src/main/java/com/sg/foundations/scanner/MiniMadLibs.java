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
public class MiniMadLibs {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String noun1;
        String adjective1;
        String noun2;
        String number;
        String adjective2;
        String pluralNoun1;
        String pluralNoun2;
        String pluralNoun3;
        String verbPresent;
        String verbPast;
        System.out.println("Enter the first noun: ");
        noun1 = sc.nextLine();
        System.out.println("Enter the first adjective: ");
        adjective1 = sc.nextLine();
        System.out.println("Enter the second noun: ");
        noun2 = sc.nextLine();
        System.out.println("Enter the number: ");
        number = sc.nextLine();
        System.out.println("Enter the second adjective: ");
        adjective2 = sc.nextLine();
        System.out.println("Enter the first plural noun: ");
        pluralNoun1 = sc.nextLine();
        System.out.println("Enter the second plural noun: ");
        pluralNoun2 = sc.nextLine();
        System.out.println("Enter the third plural noun: ");
        pluralNoun3 = sc.nextLine();
        System.out.println("Enter the present tense verb: ");
        verbPresent = sc.nextLine();
        System.out.println("Enter the past tense verb: ");
        verbPast = sc.nextLine();
        
        System.out.println(noun1 + ": the " + adjective1 + " frontier. These are the voyages of the starship " + noun2 + ". Its " + number + "-year mission: to explore strange " + adjective2 + " " + pluralNoun1 + ", to seek out " + adjective2 + " " + pluralNoun2 + " and " + adjective2 + " " + pluralNoun3 + ", to boldly " + verbPresent + " where no one has " + verbPast + " before.");
        
    }
}
