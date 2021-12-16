package com.buania.buanialaxtechhblux.commande;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("commande")
@CrossOrigin("*")
public class CommandeController {
    @Autowired
    CommandeRepository commandeRepository ;
    @GetMapping("all")
    public List<Commande> getAllCommandes(){
        return commandeRepository.findAll();
    }

    @PostMapping("new")
    public Commande createCommande(@RequestBody Commande commande){
        System.out.println("New: create Commande ");
        return commandeRepository.save(commande);
    }

   /* @PutMapping("edit")
    public Commande updateCommande(@RequestBody Commande commande){
        System.out.println("Edit: Update clienthblux ");
        return commandeRepository.save(commande);
    }

    */
}
