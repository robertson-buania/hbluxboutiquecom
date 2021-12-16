package com.buania.buanialaxtechhblux.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("reservation")
@CrossOrigin("*")
public class ReservationController {

    @Autowired
    ReservationRepository reservationRepository ;
    @GetMapping("all")
    public List<Reservation> getAllCommandes(){
        return reservationRepository.findAll();
    }
    @PostMapping("new")
    public Reservation createCommande(@RequestBody Reservation reservation){
        System.out.println("New: create Reservation ");
        return reservationRepository.save(reservation);
    }


}
