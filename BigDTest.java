/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BigDecimalBusinessRules;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author salajrawi
 */
public class BigDTest {
     public static void main(String[] args) {
     
     BigDecimal a = new BigDecimal(42.35);
     //BigDecimal b = a.setScale(1); //ERROR
     System.out.println(a);
     
     BigDecimal b1 = a.setScale(1, RoundingMode.HALF_UP);
    System.out.println(b1.toString()); // 42.4
     
      BigDecimal a1 = new BigDecimal(42.34);
    BigDecimal b = a1.setScale(1, RoundingMode.HALF_DOWN);
    System.out.println(b.toString()); // 42.3
     
    
    BigDecimal op1 = new BigDecimal("10");
    BigDecimal op2 = new BigDecimal("6");
    System.out.println(op1);
    System.out.println(op2);
    
    
   BigDecimal c = op1.divide(op2, RoundingMode.HALF_UP); // 2
    System.out.println(c.toString());

  c = op1.divide(op2, 4, RoundingMode.HALF_UP); // 1.67
    System.out.println(c.toString());

  c = op1.divide(op2, 2, RoundingMode.DOWN); // 1.66
    System.out.println(c.toString());

     
     BigDecimal c1 = op1.divide(op2, RoundingMode.HALF_UP); // 2.000000000
    System.out.println(c1);
    
    
    BigDecimal c2 = c1.setScale(2, RoundingMode.DOWN);//2.00
    System.out.println(c2.toString());

  
     
     }
     
}
