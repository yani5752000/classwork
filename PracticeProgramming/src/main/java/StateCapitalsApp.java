
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
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
public class StateCapitalsApp {
    public static void main(String[] args) throws Exception{
        Map<String, Capital> stateCapitals = new HashMap<>();
        Scanner sc = new Scanner(new BufferedReader(new FileReader("MoreStateCapitals.txt")));
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            int stEnd = line.indexOf(':', 0);
            int capEnd = line.indexOf(':', stEnd + 2);
            int popEnd = line.indexOf(':', capEnd + 2);
            String state = line.substring(0, stEnd);
            String name = line.substring(stEnd + 2, capEnd);
            int population = Integer.parseInt(line.substring(capEnd + 2, popEnd));
            Double square_mileage = Double.parseDouble(line.substring(popEnd + 2));
            Capital capital = new Capital(name, population, square_mileage);
            stateCapitals.put(state, capital);
            
        }
        System.out.println("the number of state capitals loaded is " + stateCapitals.size());
            for(String st : stateCapitals.keySet()){
                Capital cap = stateCapitals.get(st);
                System.out.println("State: " + st + " -capital: " + cap.name + " -population: " + cap.population + " -square mileage: " + cap.square_mileage);
            }
            Scanner sc1 = new Scanner(System.in);
            int popLim;
            System.out.println("Enter a population limit: ");
            popLim = Integer.parseInt(sc1.nextLine());
            for(String st : stateCapitals.keySet()){
                Capital cap = stateCapitals.get(st);
                if(cap.population < popLim){
                    continue;
                }
                System.out.println("State: " + st + " -capital: " + cap.name);
            }
            double arLim;
            System.out.println("Enter an area limit: ");
            arLim = Integer.parseInt(sc1.nextLine());
            for(String st : stateCapitals.keySet()){
                Capital cap = stateCapitals.get(st);
                if(cap.square_mileage > arLim){
                    continue;
                }
                System.out.println("State: " + st + " -capital: " + cap.name);
            }
    }
}
