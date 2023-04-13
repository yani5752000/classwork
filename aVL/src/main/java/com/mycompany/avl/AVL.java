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
    }
    
    void insert(int number){
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
