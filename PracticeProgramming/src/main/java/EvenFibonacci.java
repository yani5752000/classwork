
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author faridasadpour
 */
public class EvenFibonacci {
    public static void main(String[] args) {
        ArrayList<Integer> evenFibs = new ArrayList<>();
        evenFibs.add(0, 1);
        evenFibs.add(1, 2);
        int j = 2;
        int val = evenFibs.get(j - 1) + evenFibs.get(j - 2);
        while(val <= 4000000){
            evenFibs.add(j, val);
            j++;
            val = evenFibs.get(j - 1) + evenFibs.get(j - 2);
        }
        
        int sum = 0;
        for(Integer n: evenFibs){
            //System.out.println("fib " + n);
            if(n % 2 == 0){
                sum += n;
            }
        }
        
        System.out.println("Sum It is: " + sum);
    }
    
    
}
