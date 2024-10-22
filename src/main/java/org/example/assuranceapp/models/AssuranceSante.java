package org.example.assuranceapp.models;

import org.example.assuranceapp.enums.type_assurance;
import org.example.assuranceapp.enums.type_de_couverture;

import javax.persistence.*;

@Entity
public class AssuranceSante extends Assurance {
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private String etatSante;

    @Enumerated(EnumType.STRING)
    private type_de_couverture typeDeCouverture;


    public AssuranceSante() {
        super();
    }


    public AssuranceSante(type_assurance type, int base, Utilisateur utilisateur, int age, String etatSante, type_de_couverture typeDeCouverture) {
        super(type, base, utilisateur);
        this.age = age;
        this.etatSante = etatSante;
        this.typeDeCouverture = typeDeCouverture;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getEtatSante() {
        return etatSante;
    }
    public void setEtatSante(String etatSante) {
        this.etatSante = etatSante;
    }
    public type_de_couverture getTypeDeCouverture() {
        return typeDeCouverture;
    }

    }