/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.avl;

/**
 *
 * @author asadp
 */
public class AVL {
    Node root;
    class Node{
        int item;
        int balance;
        Node left, right;
        
        public Node(int key){
            item = key;
            balance = 0;
            left = null;
            right = null;
        }
    }
    
    void insert(int number){
        if(root == null){
            root = new Node(number);
            root.balance = 0;
            return;
        }
        if(root.left == null && root.right == null){
            if(number < root.item){
                Node left = new Node(number);
                left.balance = 0;
                root.left = left;
                root.balance = 1;
                return;
            } else {
                Node right = new Node(number);
                right.balance = 0;
                root.right = right;
                root.balance = -1;
                return;
            }
        }
        if(root.left == null){
            if(number < root.item ){
                Node left = new Node(number);
                left.balance = 0;
                root.left = left;
                root.balance++;
                return;
            }else if(number < root.right.item) {
                Node left = new Node(root.item);
                left.balance = 0;
                root.left = left;
                root.item = number;
                root.balance++;
                return;
            } else {
                Node left = new Node(root.item);
                left.balance = 0;
                root.left = left;
                root.item = root.right.item;
                root.balance++;
                root.right.item = number;
                return;
            }
        }
        if(root.right == null){
            if(number > root.item ){
                Node right = new Node(number);
                right.balance = 0;
                root.right = right;
                root.balance--;
                return;
            }else if(number > root.left.item) {
                Node right = new Node(root.item);
                right.balance = 0;
                root.right = right;
                root.item = number;
                root.balance--;
                return;
            } else {
                Node right = new Node(root.item);
                right.balance = 0;
                root.right = right;
                root.item = root.left.item;
                root.balance--;
                root.left.item = number;
                return;
            }
        }
    }
}
