/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.core.entity;

/**
 *
 * @author Administrator
 */
public class Artist {
    private String name;
	
	public Artist() {
		
	}
	
	public Artist(String pName) {
		this.name = pName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
