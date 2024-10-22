package org.example.assuranceapp.models;
import javax.persistence.*;
import java.time.LocalDate;

public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String fichier;

    @OneToOne
    @JoinColumn(name = "devis_id")
    private Devis devis;


    public Contrat() {}


    public Contrat(LocalDate dateDebut, LocalDate dateFin, String fichier, Devis devis) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.fichier = fichier;
        this.devis = devis;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDate getDateDebut() {
        return dateDebut;
    }
    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }
    public LocalDate getDateFin() {
        return dateFin;
    }
    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }
    public String getFichier() {
        return fichier;
    }
    public void setFichier(String fichier) {
        this.fichier = fichier;
    }
    public Devis getDevis() {
        return devis;
    }
    public void setDevis(Devis devis) {
        this.devis = devis;
    }

}
