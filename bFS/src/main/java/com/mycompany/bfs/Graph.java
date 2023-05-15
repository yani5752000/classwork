/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bfs;

/**
 *
 * @author asadp
 */
import java.util.*;

public class Graph {
  private int V;
  private LinkedList<Integer> adj[];

  Graph(int v) {
    V = v;
    //a linked list of linked lists
    adj = new LinkedList[v];
    for (int i = 0; i < v; ++i)
      adj[i] = new LinkedList();
  }

  // Add edges to the graph
  void addEdge(int v, int w) {
      //we add in both ditrections
    if(!adj[v].contains(w)){
        adj[v].add(w);
    }
    if(!adj[w].contains(v)){
        adj[w].add(v);
    }
  }
  //breadth-first search
  void BFS(int s) {
    //"list" of visiteds and non-visiteds
    boolean visited [] = new boolean[V];

    LinkedList<Integer> queue = new LinkedList ();

    visited[s] = true;
    queue.add(s);

    while (queue.size() != 0) {
      s = queue.poll();
      System.out.print(s + " ");

      Iterator<Integer> i = adj[s].listIterator();
      while (i.hasNext()) {
        int n = i.next();
        if (!visited[n]) {
          visited[n] = true;
          queue.add(n);
        }
      }
    }
  }

  public static void main(String args[]) {
    Graph g = new Graph(4);

    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);

    System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

    g.BFS(2);
  }
}
