package com.buania.buanialaxtechhblux.hbmedia;

import com.buania.buanialaxtechhblux.article.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RestResource
public interface HBMediaRepository extends JpaRepository<Hbmedia,Long> {

    List<Hbmedia> findAllByArticle(Article article);
}
