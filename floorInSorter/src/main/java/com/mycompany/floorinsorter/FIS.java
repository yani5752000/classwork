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

            if (arr[mid] == x)
                return mid;

            if (arr[mid] > x)
            return fIS(x, arr, l, mid - 1);

            // Else the element can only be present in right subarray
            return fIS(x, arr, mid + 1, r);
        }

// We reach here when element is not present in array
return -1;
    }
}
