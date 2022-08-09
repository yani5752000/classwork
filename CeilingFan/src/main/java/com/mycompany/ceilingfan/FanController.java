/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ceilingfan;

/**
 *
 * @author asadp
 */
public class FanController {
     private UserIO io = new UserIOImpl();

    public void run() {
        Fan fan = new Fan();
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
            io.print("Fan is working at speed " + fan.getSpd() + " and in " 
                    + fan.getDir() + " direction.");
            io.print("Main Menu");
            io.print("1. Enter 1 to Pull Speed Cord");
            io.print("2. Enter 2 to Pull Direction Cord");
            io.print("3. Enter 3 to Exit");

            menuSelection = io.readInt("Please select from the"
                    + " above choices.", 1, 3);

            switch (menuSelection) {
                case 1:
                    fan.pullCord1();
                    break;
                case 2:
                    fan.pullCord2();
                    break;
               case 3:
                    keepGoing = false;
                    break;
                default:
                    io.print("UNKNOWN COMMAND");
            }

        }
        io.print("GOOD BYE");
    }
}
