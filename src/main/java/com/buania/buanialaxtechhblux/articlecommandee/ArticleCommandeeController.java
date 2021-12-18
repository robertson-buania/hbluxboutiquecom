package com.buania.buanialaxtechhblux.articlecommandee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
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

    @PostMapping("newOne")
    public ArticleCommandee createArticleCommandee(@RequestBody ArticleCommandee article){
        return articleCommandeeRepository.save(article);
    }


    @PostMapping("new")
    public   List <ArticleCommandee> createArticleCommandee(@RequestBody List <ArticleCommandee> articles){
        List <ArticleCommandee> artCom = new ArrayList<ArticleCommandee>();
        artCom.forEach( article-> {
            artCom.add(articleCommandeeRepository.save(article));
        });
        return artCom;
    }

  

}
