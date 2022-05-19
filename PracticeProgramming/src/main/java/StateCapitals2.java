
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
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
public class StateCapitals2 {
    public static void main(String[] args) throws Exception {
        Map<String, String> stateCapitals = new HashMap<>();
        Scanner sc = new Scanner(new BufferedReader(new FileReader("StateCapitals.txt")));
        while(sc.hasNextLine()){
            String currentLine = sc.nextLine();
            int index = currentLine.indexOf(':');
            String state = currentLine.substring(0, index);
            String capital = currentLine.substring(index + 2);
            stateCapitals.put(state, capital);
        }
        System.out.println("The number pf state/capital pairs is: " + stateCapitals.size());
        System.out.println("thes are the states: ");
        String[] states = new String[stateCapitals.size()];
        int j = 0;
        for(String state : stateCapitals.keySet()){
            System.out.println(state);
            states[j] = state;
            j++;
        }
        Random rnd = new Random();
        Scanner sc1 =new Scanner(System.in);
        int ind = rnd.nextInt(stateCapitals.size());
        String answer;
        System.out.println("What is the capital of " + states[ind] + "?");
        answer = sc1.nextLine();
        if(answer.equals(stateCapitals.get(states[ind]))){
            System.out.println("Correct");
        } else {
            System.out.println("Wrong");
        }
        
    }
}
