/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author faridasadpour
 */
public class Triangle {
    private double side1;
    private double side2;
    private double side3;
    public double getPerimeter(){
        return side1 + side2 + side3;
    }
    public double getArea(){
        return side1 * side2 * side3;
    }
}
