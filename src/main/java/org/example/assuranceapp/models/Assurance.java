package org.example.assuranceapp.models;

import org.example.assuranceapp.enums.type_assurance;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Assurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private type_assurance type;
    @Column(nullable = false)
    private int base;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    public Assurance() {}
    public Assurance(type_assurance type,  int base ,Utilisateur utilisateur) {
        this.type = type;
        this.base = base;
        this.utilisateur = utilisateur;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public type_assurance getType() {
        return type;
    }
    public void setType(type_assurance type) {
        this.type = type;
    }
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }


    }


