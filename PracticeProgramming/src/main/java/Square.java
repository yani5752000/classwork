/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author faridasadpour
 */
public class Square extends Shape {
    private double side;
    public double getArea(){
        return side * side;
    }
    public double getPerimeter(){
        return side * 4;
    }
}
