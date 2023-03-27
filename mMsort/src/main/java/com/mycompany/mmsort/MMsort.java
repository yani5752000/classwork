/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mmsort;

/**
 *
 * @author asadp
 */
public class MMsort {
    public static int mergeSort(int[] a, int n) {
        int t = 0;
        if (n < 2) {
            return 0;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        t += mergeSort(l, mid);
        t += mergeSort(r, n - mid);

        t += merge(a, l, r, mid, n - mid);
        return t;
    }
    public static int merge(int[] a, int[] l, int[] r, int left, int right) {
        int t = 0;
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
                t = t + left - i;
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
        return t;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 3, 4, 5 };
        int length = 5;
        int t = mergeSort(arr, length);
        
        System.out.println("it is " + t);
//        for(int i = 0; i < length; i++){
//            System.out.print(arr[i] + " ");
//        }
    }
}
