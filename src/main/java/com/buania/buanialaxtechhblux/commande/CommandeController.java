package com.buania.buanialaxtechhblux.commande;


import com.buania.buanialaxtechhblux.articlecommandee.ArticleCommandee;
import com.buania.buanialaxtechhblux.articlecommandee.ArticleCommandeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("commande")
@CrossOrigin("*")
public class CommandeController {
    @Autowired
    CommandeRepository commandeRepository ;
    @Autowired
    private ArticleCommandeeRepository articleCommandeeRepository;
    @GetMapping("all")
    public List<Commande> getAllCommandes(){
        return commandeRepository.findAll();
    }



    @PostMapping("new")
    public Commande updateCommande(@RequestBody Commande commande ){
        Commande commandee=saveCommande(commande);
        System.out.println("Recu"+commande.toString());

        saveArticleCommande(commande.getArticleCommandees(),commande);
        System.out.println("Edit: Update clienthblux "+ commandee);
        return commandeRepository.save(commandee);
    }

    Commande saveCommande(Commande commanded){
        Commande commande=new Commande();
        commande.setClienthblux(commanded.getClienthblux());
        commande.setDateCommande(commanded.getDateCommande());
        commande.setDateLivraison(commanded.getDateLivraison());
        commande.setCote(commanded.getCote());
       return commandeRepository.save(commande);
    }

   void saveArticleCommande(Set<ArticleCommandee> articles, Commande commande){
      

        articles.forEach(articl->{
            articl.setCommande(commande);

            articleCommandeeRepository.save(articl);
        });
    }
}
