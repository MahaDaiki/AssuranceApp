package org.example.assuranceapp.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Devis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String typeassurance;
    private double montant;
    private LocalDate datecreation;
    private boolean estAccepte;

    @OneToOne(mappedBy = "devis", cascade = CascadeType.ALL)
    private Contrat contrat;

    public Devis() {}
    public Devis(String typeassurance, double montant, LocalDate datecreation, boolean estAccepte) {
        this.typeassurance = typeassurance;
        this.montant = montant;
        this.datecreation = datecreation;
        this.estAccepte = estAccepte;

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTypeassurance() {
        return typeassurance;
    }
    public void setTypeassurance(String typeassurance) {
        this.typeassurance = typeassurance;
    }
    public double getMontant() {
        return montant;
    }
    public void setMontant(double montant) {
        this.montant = montant;
    }
    public LocalDate getDatecreation() {
        return datecreation;
    }
    public void setDatecreation(LocalDate datecreation) {
        this.datecreation = datecreation;
    }
    public boolean isEstAccepte() {
        return estAccepte;
    }
    public void setEstAccepte(boolean estAccepte) {
        this.estAccepte = estAccepte;
    }

}
