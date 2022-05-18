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
        UserIO userIO = new UserIOImpl();
        String operation;
        int op1, op2;
        SimpleCalculator sCal = new SimpleCalculator();
        while(true){

            operation = userIO.readString("Select operation: add, subtract, multiply, or divide.\n" + "If you want to exit, type exit.");
            if(operation.equals("exit")){
                userIO.print("Thanks, bye.");
                break;
            }
           
            op1 = userIO.readInt("Enter the first operand: ");
          
            op2 = userIO.readInt("Enter the second operand: ");
            
            switch(operation){
                case "add": userIO.print("Result is " + sCal.add(op1, op2));
                break;
                case "subtract": userIO.print("Result is " + sCal.subtract(op1, op2));
                break;
                case "multiply": userIO.print("Result is " + sCal.multiply(op1, op2));
                break;
                case "divide": userIO.print("Result is " + sCal.divide(op1, op2));
                break;
                default: userIO.print("not a valid entry. try again.");
                break;
            }
        }
    }
}
