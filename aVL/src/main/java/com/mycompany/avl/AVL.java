/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.avl;
import java. util. ArrayList;

/**
 *
 * @author asadp
 */
public class AVL {
    Node root;
    class Node{
        int item;
        int balance = balance();
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
        if(root.balance == 0){
            if(number > root.item){
                AVL a = new AVL();
                a.root = root.right;
                a.insert(number);
                return;
            }else {
                AVL a = new AVL();
                a.root = root.left;
                a.insert(number);
            }
        } else if(root.balance == -1){
            if(number < root.item){
                AVL a = new AVL();
                a.root = root.left;
                a.insert(number);
            }else {
                ArrayList<Node> nodes = new ArrayList();
                nodes.add(root);
                Node end = root.right;
                nodes.add(end);
                while(end != null){
                    if(number < end.item){
                        end = end.left;
                    }else{
                        end = end.right;
                    }
                    nodes.add(end);
                }
                AVL al = new AVL();
                al.root = root.left;
                al.insert(root.item);
                Node first = root;
                for(Node node : nodes){
                    if(node == root){
                        continue;
                    }
                    if(node == null){
                        first.item = number;
                    }else{
                        first.item = node.item;
                    }
                    first = node;
                }
            }
            //the case for root.balance == 1
        }else {
            if(number > root.item){
                AVL a = new AVL();
                a.root = root.right;
                a.insert(number);
            }else {
                ArrayList<Node> nodes = new ArrayList();
                nodes.add(root);
                Node end = root.left;
                nodes.add(end);
                while(end != null){
                    if(number < end.item){
                        end = end.left;
                    }else{
                        end = end.right;
                    }
                    nodes.add(end);
                }
                AVL al = new AVL();
                al.root = root.right;
                al.insert(root.item);
                Node first = root;
                for(Node node : nodes){
                    if(node == root){
                        continue;
                    }
                    if(node == null){
                        first.item = number;
                    }else{
                        first.item = node.item;
                    }
                    first = node;
                }
            }
        }
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
