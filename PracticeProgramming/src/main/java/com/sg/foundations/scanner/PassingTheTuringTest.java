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
public class PassingTheTuringTest {
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        String name, color, fruit;
        int number;
        System.out.println("Hello there!");
        System.out.println("What's your name?");
        name = userInput.nextLine();
        System.out.println("Hi, " + name + "!  I'm Alice.");
        System.out.println("What's your favorite color?");
        color = userInput.nextLine();
        System.out.println("Huh, " + color + "? Mine's Electric Lime.");
        System.out.println("I really like limes. They're my favorite fruit, too.");
        System.out.println("What's YOUR favorite fruit, Zaphod?");
        fruit = userInput.nextLine();
        System.out.println("Really? " + fruit + "? That's wild!");
        System.out.println("Speaking of favorites, what's your favorite number?");
        number = Integer.parseInt(userInput.nextLine());
        System.out.println(number + " is a cool number. Mine's -7.");
        System.out.println("Did you know " + number + " * -7 is " + number * -7 + "? That's a cool number too!");
        System.out.println("");
        System.out.println("Well, thanks for talking to me, Zaphod!");
        System.out.println("");
    }
}
