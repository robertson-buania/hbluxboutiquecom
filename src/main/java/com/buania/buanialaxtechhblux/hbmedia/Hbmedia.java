package com.buania.buanialaxtechhblux.hbmedia;

import com.buania.buanialaxtechhblux.article.Article;
import com.buania.buanialaxtechhblux.hbevent.Hbevent;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Hbmedia implements Serializable  {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 8)
    private String typeMedia;

    private String mediaUrl;
    @Column(length = 10)
    private String taille;

    private Boolean favoris;

    private Integer likes;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "article_id",referencedColumnName = "id"
    )
    @JsonIgnore
    private Article article;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeMedia() {
        return typeMedia;
    }

    public void setTypeMedia(String typeMedia) {
        this.typeMedia = typeMedia;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public Boolean getFavoris() {
        return favoris;
    }

    public void setFavoris(Boolean favoris) {
        this.favoris = favoris;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

}
