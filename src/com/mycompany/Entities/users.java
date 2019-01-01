/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entities;

/**
 *
 * @author Amine
 */
public class users {
    
    private int id;
    private String nom ;
    private String mail;
    private int numero;
    private String mdp;
    private String sexe;
    private String role;
    private String specialite;
    private String date;
    private String photo;

    public users() {
    }

    @Override
    public String toString() {
        return "users{" + "id=" + id + ", nom=" + nom + ", mail=" + mail + ", numero=" + numero + ", mdp=" + mdp + ", sexe=" + sexe + ", role=" + role + ", specialite=" + specialite + ", date=" + date + ", photo=" + photo + '}';
    }

  

    public users(String nom, String mail, int numero, String mdp, String sexe) {
        this.nom = nom;
        this.mail = mail;
        this.numero = numero;
        this.mdp = mdp;
        this.sexe = sexe;
    }

    public users(String nom, String mail, int numero, String mdp, String sexe, String photo) {
        this.nom = nom;
        this.mail = mail;
        this.numero = numero;
        this.mdp = mdp;
        this.sexe = sexe;
        this.photo = photo;
    }
    
    

    public users(int id, String nom, String mail, int numero, String mdp, String sexe, String role, String specialite, String date, String photo) {
        this.id = id;
        this.nom = nom;
        this.mail = mail;
        this.numero = numero;
        this.mdp = mdp;
        this.sexe = sexe;
        this.role = role;
        this.specialite = specialite;
        this.date = date;
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    
    
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getMail() {
        return mail;
    }

    public int getNumero() {
        return numero;
    }

    public String getMdp() {
        return mdp;
    }

    public String getSexe() {
        return sexe;
    }

    public String getRole() {
        return role;
    }

    public String getSpecialite() {
        return specialite;
    }

    public String getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public void setDate(String date) {
        this.date = date;
    }
    

}
