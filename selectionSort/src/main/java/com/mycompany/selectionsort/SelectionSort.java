/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.selectionsort;

/**
 *
 * @author asadp
 */
public class SelectionSort {
    public static void swap(int x, int y){
        int temp = x;
        x = y;
        y = temp;
    }
    
    public static void selectionSort(int arr[], int n, int x){
        int min;
        int minIndex;
        for(int i = 0; i < x; i++){
            min = arr[i];
            minIndex = i;
            for(int j = i + 1; j < n; j++){
                if(arr[j] < min){
                    min = arr[j];
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }
    
    public static void main(String[] args) {
        int arr[] = {6, 5, 4, 3, 2, 1};
        int n = 6;
        int x = 6;
        selectionSort(arr, n, x);
        
    }
}
