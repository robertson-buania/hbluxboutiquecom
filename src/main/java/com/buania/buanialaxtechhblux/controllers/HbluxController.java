package com.buania.buanialaxtechhblux.controllers;

import com.buania.buanialaxtechhblux.articlecommandee.ArticleCommandee;
import com.buania.buanialaxtechhblux.articlecommandee.ArticleCommandeeRepository;

import com.buania.buanialaxtechhblux.hbluxclient.Clienthblux;
import com.buania.buanialaxtechhblux.hbluxclient.ClienthbluxRepository;
import com.buania.buanialaxtechhblux.reservation.Reservation;
import com.buania.buanialaxtechhblux.reservation.ReservationRepository;
import com.buania.buanialaxtechhblux.services.HBLuxServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@CrossOrigin("*")
@RestController
public class HbluxController {
    @Autowired
    ClienthbluxRepository clienthbluxRepository;

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    ArticleCommandeeRepository articleCommandeeRepository;
    @Autowired
    HBLuxServices hbLuxServices;
    private Random random=new Random();


    @GetMapping("allarticlecommandees")
    public List<ArticleCommandee> getAllArticleCommandees(){
        return articleCommandeeRepository.findAll();
    }


    @GetMapping("allclients")
    public List<Clienthblux> getAllClientsHblux(){
        return clienthbluxRepository.findAll();
    }


    @GetMapping("allresevations")
    public List<Reservation> getAllReservations(){
        return reservationRepository.findAll();
    }

   /*
    @PostMapping("confirmeaccount")
    public int confirmeClientCompte(@RequestBody String email){
        int code=random.nextInt(1000);
        hbLuxServices.sendMailToSomeOne("Hbamana2021@gmail.com",
                email,
                "Votre code de confirmation est " + code,"HBLUX test");
        return code;
    }*/
    @PostMapping("createaccount")
    public Clienthblux createClientCompte(@RequestBody Clienthblux clienthblux){

        return this.clienthbluxRepository.save(clienthblux);

    }


}
