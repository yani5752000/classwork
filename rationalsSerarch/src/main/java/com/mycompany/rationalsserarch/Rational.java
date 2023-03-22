/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rationalsserarch;

/**
 *
 * @author asadp
 */
public class Rational {
    public int a, b;
    //the constructor
    public Rational(int a, int b){
        this.a = a;
        this.b = b;
    }
    //method for defining equlity of two rationals
    static boolean eq(Rational x, Rational y){
        return x.a * y.b == x.b * y.a;
    }
    
    static boolean lessThan(Rational x, Rational y){
        return x.a * y.b < x.b * y.a;
    }
    //binary serach in an array of rational numbers
    static int binarySearch(Rational arr[],int l,int r,Rational x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;

        if (eq(arr[mid], x))
            return mid;

        if (lessThan(x, arr[mid]))
            return binarySearch(arr,l,mid - 1,x);

        // Else the element can only be present in right subarray
            return binarySearch(arr,mid + 1,r,x);
        }

        // We reach here when element is not present in array
        return -1;
    }
    
    public static void main(String[] args) {
        Rational arr[] = {new Rational(1, 5),new Rational(2, 3), new Rational(3, 2), new Rational( 13, 2)};
        Rational x = new Rational(1, 2);
        System.out.println("Found at " + binarySearch(arr,0,3,x));
    }
}
