/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.quicksort;
import java.lang.Math;

/**
 *
 * @author asadp
 */
public class QuickSort {
    public static int partition ( int A[],int start ,int end) {
        int i = start + 1;
        int piv = A[start] ;            //make the first element as pivot element.
        for(int j =start + 1; j <= end ; j++ )  {
        /*rearrange the array by putting elements which are less than pivot
           on one side and which are greater that on other. */

              if ( A[ j ] < piv) {
                     int temp = A[i];
                     A[i] = A[j];
                     A[j] = temp;
                i += 1;
            }
       }
       int temp = A[start];
       A[start] = A[i - 1];
       A[i - 1] = temp;  //put the pivot element in its proper place.
       return i-1;                      //return the position of the pivot
    }
    
    public static int rand_partition ( int A[ ] , int start , int end ) {
        //chooses position of pivot randomly by using rand() function .
         int random = start + (int) (Math.random() * (end - start +1));

         int temp = A[random];
         A[random] = A[start];
         A[start] = temp;
         return partition(A,start ,end) ;       //call the above partition function
    }
    
    public static void quick_sort ( int A[ ] ,int start , int end ) {
        if( start < end ) {
             //stores the position of pivot element
              int piv_pos = rand_partition (A,start , end ) ;     
              quick_sort (A,start , piv_pos -1);    //sorts the left side of pivot.
              quick_sort ( A,piv_pos +1 , end) ; //sorts the right side of pivot.
        }
    }
    
    public static void main(String[] args) {
       int Arr[] ={4, 3, 1, 5, 2};
       quick_sort(Arr, 0, 4);
        System.out.println("It is");
        for(int i = 0; i < Arr.length; i++){
            System.out.print(Arr[i] + " ");
        }
    }
}
