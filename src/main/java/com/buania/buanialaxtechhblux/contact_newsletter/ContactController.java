package com.buania.buanialaxtechhblux.contact_newsletter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contactnews")
@CrossOrigin("*")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private NewsletterRepository newsletterRepository;

    @GetMapping("allcontact")
    public List<Contact> getAllContact(){
        return contactRepository.findAll();
    }

    @GetMapping("allnews")
    public List<Newsletter> getAllNewletter(){
        return newsletterRepository.findAll();
    }

    @PostMapping("newnews")
    public Newsletter createNewsletter(@RequestBody Newsletter newsletter ){
        return newsletterRepository.save(newsletter);
    }
    @PostMapping("newcontact")
    public Contact  createContact(@RequestBody Contact contact){
        return contactRepository.save(contact);
    }



}
