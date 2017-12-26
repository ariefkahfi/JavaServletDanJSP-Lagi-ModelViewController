/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arief.models;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author arief
 */
public class ShoppingCart {
    private String name;
    private int quantity;
    
   
    private Hashtable<String,ItemBean> hashItemBean = new Hashtable<>();
    
    public void setName(String name){
        this.name=name;
    }
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
   
    public int getQuantity(){
        return this.quantity;
    }
    public String getName(){
        return this.name;
    } 
    
    public void addItemBeanToCart(ItemBean itemBean){
        String key = "";
        
        if(itemBean.getName().equals("Laptop")){
            key = "K001";
        }else if(itemBean.getName().equals("Headset")){
            key = "K002";
        }
        itemBean.setKey(key);
        
        
        if(hashItemBean.containsKey(itemBean.getKey())){
            addQuantityItemBean(itemBean.getKey(), 1);
        }else{
            hashItemBean.put(itemBean.getKey(), itemBean);
        }
        
    }
    
    public String formatPrice(float price){
        String formatedPrice;
        
        DecimalFormat df = new DecimalFormat("#######.##");
        
        formatedPrice = df.format(price);
        
        return formatedPrice;
    }
    
    public float calculatePricePerItemBeanKey(ItemBean itemBean){
        float total = 0;
        
        int currentQuantity = itemBean.getQuantity();
        
        if(itemBean.getKey().equals("K001")){
            total = currentQuantity * 8000000;
        }else if(itemBean.getKey().equals("K002")){
            total = currentQuantity * 500000;
        }
        
        return total;
    }
    public void removeItemBean(String key){
        hashItemBean.remove(key);
    }
    public void addQuantityItemBean(String key , int newQuantity){
        ItemBean bean = hashItemBean.get(key);
        bean.setQuantity(bean.getQuantity() + newQuantity);
        hashItemBean.put(key, bean);
    }
    public Hashtable<String , ItemBean > getItemsBeanCart(){
        return this.hashItemBean;
    }

}
