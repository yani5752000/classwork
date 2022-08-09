/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ceilingfan;

import java.util.Scanner;

/**
 *
 * @author asadp
 */
public class UserIOImpl implements UserIO{

    public void print(int num){
        System.out.println(num);
    }

    public String readString(String prompt){
        Scanner sc = new Scanner(System.in);
        String str;
        System.out.println(prompt);
        str = sc.nextLine();
        return str;
        
    }

    public int readInt(String prompt){
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.println(prompt);
        num = Integer.parseInt(sc.nextLine());
        return num;
    }
    public int readInt(String prompt, int min, int max){
        Scanner sc = new Scanner(System.in);
        int num;
        
        do{
            System.out.println(prompt);
            num = Integer.parseInt(sc.nextLine());
        } while(num > max || num < min);
        
        return num;
    }

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    
}
