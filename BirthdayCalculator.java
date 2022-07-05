
package JavaDateTime;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class BirthdayCalculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate birthday;
        LocalDate nextDay;
        boolean thisYear = true;
        LocalDate today = LocalDate.now();
        String todayDate = today.format(format);
        
        System.out.println("Welcome to the Magical BirthDAY Calculator!");
        System.out.println("What's your birthday?");
        input = in.nextLine();
        
        birthday = LocalDate.parse(input, format);
        System.out.println("That means you were born on a " + birthday.getDayOfWeek() + "!");
        
        nextDay = birthday.withYear(today.getYear());
        if(nextDay.isBefore(today)){
            nextDay = nextDay.plusYears(1);
            thisYear = false;
        }
        Period nextBirthday = today.until(nextDay);
        Period nextAge = birthday.until(nextDay);
        if(thisYear){
            System.out.println("This year it falls on a " + nextDay.getDayOfWeek());
        }else {
            System.out.println("Next year it falls on a " + nextDay.getDayOfWeek());
        }
        
        System.out.println("And since today is " + todayDate 
                + ", there's only " + nextBirthday.getMonths()
                + " more months until the next one!");
        
        System.out.println("Bet yer excited to be turning " 
                + nextAge.getYears() + "!");
    }
}
