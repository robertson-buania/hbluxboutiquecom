package com.buania.buanialaxtechhblux.articlecommandee;

import com.buania.buanialaxtechhblux.article.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleCommandeeRepository extends JpaRepository<ArticleCommandee,Long> {

    public List<ArticleCommandee> findByCommande_Id(Long id);

}
