package org.example.assuranceapp.models;

import org.example.assuranceapp.enums.type_assurance;

import javax.persistence.*;
import java.util.List;


@Entity
public class AssuranceAuto extends Assurance {
    @Column(nullable = false)
    private int ageConducteur;
    @ManyToOne
    @JoinColumn(name = "vehicule_id")
    private Vehicule vehicule;


    public AssuranceAuto() {
        super();
    }

    public AssuranceAuto(type_assurance type, int base, Utilisateur utilisateur, int ageConducteur, Vehicule vehicule) {
        super(type, base ,utilisateur);
        this.ageConducteur = ageConducteur;
        this.vehicule = vehicule;
    }
    public int getAgeConducteur() {
        return ageConducteur;
    }
    public void setAgeConducteur(int ageConducteur) {
        this.ageConducteur = ageConducteur;
    }
    public Vehicule getVehicule() {
        return vehicule;
    }
    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }


}