/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author faridasadpour
 */
public class Rectangle {
    private double width;
    private double height;
    public double getArea(){
        return height * width;
    }
    public double getPerimeter(){
        return 2 * (width + height);
    }
}
