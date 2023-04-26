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
    public AVL(){
        this.root = null;
    }
    public AVL(Node root){
        this.root = root;
    }
    class Node{
        int item;
        Node left, right;
        
        public Node(int key){
            item = key;
            left = null;
            right = null;
        }
        int height(){
            if(right == null && left == null){
                return 0;
            }else if(right == null){
                return 1 + left.height();
            }else if(left ==  null){
                return 1 + right.height();
            }else {
                return 1 + Math.max(right.height(), left.height());
            }
        }
        
        int balance(){
            if(right == null && left == null){
                return 0;
            }else if(right == null){
                return (1 + left.height());
            }else if(left ==  null){
                return (-1 - right.height());
            }else {
                return (left.height() - right.height());
            }
        }
    }
    
    void insert(int number){
        if(root == null){
            root = new Node(number);
            return;
        }
        System.out.println("root item is " + root.item);
        if(root.left == null && root.right == null){
            if(number < root.item){
                Node left = new Node(number);
                root.left = left;
                return;
            } else {
                Node right = new Node(number);
                root.right = right;
                return;
            }
        }
        if(root.left == null && root.height() == 1){
            if(number < root.item ){
                Node left = new Node(number);
                root.left = left;
                return;
            }else if(number < root.right.item) {
                Node left = new Node(root.item);
                root.left = left;
                root.item = number;
                return;
            } else {
                Node left = new Node(root.item);
                root.left = left;
                root.item = root.right.item;
                root.right.item = number;
                return;
            }
        }
        if(root.right == null && root.height() == 1){
            if(number > root.item ){
                Node right = new Node(number);
                root.right = right;
                return;
            }else if(number > root.left.item) {
                Node right = new Node(root.item);
                root.right = right;
                root.item = number;
                return;
            } else {
                Node right = new Node(root.item);
                root.right = right;
                root.item = root.left.item;
                root.left.item = number;
                return;
            }
        }
        if(root.balance() == 0){
            if(number > root.item){
                AVL a = new AVL(root.right);
                a.insert(number);
                return;
            }else {
                AVL a = new AVL(root.left);
                a.insert(number);
                return;
            }
        } else if(root.balance() == -1){
            if(number < root.item){
                AVL a = new AVL(root.left);
                a.insert(number);
                return;
            }else {
                AVL ar = new AVL(root.right);
                int min = ar.min();
                if(number < min){
                    AVL al = new AVL(root.left);
                    al.insert(root.item);
                    root.item = number;
                    return;
                }
                ar.delete(min);
                ar.insert(number);
                AVL al = new AVL(root.left);
                al.insert(root.item);
                root.item = min;
                return;
            }
            //the case for root.balance() == 1
        }else {
            if(number > root.item){
                AVL a = new AVL(root.right);
                a.insert(number);
                return;
            }else {
                AVL al = new AVL(root.left);
                int max = al.max();
                if(number > max){
                    AVL ar = new AVL(root.right);
                    ar.insert(root.item);
                    root.item = number;
                    return;
                }
                al.delete(max);
                al.insert(number);
                AVL ar = new AVL(root.right);
                ar.insert(root.item);
                root.item = max;
                return;
            }
        }
    }
    void delete(int number){
        
    }
    int max(){
        Node temp = root;
        while(temp.right != null){
            temp = temp.right;
        }
        return temp.item;
    }
    int min(){
        Node temp = root;
        while(temp.left != null){
            temp = temp.left;
        }
        return temp.item;
    }
    void preOrder(){
        if(root != null){
            System.out.print("item: " + root.item);  
            System.out.print(" balance: ");
            System.out.print(root.balance());
            System.out.print(" height: " + root.height());
            if(root.left != null){
                System.out.print(" left: " + root.left.item);
            }else {
                System.out.print(" left: " + null);
            }
            if(root.right != null){
                System.out.println(" right: " + root.right.item);
            }else {
                System.out.println(" right: " + null);
            }
            AVL aLeft = new AVL();
            aLeft.root = root.left;
            aLeft.preOrder();
            AVL aRight = new AVL();
            aRight.root = root.right;
            aRight.preOrder();
        }
    }
    public static void main(String[] args) {
        AVL a = new AVL();
        a.insert(8);
        a.preOrder();
        System.out.println("--------------------------------------------");
        System.out.println("New Insert: " + 11);
        a.insert(11);
        a.preOrder();
        System.out.println("--------------------------------------------");
        System.out.println("New Insert: " + 14);
        a.insert(14);
        a.preOrder();
        System.out.println("--------------------------------------------");
        System.out.println("New Insert: " + 20);
        a.insert(20);
        a.preOrder();
        System.out.println("--------------------------------------------");
        System.out.println("New Insert: " + 25);
        a.insert(25);
        a.preOrder();
        System.out.println("--------------------------------------------");
        System.out.println("New Insert: " + 10);
        a.insert(10);
        a.preOrder();
        System.out.println("--------------------------------------------");
        System.out.println("New Insert: " + 30);
        a.insert(30);
        a.preOrder();
        System.out.println("--------------------------------------------");
        System.out.println("New Insert: " + 27);
        a.insert(27);
        a.preOrder();
        System.out.println("--------------------------------------------");
        System.out.println("New Insert: " + 18);
        a.insert(18);
        a.preOrder();
        System.out.println("--------------------------------------------");
        System.out.println("New Insert: " + 4);
        a.insert(4);
        a.preOrder();
        System.out.println("--------------------------------------------");
        System.out.println("New Insert: " + 3);
        a.insert(3);
        a.preOrder();
        System.out.println("--------------------------------------------");
        System.out.println("New Insert: " + 2);
        a.insert(2);
        a.preOrder();
        System.out.println("--------------------------------------------");
        System.out.println("New Insert: " + 1);
        a.insert(1);
        a.preOrder();
        
    }
}
