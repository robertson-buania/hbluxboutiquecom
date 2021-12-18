package com.buania.buanialaxtechhblux.reservation;

import com.buania.buanialaxtechhblux.articlecommandee.ArticleCommandee;
import com.buania.buanialaxtechhblux.hbluxclient.Clienthblux;
import com.buania.buanialaxtechhblux.hbmedia.Hbmedia;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Reservation implements Serializable {

    @Id@GeneratedValue(strategy =GenerationType.IDENTITY )
    private Long id;
    private LocalDate dateReservation;
    private LocalDate dateFacturation;
    @Column(length = 30)
    private String cote;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "reservation")
    private Set<ArticleCommandee> articleCommandees =new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "clienthblux_id",referencedColumnName = "id"
    )
    @JsonIgnore
    private Clienthblux clienthblux;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(LocalDate dateReservation) {
        this.dateReservation = dateReservation;
    }

    public LocalDate getDateFacturation() {
        return dateFacturation;
    }

    public void setDateFacturation(LocalDate dateFacturation) {
        this.dateFacturation = dateFacturation;
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
}
