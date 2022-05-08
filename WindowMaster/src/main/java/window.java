
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
public class window {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter the height: ");
        String heightString  = myScanner.nextLine();
        System.out.println("Please enter the width: ");
        String widthString  = myScanner.nextLine();
        float height = Float.parseFloat(heightString);
        float width = Float.parseFloat(widthString);
        float glassCost = height * width * 3.50f;
        float trimCost = 2 * (height + width) * 2.25f;
        System.out.println("cost of glass is " + glassCost);
        System.out.println("cost of trim is " + trimCost);
        System.out.println(" total cost is " + (trimCost + glassCost));
        
        
        
    }
}
