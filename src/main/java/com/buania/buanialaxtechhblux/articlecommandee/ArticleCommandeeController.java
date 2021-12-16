package com.buania.buanialaxtechhblux.articlecommandee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("articlecommandee")
@CrossOrigin("*")
public class ArticleCommandeeController {
    @Autowired
    private ArticleCommandeeRepository articleCommandeeRepository;

    @GetMapping("all")
    public List<ArticleCommandee> getAllArticle(){
        return articleCommandeeRepository.findAll();
    }

    @PostMapping("new")
    public ArticleCommandee createArticleCommandee(@RequestBody ArticleCommandee article){
        return articleCommandeeRepository.save(article);
    }

    @PutMapping("edit")
    public ArticleCommandee updateArticle(@RequestBody ArticleCommandee articleUpdate){
        ArticleCommandee articleCommandee=articleCommandeeRepository.findById(articleUpdate.getId()).get();
             articleCommandee.setNomArticle(articleUpdate.getNomArticle());
             articleCommandee.setPrix(articleUpdate.getPrix());
             articleCommandee.setQuantite(articleCommandee.getQuantite());

        return articleCommandeeRepository.save(articleCommandee);
    }

}
