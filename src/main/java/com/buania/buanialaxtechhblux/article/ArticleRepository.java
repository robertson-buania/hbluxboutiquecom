package com.buania.buanialaxtechhblux.article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
    @Query("select a from Article a left join a.hbmediaSet")
    public Set<Article> getAllArticles();

    public Article findByNomContains(@Param("name") String name);

}
