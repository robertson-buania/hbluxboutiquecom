package com.buania.buanialaxtechhblux.commande;

import com.buania.buanialaxtechhblux.articlecommandee.ArticleCommandee;
import com.buania.buanialaxtechhblux.hbluxclient.Clienthblux;
import com.buania.buanialaxtechhblux.livraison.Livraison;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Commande implements Serializable {

@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateCommande;
    private LocalDate dateLivraison;
    @Column(length = 10)
    private String cote;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "commande")
    private Set<ArticleCommandee> articleCommandees =new HashSet<>();
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "clienthblux_id",referencedColumnName = "id"
    )
    @JsonIgnore
    private Clienthblux clienthblux;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(
            name = "livraison_id",referencedColumnName = "id"
    )
    private Livraison livraison;

    public LocalDate getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(LocalDate dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDate dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getCote() {
        return cote;
    }

    public void setCote(String cote) {
        this.cote = cote;
    }

    public Set<ArticleCommandee> getArticleCommandees() {
        return articleCommandees;
    }

    public void setArticleCommandees(Set<ArticleCommandee> articleCommandees) {
        this.articleCommandees = articleCommandees;
    }

    public Clienthblux getClienthblux() {
        return clienthblux;
    }

    public void setClienthblux(Clienthblux clienthblux) {
        this.clienthblux = clienthblux;
    }

    public Livraison getLivraison() {
        return livraison;
    }

    public void setLivraison(Livraison livraison) {
        this.livraison = livraison;
    }
}
