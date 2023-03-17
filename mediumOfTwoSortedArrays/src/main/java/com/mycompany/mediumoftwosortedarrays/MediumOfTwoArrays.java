/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mediumoftwosortedarrays;

/**
 *
 * @author asadp
 */
public class MediumOfTwoArrays {
    static int mediumOfTwoArrays(int arr1[], int l1, int r1, int arr2[], int l2, int r2){
        if (r1 >= l1 && r2 >= l2) {
            int mid1 = l1 + (r1 - l1) / 2;
            int mid2 = l2 + (r2 - l2) / 2;

            if (arr1[mid1] > arr2[mid2])
                return mid;

            if (arr[mid] > x)
                return binarySearch(arr,l,mid - 1,x);

        // Else the element can only be present in right subarray
            return binarySearch(arr,mid + 1,r,x);
        }
        
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
