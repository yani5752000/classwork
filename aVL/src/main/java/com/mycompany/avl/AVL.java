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
            }else if(number < root.left.item) {
                Node left = new Node(root.item);
                left.balance = 0;
                root.left = left;
                root.item = number;
                root.balance++;
            }
        }
        if(number < root.item){
            if(root.height <= 0){
                AVL a = new AVL();
                a.root = root.left;
                a.insert(number);
            }
            if(root.height > 0){
                AVL a = new AVL();
                a.root = root.right;
                a.insert(number);
            }
        }
    }
}
