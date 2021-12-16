package com.buania.buanialaxtechhblux.article;

import com.buania.buanialaxtechhblux.article.Article;
import com.buania.buanialaxtechhblux.hbmedia.Hbmedia;
import com.buania.buanialaxtechhblux.hbmedia.HbmediaProjection;
import org.springframework.data.rest.core.config.Projection;

import java.util.Set;
@Projection(name="articlesProj",types = {Article.class, Hbmedia.class})
public interface ArticleProjection {
    public Long getId();
    public String getNom();
    public Double getPrix();
    public Integer getQuantite();
    public String getType();
    public Boolean getDisponible();
    public Boolean getPromotion();
    public String getDescription();
    public Set<HbmediaProjection> getHbmediaSet();
}
