/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.sqg;

import com.sg.sqg.controller.SQGController;
import com.sg.sqg.dao.SQGDao;
import com.sg.sqg.dao.SQGDaoFileImpl;
import com.sg.sqg.ui.SQGView;
import com.sg.sqg.ui.UserIO;
import com.sg.sqg.ui.UserIOConsoleImpl;

/**
 *
 * @author faridasadpour
 */
public class App {
        public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        SQGView myView = new SQGView(myIo);
        SQGDao myDao = new SQGDaoFileImpl();
        SQGController controller =
                new SQGController(myDao, myView);
        controller.run();
    }
}
