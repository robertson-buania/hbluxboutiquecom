package com.buania.buanialaxtechhblux.article;

import com.buania.buanialaxtechhblux.hbmedia.Hbmedia;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor @ToString
public class Article implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 70,unique = true)
    private String nom;
    private Double prix;
    private Integer quantite;
    @Column(length = 12)
    private String type;
    private Boolean disponible;
    private Boolean promotion;
    @Column(length = 2000)
    private String description;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "article")
    private Set<Hbmedia> hbmediaSet =new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Boolean getPromotion() {
        return promotion;
    }

    public void setPromotion(Boolean promotion) {
        this.promotion = promotion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Hbmedia> getHbmediaSet() {
        return hbmediaSet;
    }

    public void setHbmediaSet(Set<Hbmedia> hbmediaSet) {
        this.hbmediaSet = hbmediaSet;
    }
}
