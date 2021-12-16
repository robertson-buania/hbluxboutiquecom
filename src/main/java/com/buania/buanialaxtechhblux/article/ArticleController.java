package com.buania.buanialaxtechhblux.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("article")
@CrossOrigin("*")
public class ArticleController {

    @Autowired
    private  ArticleRepository articleRepository;

    @GetMapping("all")
    public List<Article> getAllArticle(){
        return articleRepository.findAll();
    }

    @GetMapping("onename")
    public Article findOneArticle(@PathVariable("name") String name){
        return articleRepository.findByNomContains(name);
    }

    @GetMapping("one")
    public Article findOneArticleById(@PathVariable("id") Long id){
        return articleRepository.findById(id).get();
    }
    @PostMapping("new")
    public Article createArcticle(@RequestBody Article article){
        return articleRepository.save(article);
    }

    @PutMapping("edit")
    public Article updateArticle(@RequestBody Article articleUpdate){
        Article article=articleRepository.findById(articleUpdate.getId()).get();
        article.setDescription(articleUpdate.getDescription());
        article.setDisponible(articleUpdate.getDisponible());
        //article.setHbmediaSet(articleUpdate.getHbmediaSet());
        article.setNom(articleUpdate.getNom());
        article.setPrix(articleUpdate.getPrix());
        article.setPromotion(articleUpdate.getPromotion());
        article.setQuantite(articleUpdate.getQuantite());

        return articleRepository.save(article);
    }

}
