/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ceilingfan;

import static com.mycompany.ceilingfan.Direction.*;
import static com.mycompany.ceilingfan.Speed.*;

/**
 *
 * @author asadp
 */
public class Fan {
    private Speed spd;
    private Direction dir;
    
    public Fan() {
        spd =SPEED0;
        dir = FORWARD;
    }

    public Speed getSpd() {
        return spd;
    }

    public void setSpd(Speed spd) {
        this.spd = spd;
    }

    public Direction getDir() {
        return dir;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }
    
    public void pullCord1() {
        switch(getSpd()) {
            case SPEED0: setSpd(SPEED1);
            break;
            case SPEED1: setSpd(SPEED2);
            break;
            case SPEED2: setSpd(SPEED3);
            break;
            case SPEED3: setSpd(SPEED0);
            break;
            default: break;
        }
        
    }
    
    public void pullCord2() {
        switch(getDir()) {
            case FORWARD: setDir(BACKWARD);
            break;
            case BACKWARD: setDir(FORWARD);
            break;
            default: break;
        }
        
    }
}
