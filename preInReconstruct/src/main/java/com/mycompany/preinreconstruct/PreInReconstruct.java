/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.preinreconstruct;

import java. util. ArrayList;

/**
 *
 * @author asadp
 */
public class PreInReconstruct {
    class Node {
        int item;
        Node left,right;

        public Node(int key) {
        item = key;
        left = right = null;
        }
    }
    ArrayList<Node> nodes = new ArrayList<Node>();
    void preInReconstruct(int preOrder[], int inOrder[]){
        Node root = new Node(preOrder[0]);
        int index = 0;
        for(int i = 0; i < inOrder.length; i++){
            if(inOrder[i] == root.item){
                index = i;
                break;
            }
        }
        int inOrderLeft[] = new int[index];
        int inOrderRight[] = new int[inOrder.length - index -1];
        for(int i = 0; i < index; i++){
            inOrderLeft[i] = inOrder[i];
         }
        for(int i = 0; i < inOrder.length - index -1; i++){
            inOrderRight[i] = inOrder[i + index];
         }
        int preOrderLeft[] = new int[index];
        int preOrderRight[] = new int[inOrder.length - index -1];
        for(int i = 0; i < index; i++){
            preOrderLeft[i] = preOrder[i + 1];
         }
        for(int i = 0; i < inOrder.length - index -1; i++){
            preOrderRight[i] = inOrder[i + index + 1];
         }
        
        root.left = preOrderLeft[0];
        
    }
}
