/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bplus;

import java.util.ArrayList;

/**
 *
 * @author asadp
 */
public class BPlus {
    Node root;
    
    class Node{
        ArrayList<Integer> keys = new ArrayList<Integer>();
        ArrayList<Node> children = new ArrayList<Node>();
        boolean isLeaf;
        int findChildIndex(int number){
            if(number < keys.get(0)){
                return 0;
            }
            if(number >= keys.get(keys.size() - 1)){
                return keys.size();
            }
            int j = 0;
            while(number >= keys.get(j)){
                j++;
            }
            return j;
        }
    }
    
    Node search(int number){
        Node temp = root;
        while(!temp.isLeaf){
            temp = temp.children.get(temp.findChildIndex(number));
        }
        return temp;
    }
}
