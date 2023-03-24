/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fsarray;

/**
 *
 * @author asadp
 */
public class FSArray {
    public static int fSA(int arr[], int k){
        int answer = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= k && arr[i] > answer){
                answer = arr[i];
            }
        }
        return answer;
    }
    
    public static void main(String[] args) {
        int arr[] ={1,2,8,10,10,12,19};
        int x = 0;
        System.out.println("it is " + fSA(arr, x));
    }
}
