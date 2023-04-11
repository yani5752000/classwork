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
    static ArrayList<Node> treeNodes = new ArrayList<Node>();
    class Node {
        int item;
        Node left,right;

        public Node(int key) {
        item = key;
        left = right = null;
        }
    }
    Node treeNodeForItem(int key){
        for(Node node : treeNodes){
            if(node.item == key){
                return node;
            }
        }
        Node node = new Node(key);
        treeNodes.add(node);
        return node;
    }
    
    void preInReconstruct(int preOrder[], int inOrder[]){
        if(preOrder.length == 0 || inOrder.length == 0){
            return;
        }
        Node root = treeNodeForItem(preOrder[0]);
        int index = 0;
        for(int i = 0; i < inOrder.length; i++){
            if(inOrder[i] == root.item){
                index = i;
                break;
            }
        }
        System.out.println("index: " + index);
        int inOrderLeft[] = new int[index];
        int inOrderRight[] = new int[inOrder.length - index -1];
        for(int i = 0; i < index; i++){
            inOrderLeft[i] = inOrder[i];
            System.out.print(inOrderLeft[i] + " ");
         }
        System.out.println("");
        for(int i = 0; i < inOrder.length - index -1; i++){
            inOrderRight[i] = inOrder[i + index + 1];
            System.out.print(inOrderRight[i] + " ");
         }
        System.out.println("");
        int preOrderLeft[] = new int[index];
        int preOrderRight[] = new int[inOrder.length - index -1];
        for(int i = 0; i < index; i++){
            preOrderLeft[i] = preOrder[i + 1];
            System.out.print(preOrderLeft[i] + " ");
         }
        System.out.println("");
        for(int i = 0; i < inOrder.length - index -1; i++){
            preOrderRight[i] = preOrder[i + index + 1];
            System.out.print(preOrderRight[i] + " ");
         }
        System.out.println("");
        if(preOrderLeft.length > 0){
            Node left = treeNodeForItem(preOrderLeft[0]);
            root.left = left;
            System.out.println("left: " + left.item);
        }
        if(preOrderRight.length > 0){
            Node right = treeNodeForItem(preOrderRight[0]);
            root.right = right;
            System.out.println("right: " + right.item);
        }
        
        preInReconstruct(preOrderLeft, inOrderLeft);
        preInReconstruct(preOrderRight, inOrderRight);
    }
    void printTreeNodes(){
        for(Node node: treeNodes){
            System.out.println("Node item: " + node.item 
            + " left: " + (node.left == null? "null": node.left.item)
            + " right: " + (node.right == null? "null": node.right.item));
        }
    }
    public static void main(String[] args) {
        PreInReconstruct pIR = new PreInReconstruct();
        int preOrder[] = {-1};
        int inOrder[] = {-1};
        pIR.preInReconstruct(preOrder, inOrder);
        pIR.printTreeNodes();
    }
}
