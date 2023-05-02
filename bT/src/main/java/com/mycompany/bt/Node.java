/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bt;

import java.util.ArrayList;

/**
 *
 * @author asadp
 */
public class Node {
    boolean leaf;
    ArrayList<Integer> keys;
    ArrayList<Node> children;
    boolean searchKeys(int l, int r, int number){
        if(r > l){
            int mid = 1 + (r - l) / 2;
            if(keys.get(mid) == number){
                System.out.println("found " + number);
                return true;
            }else if(keys.get(mid) < number){
                return searchKeys(mid + 1, r, number);
            }else {
                return searchKeys(l, mid - 1, number);
            }
        }

        return false;
    }
}
