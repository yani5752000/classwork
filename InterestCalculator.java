/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterestCalculatorPackage;

import java.util.Scanner;

/**
 *
 * @author salajrawi
 */
public class InterestCalculator {
    public void calculate(){
        double currentBalance, interestRate, updatedBalance;
        int divisor = 1;
        int i, j, numYears, method;
       
        
        System.out.print("How much do you want to invest? ");
         Scanner in = new Scanner(System.in);
         currentBalance = Double.parseDouble(in.nextLine());
        
        System.out.print("How many years are investing? ");
        numYears = Integer.parseInt(in.nextLine());
        
        System.out.print("What is the annual interest rate % growth? ");
        interestRate = Double.parseDouble(in.nextLine());
        
        System.out.println("How would you like interest compounded");
        System.out.println("1) Quarterly   2) Monthly   3) Daily");
        method = Integer.parseInt(in.nextLine());
        if(method == 1){
            divisor = 4;
        }else if(method == 2){
            divisor = 12;
        }else {
            divisor = 365;
        }
        
        interestRate /= divisor;
        System.out.println();
        
        for(i = 1; i <= numYears; i++){
            updatedBalance = currentBalance;
            for(j = 0; j < divisor; j++){
                updatedBalance *= (1+(interestRate/100));
            }
            
            System.out.println("Year " + i + ":");
            System.out.println("Began with $" + currentBalance);
            System.out.println("Earned $" + (updatedBalance -currentBalance));
            System.out.println("Ended with $" + updatedBalance);
            System.out.println();
            currentBalance = updatedBalance;
        }
    }
}
