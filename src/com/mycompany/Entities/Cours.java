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
public class Cours {
    private int id;
    private String lib;
    private String type;
    private int salle;
    private String coachName;
    private String date;
    private int nbPlace;

    public int getId() {
        return id;
    }

    public String getLib() {
        return lib;
    }

    public String getType() {
        return type;
    }

    public int getSalle() {
        return salle;
    }

    public String getCoachName() {
        return coachName;
    }

    public String getDate() {
        return date;
    }

    public int getNbPlace() {
        return nbPlace;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSalle(int salle) {
        this.salle = salle;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setNbPlace(int nbPlace) {
        this.nbPlace = nbPlace;
    }

    public Cours(int id, String lib, String type, int salle, String coachName, String date, int nbPlace) {
        this.id = id;
        this.lib = lib;
        this.type = type;
        this.salle = salle;
        this.coachName = coachName;
        this.date = date;
        this.nbPlace = nbPlace;
    }

    public Cours(String lib, String type, int salle, String coachName, String date, int nbPlace) {
        this.lib = lib;
        this.type = type;
        this.salle = salle;
        this.coachName = coachName;
        this.date = date;
        this.nbPlace = nbPlace;
    }


    public Cours() {
    }
    
    
}
