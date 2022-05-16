/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faridasadpour.classmodeling;

import java.util.Scanner;

/**
 *
 * @author faridasadpour
 */
public class SimpleCalculatorApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String operation;
        int op1, op2;
        SimpleCalculator sCal = new SimpleCalculator();
        while(true){
            System.out.println("Select operation: add, subtract, multiply, or divide.");
            System.out.println("If you want to exit, type exit.");
            operation = sc.nextLine();
            if(operation.equals("exit")){
                System.out.println("Thanks, bye.");
                break;
            }
            System.out.println("Enter the first operand: ");
            op1 = Integer.parseInt(sc.nextLine());
            System.out.println("Enter the first operand: ");
            op2 = Integer.parseInt(sc.nextLine());
            
            switch(operation){
                case "add": System.out.println("Result is " + sCal.add(op1, op2));
                break;
                case "subtract": System.out.println("Result is " + sCal.subtract(op1, op2));
                break;
                case "multiply": System.out.println("Result is " + sCal.multiply(op1, op2));
                break;
                case "divide": System.out.println("Result is " + sCal.divide(op1, op2));
                break;
                default: System.out.println("not a valid entry. try again.");
                break;
            }
        }
    }
}
