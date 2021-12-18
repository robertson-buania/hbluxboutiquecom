package com.buania.buanialaxtechhblux.commande;


import com.buania.buanialaxtechhblux.articlecommandee.ArticleCommandee;
import com.buania.buanialaxtechhblux.articlecommandee.ArticleCommandeeRepository;
import com.buania.buanialaxtechhblux.hbluxclient.Clienthblux;
import com.buania.buanialaxtechhblux.hbluxclient.ClienthbluxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("commande")
@CrossOrigin("*")
public class CommandeController {
    @Autowired
    CommandeRepository commandeRepository ;
    @Autowired
    private ClienthbluxRepository clienthbluxRepository;

    private Set<ArticleCommandee> commandeeSet=new HashSet<>();
    @Autowired
    private ArticleCommandeeRepository articleCommandeeRepository;
    @GetMapping("all")
    public List<Commande> getAllCommandes(){
        return commandeRepository.findAll();
    }



    @PostMapping("new")
    public Commande updateCommande(@RequestBody Commande com ){
        Commande commandee=saveCommande(com);

        saveArticleCommande(com.getArticleCommandees(),com);
        System.out.println("Edit: Update clienthblux "+ commandee);
        updateSavingCommande(commandee,com.getCote());

        updateSavingArticleCommande(commandee);
        return commandee;
    }

    public Commande saveCommande(Commande commanded){
        Commande commande=new Commande();
        System.out.println("Recu"+commande.toString());

        commande.setDateCommande(commanded.getDateCommande());
        commande.setDateLivraison(commanded.getDateLivraison());
        commande.setCote("HBLUX2021"+commanded.getCote());
       return commandeRepository.save(commande);
    }

    public void updateSavingCommande(Commande commande,String cote){
        Clienthblux clienthblux =clienthbluxRepository.findById(Long.valueOf(cote)).get();
        commande.setClienthblux(clienthblux);
        commandeRepository.save(commande);
    }

    public void updateSavingArticleCommande(Commande commande){
        commandeeSet.forEach(articl->{

            articl.setCommande(commande);
            articleCommandeeRepository.save(articl);
        });

    }

   void saveArticleCommande(Set<ArticleCommandee> articles, Commande commande){
      

        articles.forEach(articl->{
            ArticleCommandee artComm =new ArticleCommandee();
            artComm.setCouleur(articl.getCouleur());
            artComm.setTaille(articl.getTaille());
            artComm.setPrix(articl.getPrix());
            artComm.setNomArticle(articl.getNomArticle());
            artComm.setQuantite(articl.getQuantite());

            artComm.setCommande(commande);

            commandeeSet.add(articleCommandeeRepository.save(articl));
        });
    }
}
