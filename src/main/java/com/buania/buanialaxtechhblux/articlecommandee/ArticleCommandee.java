package com.buania.buanialaxtechhblux.articlecommandee;

import com.buania.buanialaxtechhblux.commande.Commande;
import com.buania.buanialaxtechhblux.reservation.Reservation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ArticleCommandee implements Serializable {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(length = 70)
    private String nomArticle;
    private Double prix;
    @Column(length = 50)
    private String couleur;
    @Column(length = 20)
    private String taille;
    private Integer quantite;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "commande_id",
            referencedColumnName = "id"
    )
    @JsonIgnore
    private Commande commande;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "reservation_id",
            referencedColumnName = "id"
    )
    @JsonIgnore
    private Reservation reservation;

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomArticle() {
        return nomArticle;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
