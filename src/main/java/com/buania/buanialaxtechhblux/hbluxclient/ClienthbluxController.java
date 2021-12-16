package com.buania.buanialaxtechhblux.hbluxclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clienthblux")
@CrossOrigin("*")
public class ClienthbluxController {

    @Autowired
    private ClienthbluxRepository clienthbluxRepository;

    @GetMapping("all")
    public List<Clienthblux> getAllClienthblux(){
        System.out.println("all: all clienthblux ");
        return clienthbluxRepository.findAll();
    }

    @GetMapping("one")
    public Clienthblux findOneClienthblux(@PathVariable("name") String name){
        System.out.println("One: findByName clienthblux ");
        return clienthbluxRepository.findByNomContains(name);
    }

    @GetMapping("connexion")
    public Clienthblux findOneClienthbluxForConnexion(@PathVariable("email") String email,
                                                      @PathVariable("password")String password){
        System.out.println("Connexion: findByEmailPassword clienthblux ");
        return clienthbluxRepository.findByEmailAndMotDePasse(email, password);
    }

    @PostMapping("new")
    public Clienthblux createClienthblux(@RequestBody Clienthblux clienthblux){
        System.out.println("New: create clienthblux ");
        return clienthbluxRepository.save(clienthblux);
    }

    @PutMapping("edit")
    public Clienthblux updateClienthblux(@RequestBody Clienthblux clienthblux){
        System.out.println("Edit: Update clienthblux ");
        return clienthbluxRepository.save(clienthblux);
    }



}
