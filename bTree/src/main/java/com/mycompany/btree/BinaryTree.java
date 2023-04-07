/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.btree;

/**
 *
 * @author asadp
 */
class BinaryTree {
  // Root of Binary Tree
  Node root;

  BinaryTree() {
  root = null;
  }

  void postorder(Node node) {
  if (node == null)
    return;

  // Traverse left
  postorder(node.left);
  // Traverse right
  postorder(node.right);
  // Traverse root
  System.out.print(node.item + "->");
  }

  void inorder(Node node) {
  if (node == null)
    return;

  // Traverse left
  inorder(node.left);
  // Traverse root
  System.out.print(node.item + "->");
  // Traverse right
  inorder(node.right);
  }

  void preorder(Node node) {
  if (node == null)
    return;

  // Traverse root
  System.out.print(node.item + "->");
  // Traverse left
  preorder(node.left);
  // Traverse right
  preorder(node.right);
  }
  
  void bInsert(Node node, int number){
      if(node == root && node == null){
          System.out.println("item is nulllll ");
          root = new Node(number);
          System.out.println("insert");
          System.out.println("now item is " + root.item);
          return;
      }
      else if(number == node.item){
          System.out.println("The number is already in the tree.");
          System.out.println("item is " + node.item);
          return;
      }
      else if(number > node.item){
          if(node.right == null){
              node.right = new Node(number);
              return;
          }
          System.out.println("item is " + node.item);
          bInsert(node.right, number);
          return;
      }
      else if(number < root.item){
          if(node.left == null){
              node.left = new Node(number);
              return;
          }
          System.out.println("item is " + node.item);
          bInsert(node.left, number);
          return;
      }
  }
  
  void bDelete(int number){
      Node node = bSearch(number);
      if (node == null){
          System.out.println("No such number there to delete");
          return;
      }
      if(node.right == null && node.left == null){
          if(node == root){
              root = null;
              return;
          }
          Node parent = bSearchParent(number);
          if(node == parent.left){
              parent.left = null;
              return;
          }
          if(node == parent.right){
              parent.right = null;
              return;
          }
      }
      if(node.right == null && node.left != null){
          if(node == root){
              root = node.left;
              return;
          }
          Node parent = bSearchParent(number);
          if(node == parent.left){
              parent.left = node.left;
              return;
          }
          if(node == parent.right){
              parent.right = node.left;
              return;
          }
      }
      if(node.right != null && node.left == null){
          if(node == root){
              root = node.right;
              return;
          }
          Node parent = bSearchParent(number);
          if(node == parent.left){
              parent.left = node.right;
              return;
          }
          if(node == parent.right){
              parent.right = node.right;
              return;
          }
      }
      if(node == root){
          Node node1 = new Node(root.right.item);
          node1.left = root.left;
          BinaryTree b = new BinaryTree();
          b.root = root.right;
          b.bDelete(root.right.item);
          node1.right = b.root;
          root = node1;
          return;
      }
      else {
          Node node1 = new Node(node.right.item);
          Node parent = this.bSearchParent(node.item);
          if(node == parent.left){
              parent.left = node1;
          }
          else {
              parent.right = node1;
          }
          node1.left = node.left;
          BinaryTree b = new BinaryTree();
          b.root = node.right;
          b.bDelete(b.root.item);
          node1.right = b.root;
          return;
      }
  }
  
  Node bSearch(int number){
      if(root == null){
          return null;
      }
      if(number == root.item){
          return this.root;
      }
      if(number > root.item){
          BinaryTree b = new BinaryTree();
          b.root = this.root.right;
          return b.bSearch(number);
      }
      else{
          BinaryTree b = new BinaryTree();
          b.root = this.root.left;
          return b.bSearch(number);
      }
  }
  Node bSearchParent(int number){
      if(root == null){
          return null;
      }
      if(root.item == number){
          return null;
      }
      if(number > root.item && root.right == null){
          return null;
      }
      if(number < root.item && root.left == null){
          return null;
      }
      if(root.hasInChild(number)) {
          return root;
      }
      
      if(number > root.item){
          BinaryTree b = new BinaryTree();
          b.root = this.root.right;
          return b.bSearchParent(number);
      }
      else{
          BinaryTree b = new BinaryTree();
          b.root = this.root.left;
          return b.bSearchParent(number);
      }
  }

  public static void main(String[] args) {
  BinaryTree tree = new BinaryTree();
  tree.root = new Node(13);
  tree.root.left = new Node(8);
  tree.root.right = new Node(15);
  tree.root.left.left = new Node(5);
  tree.root.left.right = new Node(9);

  System.out.println("Inorder traversal");
  tree.inorder(tree.root);

  System.out.println("\nPreorder traversal ");
  tree.preorder(tree.root);

  System.out.println("\nPostorder traversal");
  tree.postorder(tree.root);
  
      System.out.println("\nsearch for 9");
      System.out.println(tree.bSearch(9).item);
      
      System.out.println("\nsearch for 10");
      System.out.println(tree.bSearch(10));
      
      System.out.println("\ninsert for 10");
      tree.bInsert(tree.root,10);
      
      System.out.println("Inorder traversal");
      tree.inorder(tree.root);

      System.out.println("\nPreorder traversal ");
      tree.preorder(tree.root);
  
      System.out.println("\nPostorder traversal");
      tree.postorder(tree.root);
      
      System.out.println("\nsearch for 9");
      System.out.println(tree.bSearch(9).item);
      
      System.out.println("\nsearch for 10");
      System.out.println(tree.bSearch(10).item);
      
      System.out.println("\nsearch for 100");
      System.out.println(tree.bSearch(100));
      
      System.out.println("search for parent of 21");
      
      System.out.println(tree.bSearchParent(2));
      
      tree.bDelete(15);
      System.out.println("preorder traversal");
      tree.preorder(tree.root);
      
  }
}
