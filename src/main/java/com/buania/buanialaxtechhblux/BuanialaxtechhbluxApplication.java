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

    private   Random random=new Random();

    @Autowired private
    ArticleRepository articleRepository;
    @Autowired private
    HBMediaRepository hbMediaRepository;
    @Autowired private
    HbEventsRepository hbEventsRepository;
    @Autowired
    ClienthbluxRepository clienthbluxRepository;
    @Autowired
    CommandeRepository commandeRepository ;

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    ArticleCommandeeRepository articleCommandeeRepository;

    @Autowired
    private HBLuxServices hbLuxServices;
    private List<String> articlesList=new ArrayList<>();

    public List<String> listeArticles(){


        articlesList.add("image6.jpg");

        articlesList.add("image8.jpeg");
        articlesList.add("image6.jpeg");
        articlesList.add("image5.jpeg");
        articlesList.add("pullBlanc7.jpg");

/*

             articlesList.add("polo.mp4");articlesList.add("dame.mp4");articlesList.add("logo.mp4");
             articlesList.add("herve.mp4");articlesList.add("fabrigas.mp4");articlesList.add("polo2.mp4");
        articlesList.add("dame-tshirt.jpg");articlesList.add("short.jpg");articlesList.add("sac.jpg");
        articlesList.add("hblog.jpg");articlesList.add("k??pi.jpg");articlesList.add("bras.jpg");
        articlesList.add("basket.jpeg");articlesList.add("cache-nez.jpg");articlesList.add("femme.jpg");
        articlesList.add("homme.jpg");articlesList.add("short.jpg");articlesList.add("joking.jpg");
        articlesList.add("accueil.jpg");articlesList.add("emballage.jpg");articlesList.add("shape.jpeg");
        articlesList.add("homme.jpg");articlesList.add("short.jpg");
        articlesList.add("basket.jpeg");articlesList.add("cache-nez.jpg");
        articlesList.add("polo.mp4");articlesList.add("dame.mp4");articlesList.add("logo.mp4");
        articlesList.add("herve.mp4");articlesList.add("fabrigas.mp4");articlesList.add("polo2.mp4");

 */
        return articlesList;
    }
