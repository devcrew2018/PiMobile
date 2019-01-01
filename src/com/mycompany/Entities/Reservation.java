/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entities;

/**
 *
 * @author Firas
 */
public class Reservation {
    private int id;
    private String lib;
    private String username;
    private String email;

    public Reservation() {
    }
    
    

    public Reservation(String lib, String username, String email) {
        this.lib = lib;
        this.username = username;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getLib() {
        return lib;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
