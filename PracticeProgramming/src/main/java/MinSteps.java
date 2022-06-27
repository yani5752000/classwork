
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
public class MinSteps {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        //int[] arr = {1, 3, 9};
        System.out.println("min jump is: " + minJumps(arr));
    }
    
    static int minJumps(int[] arr){
        // your code here
        ArrayList<ArrayList<Integer>> cases = possibilities(arr);
        int min = arr.length;
        for(ArrayList<Integer> a : cases){
            if(a.size() < min){
                min = a.size();
            }
        }
        
        return (min - 1);
    }
    public static ArrayList<ArrayList<Integer>> possibilities(int[] arr){
        int n = arr.length;
        if(n == 1){
            ArrayList<Integer> arr1 = new ArrayList<Integer>();
                arr1.add(arr[0]);
                ArrayList<ArrayList<Integer>> output = new ArrayList<>();
                output.add(arr1);
                return output;
        }
        if(n == 2){
            if(arr[0] == 0){
                ArrayList<ArrayList<Integer>> output = new ArrayList<>();
                return output;
            } else {
                System.out.println("first: " + arr[0]);
                System.out.println("second: " + arr[1]);
                ArrayList<Integer> arr1 = new ArrayList<Integer>();
                arr1.add(0);
                arr1.add(1);
                ArrayList<ArrayList<Integer>> output = new ArrayList<>();
                output.add(arr1);
                return output;
            } 
        } 
        if(n > 2){
            ArrayList<ArrayList<Integer>> output = new ArrayList<>();
            ArrayList<Integer> indexes = new ArrayList<>();
            for(int j = 0; j < arr.length - 1; j++){
                if(n - 1 - j <= arr[j]){
                    indexes.add(j);
                }
            }
            for(Integer j: indexes){
                int[] arr2 = new int[j + 1];
                for(int i = 0; i <= j; i++){
                    arr2[i] = arr[i];
                }
                
                ArrayList<ArrayList<Integer>> current = possibilities(arr2);
                for(ArrayList<Integer> cur : current){
                    cur.add(n - 1);
                }
                output.addAll(current);
            }
            
            return output;
            
        }
        return null;
    }
}
