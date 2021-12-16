package com.buania.buanialaxtechhblux.hbevent;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("events")
@CrossOrigin("*")
public class HBEventController {

    @Autowired
    private HbEventsRepository hbEventsRepository;

    @GetMapping("all")
    public List<Hbevent> getAllHbevent(){
        return hbEventsRepository.findAll();
    }

    @PostMapping("new")
    public Hbevent createHbevent(@RequestBody Hbevent hbevent){
        return hbEventsRepository.save(hbevent);
    }

    @PutMapping("edit")
    public Hbevent updateHbevent(@RequestBody Hbevent hbeventUpdate){

        return hbEventsRepository.save(hbeventUpdate);
    }
}
