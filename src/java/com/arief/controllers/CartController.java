/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arief.controllers;

import com.arief.models.ShoppingCart;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author arief
 */
public class CartController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        ShoppingCart cartBean = (ShoppingCart)req.getSession().getAttribute("cartBean");
        
        switch(pathInfo){
            case "/checkout":
                getServletContext()
                        .getRequestDispatcher("/WEB-INF/views/checkout.jsp")
                        .forward(req, resp);
                break;
            case "/submit-checkout" :
                req.getSession().invalidate();
                getServletContext()
                        .getRequestDispatcher("/WEB-INF/views/submit-checkout.jsp")
                        .forward(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                break;
        }
    }

    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        
        System.err.println(pathInfo);
        
        switch(pathInfo){
            case "/cart":
                getServletContext()
                        .getRequestDispatcher("/WEB-INF/views/cart.jsp").forward(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                break;
        }
        
    }
    
}
