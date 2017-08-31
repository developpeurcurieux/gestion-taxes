/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.taxes.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Entreprise implements Serializable {
   @Id
   @GeneratedValue
   private Long code;
   private String nom;
   private String email;
   private String raisonSociale;
   
   @OneToMany(mappedBy="entreprise", fetch=FetchType.LAZY)
   private Collection<Taxe> taxes;

    public Entreprise() {
    }

    public Entreprise(String nom, String email, String raisonSociale) {
        this.nom = nom;
        this.email = email;
        this.raisonSociale = raisonSociale;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public Collection<Taxe> getTaxes() {
        return taxes;
    }

    public void setTaxes(Collection<Taxe> taxes) {
        this.taxes = taxes;
    }
   
   
}