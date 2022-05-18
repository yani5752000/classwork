
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author faridasadpour
 */
public class UserIOImpl implements UserIO{
    public void print(String message){
        System.out.println(message);
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

    public double readDouble(String prompt){
        Scanner sc = new Scanner(System.in);
        double num;
        System.out.println(prompt);
        num = Double.parseDouble(sc.nextLine());
        return num;
    }

    public double readDouble(String prompt, double min, double max){
        Scanner sc = new Scanner(System.in);
        double num;
        
        do{
            System.out.println(prompt);
            num = Double.parseDouble(sc.nextLine());
        } while(num > max || num < min);
        
        return num;
    }

    public float readFloat(String prompt){
        Scanner sc = new Scanner(System.in);
        float num;
        System.out.println(prompt);
        num = Float.parseFloat(sc.nextLine());
        return num;
    }

    public float readFloat(String prompt, float min, float max){
        Scanner sc = new Scanner(System.in);
        float num;
        
        do{
            System.out.println(prompt);
            num = Float.parseFloat(sc.nextLine());
        } while(num > max || num < min);
        
        return num;
    }

    public long readLong(String prompt){
        Scanner sc = new Scanner(System.in);
        long num;
        System.out.println(prompt);
        num = Long.parseLong(sc.nextLine());
        return num;
    }

    public long readLong(String prompt, long min, long max){
        Scanner sc = new Scanner(System.in);
        long num;
        
        do{
            System.out.println(prompt);
            num = Long.parseLong(sc.nextLine());
        } while(num > max || num < min);
        
        return num;
    }
}
