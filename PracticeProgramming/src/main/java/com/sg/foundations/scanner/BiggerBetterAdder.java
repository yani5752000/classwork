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
public class BiggerBetterAdder {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a, b, c;
        System.out.println("Enter the first number.");
        a = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the second number.");
        b = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the third number.");
        c = Integer.parseInt(sc.nextLine());
        int d = a + b + c;
        System.out.println("The sum of the numbers entered is " + d );
    }
}
