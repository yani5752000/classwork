/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.threadexample;

import static com.mycompany.threadexample.RunnableDemo.printPrimes;

/**
 *
 * @author asadp
 */
public class TestThread {

   public static void main(String args[]) {
      //printPrimes(50);
       
      RunnableDemo R1 = new RunnableDemo( "Thread-1", 50);
      R1.start();
      
//      RunnableDemo R2 = new RunnableDemo( "Thread-2", 200);
//      R2.start();
   }   
}
