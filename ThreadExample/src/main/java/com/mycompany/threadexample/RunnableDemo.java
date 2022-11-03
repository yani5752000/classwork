/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.threadexample;

/**
 *
 * @author asadp
 */
class RunnableDemo implements Runnable {
   //private Thread t;
   private String threadName;
   private int number;
   
   RunnableDemo( String name,int number) {
      threadName = name;
      this.number = number;
      System.out.println("Creating " +  threadName );
   }
   
   public void run() {
      System.out.println("Running " +  threadName );
      //printPrimes(number);
      try {
         for(int i = 4; i > 0; i--) {
            System.out.println("Thread: " + threadName + ", " + i);
            printPrimes(number);
            // Let the thread sleep for a while.
            Thread.sleep(50);
         }
      } catch (InterruptedException e) {
         System.out.println("Thread " +  threadName + " interrupted.");
      }
      System.out.println("Thread " +  threadName + " exiting.");
   }
   
   public void start () {
      System.out.println("Starting " +  threadName );
//      if (t == null) {
//         t = new Thread (this, threadName);
//         t.start ();
//      }
    Thread t = new Thread (this, threadName);
         t.start ();
   }
   
   public static boolean isPrime(int n){
       //System.out.println("hi isPrime");
       if (n == 1){
           return false;
       }
       
       for (int i = n - 1; i > 1; i--){
           if(n % i == 0) {
               return false;
           }
       }
       
       return true;
   }
   
   public static void printPrimes(int m) {
       System.out.println("hi m " + m);
       System.out.println("hi printPrimes");
       System.out.println("hi check " + isPrime(5));
       for (int i = 1; i <= m; i++){
//           System.out.println("hihi " + i);
           if(isPrime(i)){
               System.out.println(i);
           }
       }
   }
}
