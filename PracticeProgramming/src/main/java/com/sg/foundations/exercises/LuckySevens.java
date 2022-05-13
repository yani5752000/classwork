/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.exercises;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author faridasadpour
 */
public class LuckySevens {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random ra = new Random();
        int cash;
        int die1, die2;
        int maxCash = 0;
        int rolls = 0; 
        int maxRolls = 0;
        System.out.println("How many dollars do you have?");
        cash = sc.nextInt();
        while(cash > 0){
            rolls++;
            die1 = ra.nextInt(6) + 1;
            die2 = ra.nextInt(6) + 1;
            if(die1 + die2 == 7){
                cash += 4;
            } else{
                cash--;
            }
            if(cash > maxCash){
                maxCash = cash;
                maxRolls = rolls;
            }
        }
        System.out.println("You are broke after " + rolls + " rolls.");
        System.out.println("You should have quit after " + maxRolls + " rolls when you had $" + maxCash + ".");
        
    }
}
