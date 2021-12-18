package com.buania.buanialaxtechhblux.hbluxclient;

import com.buania.buanialaxtechhblux.commande.Commande;
import com.buania.buanialaxtechhblux.reservation.Reservation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Clienthblux implements Serializable {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20)
    private String prenom;
    @Column(length = 20)
    private String nom;
    @Column(unique = true)
    private String email;
    @Column(length = 10)
    private String motDePasse;
    @Column(length = 12)
    private String sexe;
    
    private String adresse;
    private LocalDate dateNaissance;
    @OneToMany(mappedBy = "clienthblux")
    private Set<Reservation> reservations =new HashSet<>();

    @OneToMany(mappedBy = "clienthblux")
    private Set<Commande> commandes =new HashSet<>();

    public String getAdresse() {
        return adresse;
    }

    public void setId(String adresse) {
        this.adresse = adresse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Set<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Set<Commande> commandes) {
        this.commandes = commandes;
    }
}
