/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.sqg.dao;

/**
 *
 * @author faridasadpour
 */
public class SQGDaoException extends Exception {
    public SQGDaoException(String message) {
        super(message);
    }
    
    public SQGDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
