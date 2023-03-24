/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mms;

/**
 *
 * @author asadp
 */
public class MMs {
    void merge(int A[ ] , int start, int mid, int end) {
        //stores the starting position of both parts in temporary variables.
       int p = start ,q = mid+1;

       int Arr[end-start+1] = {}; int k=0;

       for(int i = start ;i <= end ;i++) {
           if(p > mid)      //checks if first part comes to an end or not .
              Arr[ k++ ] = A[ q++] ;

           else if ( q > end)   //checks if second part comes to an end or not
                Arr[ k++ ] = A[ p++ ];

           else if( A[ p ] < A[ q ])     //checks which part has smaller element.
               Arr[ k++ ] = A[ p++ ];

           else
               Arr[ k++ ] = A[ q++];
        }
         for (int p=0 ; p< k ;p ++) {
          /* Now the real array has elements in sorted manner including both 
               parts.*/
            A[ start++ ] = Arr[ p ] ;                          
         }
       }
    
    public static int mMs(int arr[]){
        
    }
}
