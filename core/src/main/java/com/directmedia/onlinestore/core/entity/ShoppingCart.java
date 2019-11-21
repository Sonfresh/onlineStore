/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.core.entity;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Administrator
 */
public class ShoppingCart {
    private Set<Work> items = new HashSet<>();

    public Set<Work> getItems() {
        return items;
    }

    public void setItems(Set<Work> items) {
        this.items = items;
    }
    
    
}
