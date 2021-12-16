package com.buania.buanialaxtechhblux.livraison;

import com.buania.buanialaxtechhblux.reservation.Reservation;
import com.buania.buanialaxtechhblux.reservation.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("livraison")
@CrossOrigin("*")
public class LivraisonController {
    @Autowired
    LivraisonRepository livraisonRepository ;
    @GetMapping("all")
    public List<Livraison> getAllCommandes(){
        return livraisonRepository.findAll();
    }

    @PostMapping("new")
    public Livraison createCommande(@RequestBody Livraison reservation){
        System.out.println("New: create Livraison ");
        return livraisonRepository.save(reservation);
    }

    @PutMapping("edit")
    public Livraison updateCommande(@RequestBody Livraison reservation){
        System.out.println("New: create Reservation ");
        return livraisonRepository.save(reservation);
    }

}
