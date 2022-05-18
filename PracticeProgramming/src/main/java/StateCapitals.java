
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author faridasadpour
 */
public class StateCapitals {
    public static void main(String[] args) {
        Map<String, String> stateCapitals = new HashMap<>();
        stateCapitals.put("Alabama", "Montgomery");
        stateCapitals.put("Alaska", "Juneau");
        stateCapitals.put("Arizona", "Phoenix");
        stateCapitals.put("Arkansas", "Little Rock");
        Set<String> states = stateCapitals.keySet();
        for(String state : states){
            System.out.println(state);
        }
        Collection<String> capitals = stateCapitals.values();
        for(String capital : capitals){
            System.out.println(capital);
        }
        for(String state : states){
            System.out.println(state + "-" + stateCapitals.get(state));
        }
    }
}
