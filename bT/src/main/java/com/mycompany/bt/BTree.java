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
public class BTree {
    //int order;
    Node root;
    public BTree(Node root){
        this.root = root;
    }
    
    Node search(int number){
        if(root == null){
            return null;
        }
        System.out.println("searching the B tree for " + number);
        System.out.println("seraching in the Keys of node for " + number);
        if(root.searchKeys(0, root.keys.size() - 1, number) == true){
            System.out.println("found the node");
            System.out.println("root.leaf = " + root.leaf);
            System.out.println("the resulted node is the node with keys ");
            for(Integer key : root.keys){
                System.out.print(key + " ");
            }
            return root;
        }
        
        if(root.children.size() > 0){
            System.out.println("searching the leaves");
            for(Node node : root.children){
                BTree bt = new BTree(node);
                Node node1 = bt.search(number);
                if(node != null){
                    return node1;
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Node node = new Node();
        node.leaf = false;
        node.keys.add(3);
        node.keys.add(5);
        node.keys.add(8);
        Node node1 = new Node();
        node1.leaf = true;
        node1 .keys = new ArrayList<Integer>();
        node1.keys.add(1);
        node1.keys.add(4);
        node1.keys.add(7);
        node.children.add(node1);
        BTree bt = new BTree(node);
        System.out.println("----------------------------------------");
        Node answer = bt.search(5);
        if(answer == null){
            System.out.println("answer is null.");
        }else {
            System.out.println("answer is the node with keys ");
            for(Integer key : answer.keys){
                System.out.print(key + " ");
            }
            System.out.println("");
        }
        System.out.println("----------------------------------------");
        Node answer1 = bt.search(7);
        if(answer1 == null){
            System.out.println("answer is null.");
        }else {
            System.out.println("answer is the node with keys ");
            for(Integer key : answer1.keys){
                System.out.print(key + " ");
            }
            System.out.println("");
        }
        System.out.println("----------------------------------------");
        Node answer2 = bt.search(50);
        if(answer2 == null){
            System.out.println("answer is null.");
        }else {
            System.out.println("answer is the node with keys ");
            for(Integer key : answer2.keys){
                System.out.print(key + " ");
            }
            System.out.println("");
        }
    }
}
