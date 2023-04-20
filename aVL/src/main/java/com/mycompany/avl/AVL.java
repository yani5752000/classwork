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
        int height;
        Node left, right;
        
        public Node(int key){
            item = key;
            height = 0;
            left = null;
            right = null;
        }
        
        int balance(){
            if(height == 0){
                return 0;
            }
            return left.height - right.height;
        }
    }
    
    void insert(int number){
        if(root == null){
            root = new Node(number);
            return;
        }
        if(root.left == null && root.right == null){
            if(number < root.item){
                Node left = new Node(number);
                left.balance = 0;
                root.left = left;
                root.balance++;
                root.height++;
                return;
            } else {
                Node right = new Node(number);
                root.right = right;
                root.balance = -1;
                root.height++;
                return;
            }
        }
        if(root.left == null && root.right.right == null && root.right.left == null){
            if(number < root.item ){
                Node left = new Node(number);
                root.left = left;
                root.balance++;
                return;
            }else if(number < root.right.item) {
                Node left = new Node(root.item);
                root.left = left;
                root.item = number;
                root.balance++;
                return;
            } else {
                Node left = new Node(root.item);
                root.left = left;
                root.item = root.right.item;
                root.balance++;
                root.right.item = number;
                return;
            }
        }
        if(root.right == null && root.left.left == null && root.left.right == null){
            if(number > root.item ){
                Node right = new Node(number);
                root.right = right;
                root.balance--;
                return;
            }else if(number > root.left.item) {
                Node right = new Node(root.item);
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
        if(root.balance == 0 && number > root.item){
            AVL a = new AVL();
            a.root = root.right;
            a.insert(number);
            
        }
    }
}
