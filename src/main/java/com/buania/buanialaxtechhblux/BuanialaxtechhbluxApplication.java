package com.buania.buanialaxtechhblux;

import com.buania.buanialaxtechhblux.article.Article;

import com.buania.buanialaxtechhblux.articlecommandee.ArticleCommandee;
import com.buania.buanialaxtechhblux.articlecommandee.ArticleCommandeeRepository;
import com.buania.buanialaxtechhblux.commande.Commande;
import com.buania.buanialaxtechhblux.commande.CommandeRepository;
import com.buania.buanialaxtechhblux.hbluxclient.Clienthblux;
import com.buania.buanialaxtechhblux.hbluxclient.ClienthbluxRepository;
import com.buania.buanialaxtechhblux.article.ArticleRepository;
import com.buania.buanialaxtechhblux.hbevent.HbEventsRepository;
import com.buania.buanialaxtechhblux.hbevent.Hbevent;
import com.buania.buanialaxtechhblux.hbmedia.HBMediaRepository;
import com.buania.buanialaxtechhblux.hbmedia.Hbmedia;
import com.buania.buanialaxtechhblux.reservation.Reservation;
import com.buania.buanialaxtechhblux.reservation.ReservationRepository;
import com.buania.buanialaxtechhblux.services.HBLuxServices;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
public class BuanialaxtechhbluxApplication  {
public static void main(String[] args) {

        SpringApplication.run(BuanialaxtechhbluxApplication.class, args);
    }

    @Bean
    CommandLineRunner start (){
        return args -> {
            System.out.println("L'application a demarrée avec succès");
        };


    }

    /*
    IntStream.rangeClosed(1,30).forEach(i->{
            Article article =new Article();
            article.setQuantite(random.nextInt(1000));
            article.setPromotion(random.nextBoolean());
            article.setPrix(100+random.nextDouble()*1000);
            article.setNom(RandomString.make(12));
            article.setDescription(RandomString.make());
            article.setType(RandomString.make(6));
            article.setDisponible(random.nextBoolean());
            articleRepository.save(article);
            IntStream.rangeClosed(1,3).forEach(j->{
                Hbmedia hbmedia=new Hbmedia();
                hbmedia.setTaille("Taille"+random.nextInt(100));
                hbmedia.setTypeMedia(RandomString.make(5));
                hbmedia.setMediaUrl(RandomString.make());
                hbmedia.setFavoris(random.nextBoolean());
                 hbmedia.setArticle(article);
                hbMediaRepository.save(hbmedia);
            });
        })
     */
}