public static void main(String[] args) {

        SpringApplication.run(BuanialaxtechhbluxApplication.class, args);
    }

    @Bean
    CommandLineRunner start (){
        return args -> {
           // initHblux();
            System.out.println("L'application a demarr??e avec succ??s");
        };


    }

    public String initHblux(){


        articleEnregistrer();

        System.out.println("******************************************************");
        System.out.println("************ HB EVENT **************");

        System.out.println("******************************************************");
        System.out.println("************** HB MEDIA ****************");
        addMedia();
        System.out.println("Empilement !");
        empilerMediaDansArticler();
        System.out.println("fghjklm??");
        System.out.println("dfghjkl");

        addArticleCommandee();
        addClient();
        addCommande();

        addReservation();

        addArticleToCommande();
        addArticleToReservation();
        addCommandeToClient();
        addReservationToClient();


        return"Reussie";
    }

    public void addMedia(){

        // for (int i = 0; i < 31; i++) {
        for (int i = 0; i <5; i++) {
            Hbmedia hbmedia=new Hbmedia();
            hbmedia.setTypeMedia(RandomString.make(5));
            hbmedia.setMediaUrl(listeArticles().get(i+1));
            hbmedia.setFavoris(random.nextBoolean());
            hbmedia.setLikes(random.nextInt(1000));
            //hbmedia.setArticle(article);
            Hbmedia hbmedia1=  hbMediaRepository.save(hbmedia);
            System.out.println("******************************************************");
            System.out.println("******************************************************");
            System.out.println("******************************************************");
            System.out.println(hbmedia1.toString());


        }
        System.out.println("Enregistrement Media termin?? !");
    


    }
    public void articleEnregistrer(){
        Article article =new Article();
        article.setQuantite(random.nextInt(10));
        article.setPromotion(true);
        article.setPrix(45+0.0);
        article.setNom("Ensemble Jogging");
        article.setDescription("Sweat en molleton de coton m??lang??. Coupe d??contract??e avec capuche doubl??e resserrable par cordon, manches longues et poche kangourou." +
                " Finition bord-c??te aux poignets et ?? la base. Int??rieur doux et bross??. " +
                "Composition de la couche ext??rieure:Coton 60%,Polyster 40%" +
                "Doublure de capuche:Coton 60%, Poluster 40%" +
                "");
        article.setType("enfant");
        article.setDisponible(true);
        Article articleEnregistre=articleRepository.save(article);
        System.out.println("Enregistrement de l'article termin?? !");

       

    }
    public void empilerMediaDansArticler(){
        long id=1;
        Article article=articleRepository.findById(id).get();

        for (long j = 1; j <6; j++) {

            Hbmedia hbmedia= hbMediaRepository.findById(j).get();
            hbmedia.setArticle(article);
            System.out.println("Mis en jour  ??ffectu?? !");
            hbMediaRepository.save(hbmedia);
        }
   
        System.out.println("Empilement termin?? !");


    }
 
    public void addArticleCommandee(){
        long j=1;
        for (int i = 1; i < 6; i++) {
            ArticleCommandee articleCommandee=new ArticleCommandee();
            articleCommandee.setNomArticle(articleRepository.findById(j).get().getNom());
            articleCommandee.setPrix(articleRepository.findById(j).get().getPrix());
            articleCommandee.setTaille("3ans");
            articleCommandee.setCouleur("Noir");
            articleCommandee.setQuantite(random.nextInt(i+2));
            articleCommandeeRepository.save(articleCommandee);
        }
        System.out.println("Article Commande !!!!!!!");

    }

    public void addClient(){
        Clienthblux clienthbluxx=new Clienthblux();
        String nomx ="B??n??vole";
        String prenomx="B??n??vole";
        clienthbluxx.setNom(nomx);
        clienthbluxx.setPrenom(prenomx);
        clienthbluxx.setEmail(nomx+prenomx+"@hblux.fr");
         clienthbluxx.setSexe("enfant");
        clienthbluxx.setMotDePasse(nomx);
        clienthbluxRepository.save(clienthbluxx);
        for (int i = 0; i < 2; i++) {
            Clienthblux clienthblux=new Clienthblux();
            String nom =RandomString.make(10);
            String prenom=RandomString.make(10);
            clienthblux.setNom(nom);
            clienthblux.setPrenom(prenom);
            clienthblux.setEmail(nom+prenom+"@hblux.fr");
            if((i/2)==0) clienthblux.setSexe("masculin");
            else  clienthblux.setSexe("feminin");
            clienthblux.setMotDePasse(nom);
            clienthbluxRepository.save(clienthblux);

        }
        System.out.println("Client rajout??s");
    }

    public void addCommande(){
        for (long i = 0; i < 3; i++) {
            Commande commande=new Commande();
            commande.setDateCommande(LocalDate.now());
            commande.setDateLivraison(LocalDate.now());
            commande.setCote("HB"+i+"2022");
            commandeRepository.save(commande);

        }
    }

    public void addReservation(){
        for (long i = 0; i < 2; i++) {
            Reservation reservation=new Reservation();
            reservation.setDateReservation(LocalDate.now());
            reservation.setDateFacturation(LocalDate.now());

            reservation.setCote("HB"+i+"2022");
            reservationRepository.save(reservation);

        }
    }


    public void addArticleToCommande(){
        long k=0;long id1=1;
        Commande commande=commandeRepository.findById(id1).get();
        for (long j = 1; j < 3; j++) {

            ArticleCommandee articleCommandee= articleCommandeeRepository.findById(j).get();
            articleCommandee.setCommande(commande);

            articleCommandeeRepository.save(articleCommandee);
        }
        long id2=2;
        Commande commande2=commandeRepository.findById(id2).get();
        for (long j = 3; j < 5; j++) {

            ArticleCommandee articleCommandee= articleCommandeeRepository.findById(j).get();
            articleCommandee.setCommande(commande2);

            articleCommandeeRepository.save(articleCommandee);
        }long id3=3;
        Commande commande3=commandeRepository.findById(id3).get();
        long j=5;
        ArticleCommandee articleCommandee= articleCommandeeRepository.findById(j).get();
        articleCommandee.setCommande(commande3);

        articleCommandeeRepository.save(articleCommandee);


        System.out.println("Article command??es !");
    }
    public void addArticleToReservation(){
        long k=1;
        Reservation reservation =reservationRepository.findById(k).get();
        long id=4;
        ArticleCommandee articleCommandee= articleCommandeeRepository.findById(id).get();
        articleCommandee.setReservation(reservation);

        articleCommandeeRepository.save(articleCommandee);


        long k2=2;
        Reservation reservation2 =reservationRepository.findById(k2).get();
        long id2=5;
        ArticleCommandee articleCommandee2= articleCommandeeRepository.findById(id2).get();
        articleCommandee.setReservation(reservation2);

        articleCommandeeRepository.save(articleCommandee2);

        System.out.println("Article command??es !");
    }
    public void addCommandeToClient(){
        long i=1;
        Clienthblux clienthblux =clienthbluxRepository.findById(i).get();
        for (long j = 1; j < 3; j++) {

            Commande commande= commandeRepository.findById(j).get();
            commande.setClienthblux(clienthblux);

            commandeRepository.save(commande);
        }

        System.out.println("Article command??es !");
    }

    public void addReservationToClient(){
        long id=2;
        Clienthblux clienthblux =clienthbluxRepository.findById(id).get();
        for (long j = 1; j < 2; j++) {

            Reservation reservation= reservationRepository.findById(j).get();
            reservation.setClienthblux(clienthblux);

            reservationRepository.save(reservation);
        }

        System.out.println("Reservation to client !");
    }


}
