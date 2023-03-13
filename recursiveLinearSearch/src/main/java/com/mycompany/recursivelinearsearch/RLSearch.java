/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.recursivelinearsearch;

/**
 *
 * @author asadp
 */
public class RLSearch {
    public int rLS(int x, int arr[], int n){
        if( n > arr.length - 1)
            return rLS(x, arr, n - 1);
        if(n == 0){
            if(arr[0] == x)
                return 0;
            return -1;
        }
        if (arr[n] == x)
            return n;
        else 
            return rLS(x, arr, n - 1);
    }
    
    public static void main(String args[]){
        RLSearch r = new RLSearch();
        int arr[] = {10,20,80,30,60,50,110,100,130,170};
        System.out.println("It is at index " + r.rLS(10, arr, 10));
    }
    
}
