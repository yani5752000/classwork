/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaDateTime;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

/**
 *
 * @author salajrawi
 */
public class Test {
     public static void main(String[] args) {
     
         
         LocalDate ld = LocalDate.now();
            System.out.println(ld);
        //__________________________________
        
         ld = LocalDate.parse("2015-01-01");
          System.out.println(ld);
        //__________________________________
        
        //ld = LocalDate.parse("02/07/2010", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
          //System.out.println(ld);
        //__________________________________
          LocalDate ld2 = LocalDate.now();
            System.out.println(ld2);
        LocalDate past = ld2.minusDays(10);
          System.out.println(past);
        //__________________________________
        LocalDate ld3 = LocalDate.now();
            System.out.println(ld3);
        Period diff = ld3.until(past);
          System.out.println(diff);
        //__________________________________
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate ld1 = LocalDate.parse("02/07/2010", formatter);
        String formatted = ld1.format(formatter);
          System.out.println(formatted);
        //__________________________________
        
        formatted = ld.format(DateTimeFormatter.ofPattern("MM=dd=yyyy+=+=+="));
         System.out.println(formatted);
        //__________________________________
         LocalDate ld4 = LocalDate.now();
        formatted = ld4.format(
        DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
          System.out.println(formatted);
        //__________________________________
        Date legacyDate = new Date();
          System.out.println(legacyDate);
        
        ZonedDateTime zdt = ZonedDateTime.ofInstant(
        legacyDate.toInstant(), ZoneId.systemDefault());
        
       System.out.println(zdt);
         
        ld = zdt.toLocalDate();
        System.out.println(ld);
        //____________________________
        
     }
    
}
