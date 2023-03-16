/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.floorinsorter;

/**
 *
 * @author asadp
 */
public class FIS {
    public int fIS(int x,int arr[], int l, int r){
        if(x < arr[l])
            return -1;
        if (r >= l) {
            int mid = l + (r - l) / 2;
            System.out.println("mid " + mid);

            if (arr[mid] == x)
                return arr[mid];
            if (l == r && arr[l] < x)
                return arr[l];
            if (l == r - 1 && arr[l] < x && arr[r] > x)
                return arr[l];
            if (l == r - 1 && arr[l] < x && arr[r] < x)
                return arr[r];
            if (arr[mid] > x)
            return fIS(x, arr, l, mid);

            // Else the element can only be present in right subarray
            return fIS(x, arr, mid, r);
        }

        // We reach here when element is not present in array
        return -1;
    }
    
    public static void main(String args[]){
        FIS f = new FIS();
        int arr[] = {1,2,3,5,6,8,9,10};
        int x = 7;
        System.out.println("it is " + f.fIS(x, arr, 0, 7));
    }
}
