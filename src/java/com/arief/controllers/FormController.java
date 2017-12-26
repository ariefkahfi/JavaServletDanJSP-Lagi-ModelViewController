/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arief.controllers;

import com.arief.models.ItemBean;
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
public class FormController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShoppingCart cartBean = (ShoppingCart)req.getSession().getAttribute("cartBean");
        
       
        if(cartBean == null){
            resp.sendRedirect(getServletContext().getContextPath());
        }else{
            System.err.println(cartBean.toString());
            
            ItemBean bean = new ItemBean();
            
            bean.setName(req.getParameter("item"));
            bean.setQuantity(1);
            
            cartBean.addItemBeanToCart(bean);
            
            resp.sendRedirect(getServletContext().getContextPath());
        }
    }
    
}
