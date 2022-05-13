package com.sg.foundations.exercises;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author faridasadpour
 */
public class Factorizer {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int number;
        System.out.println("Enter the number: ");
        number = sc.nextInt();
        System.out.println("The factors of " + number + " are");
        int sum = 0;
        int num = 0;
        for (int i = 1; i < number; i++){
            if(number % i == 0) {
                sum += i;
                num++;
                System.out.print(i + " ");
            }
        }
        System.out.println("");
        System.out.println("Total number of factors is " + num);
        if(sum == number){
            System.out.println(number + " is perfect number.");
        } else{
            System.out.println(number + " is not perfect number.");
        }
        if(num == 1){
            System.out.println(number + " is prime number.");
        } else{
            System.out.println(number + " is not prime number.");
        }
    }
}
