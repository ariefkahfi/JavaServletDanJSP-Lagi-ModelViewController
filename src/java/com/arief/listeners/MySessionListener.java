/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arief.listeners;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author arief
 */
public class MySessionListener implements HttpSessionListener,HttpSessionAttributeListener {

    
    
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.err.println("sesion created ");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.err.println("session destroyed ");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.err.println("session attribute added ...");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.err.println("session attribute destroyed ....");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.err.println("session attribute replaced ....");
    }
    
}
