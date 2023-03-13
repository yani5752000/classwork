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
    public int fIS(int x,int arr[], int r, int l){
        if (r >= l) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == x)
                return mid;

            if (arr[mid] > x)
                return binarySearch(arr,l,mid - 1,x);

            // Else the element can only be present in right subarray
            return binarySearch(arr,mid + 1,r,x);
        }

// We reach here when element is not present in array
return -1;
    }
}
