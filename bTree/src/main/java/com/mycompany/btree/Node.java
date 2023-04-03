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
class Node {
  int item;
  Node left,right;

  public Node(int key) {
  item = key;
  left = right = null;
  }
}
