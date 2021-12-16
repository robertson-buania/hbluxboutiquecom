package com.buania.buanialaxtechhblux;

import com.buania.buanialaxtechhblux.article.Article;

import com.buania.buanialaxtechhblux.articlecommandee.ArticleCommandee;
import com.buania.buanialaxtechhblux.articlecommandee.ArticleCommandeeRepository;
import com.buania.buanialaxtechhblux.commande.Commande;
import com.buania.buanialaxtechhblux.commande.CommandeRepository;
import com.buania.buanialaxtechhblux.hbluxclient.Clienthblux;
import com.buania.buanialaxtechhblux.hbluxclient.ClienthbluxRepository;
import com.buania.buanialaxtechhblux.livraison.Livraison;
import com.buania.buanialaxtechhblux.livraison.LivraisonRepository;
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
    LivraisonRepository livraisonRepository;
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
        articlesList.add("hblog.jpg");articlesList.add("képi.jpg");articlesList.add("bras.jpg");
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




            articleEnregistrer();

            System.out.println("******************************************************");
            System.out.println("************ HB EVENT **************");

            System.out.println("******************************************************");
            System.out.println("************** HB MEDIA ****************");
            addMedia();
            System.out.println("Empilement !");
            empilerMediaDansArticler();
          System.out.println("fghjklmù");
            System.out.println("dfghjkl");

            addArticleCommandee();
            addClient();
            addCommande();
            addLivraison();
            addReservation();

            addArticleToCommande();
            addArticleToReservation();
            addCommandeToClient();
            addReservationToClient();
            addLivraisonToCommande();



            
        };


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
        System.out.println("Enregistrement Media terminé !");
       /* hbMediaRepository.findAll().forEach(hbmedia -> {
            Article article=articleRepository.findById(hbmedia.getId()).get();
            Hbevent hbevent=hbEventsRepository.findById(hbmedia.getId()).get();
            hbmedia.setArticle(article);
            hbmedia.setHbevent(hbevent);
            System.out.println("Mis en jour éffectué !");
            hbMediaRepository.save(hbmedia);

        });

        */


    }
    public void articleEnregistrer(){
        Article article =new Article();
        article.setQuantite(random.nextInt(10));
        article.setPromotion(true);
        article.setPrix(45+0.0);
        article.setNom("Ensemble Jogging");
        article.setDescription("Sweat en molleton de coton mélangé. Coupe décontractée avec capuche doublée resserrable par cordon, manches longues et poche kangourou." +
                " Finition bord-côte aux poignets et à la base. Intérieur doux et brossé.\n " +
                "\n\n Composition de la couche extérieure:Coton 60%,Polyster 40%\n \n" +
                "\n\nDoublure de capuche:Coton 60%, Poluster 40%\n" +
                "");
        article.setType("enfant");
        article.setDisponible(true);
        Article articleEnregistre=articleRepository.save(article);
        System.out.println("Enregistrement de l'article terminé !");

       /* Article article2 =new Article();
        article2.setQuantite(random.nextInt(10));
        article2.setPromotion(true);
        article2.setPrix(45+0.0);
        article2.setNom("Bas Jogging");
        article2.setDescription("Sweat en molleton de coton mélangé. Coupe décontractée avec capuche doublée resserrable par cordon, manches longues et poche kangourou." +
                " Finition bord-côte aux poignets et à la base. Intérieur doux et brossé.");
        article2.setType("enfant");
        article2.setDisponible(true);
        Article articleEnregistre2=articleRepository.save(article2);
        System.out.println("Enregistrement de l'article terminé !");

        Article article3 =new Article();
        article3.setQuantite(random.nextInt(10));
        article3.setPromotion(true);
        article3.setPrix(45+0.0);
        article3.setNom("Complet jogging");
        article3.setDescription("Sweat en molleton de coton mélangé. Coupe décontractée avec capuche doublée resserrable par cordon, manches longues et poche kangourou." +
                " Finition bord-côte aux poignets et à la base. Intérieur doux et brossé.");
        article3.setType("enfant");
        article3.setDisponible(true);
        Article articleEnregistre3=articleRepository.save(article3);
        System.out.println("Enregistrement de l'article terminé !");*/
     /*    for (int i = 0; i < 9; i++) {


            System.out.println(articleEnregistre.toString());
        }

      */

    }

   /*  public void addHbEvent(){
        for (int i = 0; i < 5; i++) {
            Hbevent hbevent=new Hbevent();
            hbevent.setDescription(RandomString.make());
            hbevent.setTitre(RandomString.make(16));
           Hbevent hbevent1= hbEventsRepository.save(hbevent);
           System.out.println(hbevent1.toString());

        }
        System.out.println("Enregistrement Events Terminé !");
    } */

    public void empilerMediaDansArticler(){
        long id=1;
        Article article=articleRepository.findById(id).get();
            
       for (long j = 1; j <6; j++) {

        Hbmedia hbmedia= hbMediaRepository.findById(j).get();
        hbmedia.setArticle(article);
        System.out.println("Mis en jour  éffectué !");
        hbMediaRepository.save(hbmedia);
    }
   /* long id2=2;
    Article article1=articleRepository.findById(id2).get();
    for (long j = 4; j <7; j++) {

        Hbmedia hbmedia= hbMediaRepository.findById(j).get();
        hbmedia.setArticle(article1);
        System.out.println("Mis en jour  éffectué !");
        hbMediaRepository.save(hbmedia);
    }
    long id3=1;
    Article article3=articleRepository.findById(id3).get();
    for (long j = 7; j <10; j++) {

        Hbmedia hbmedia= hbMediaRepository.findById(j).get();
        hbmedia.setArticle(article3);
        System.out.println("Mis en jour  éffectué !");
        hbMediaRepository.save(hbmedia);
    }

    */
        /*long k=0;
        for (long i = 0; i < articleRepository.findAll().size(); i++) {
            Article article=articleRepository.findById(i+1).get();
            for (long j = 1; j < 4; j++) {

                Hbmedia hbmedia= hbMediaRepository.findById(k+j).get();
                hbmedia.setArticle(article);
                System.out.println("Mis en jour                 éffectué !");
                hbMediaRepository.save(hbmedia);
            }
           k+=3;
        }
        */
           System.out.println("Empilement terminé !");
        

       /* AtomicLong i= new AtomicLong(1);
        articleRepository.findAll().forEach(article -> {

            Hbmedia hbmedia=hbMediaRepository.findById(i.get()).get();
            hbmedia.setArticle(article);
            Hbmedia hbmedia1=  hbMediaRepository.save(hbmedia);
            System.out.println("******************************************************");
            System.out.println("******************************************************");
            System.out.println("******************************************************");
            System.out.println(hbmedia1.toString());
            i.getAndIncrement();


        });

        */
        

    }
   /*  public void empilementMediaDansEvents(){
        for (long i = 0; i <5 ; i++) {
            Hbmedia hbmedia=hbMediaRepository.findById(7+i).get();
            Hbevent hbevent=hbEventsRepository.findById(1+i).get();
            //hbmedia.setHbevent(hbevent);
            hbevent.setHbmedia(hbmedia);
            System.out.println("Mis en jour éffectué ! Evennnnnnnnnnnnt");
            hbEventsRepository.save(hbevent);
            System.out.println("Mis en jour é  cxjcfectué !");
        }
    } */

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
        for (int i = 0; i < 3; i++) {
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
        System.out.println("Client rajoutés");
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
    public void addLivraison(){
        for (long i = 0; i < 5; i++) {
            Livraison livraison=new Livraison();
            livraison.setNumero("HBLUX"+i+"2020");
            livraison.setPays("France");
            livraison.setReference(RandomString.make(10));
            livraison.setRue(RandomString.make(10));
            livraison.setVille(RandomString.make(10));
            livraisonRepository.save(livraison);

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


        System.out.println("Article commandées !");
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

        System.out.println("Article commandées !");
    }
    public void addCommandeToClient(){
        long i=1;
          Clienthblux clienthblux =clienthbluxRepository.findById(i).get();
            for (long j = 1; j < 3; j++) {

                Commande commande= commandeRepository.findById(j).get();
                commande.setClienthblux(clienthblux);

                commandeRepository.save(commande);
            }

        System.out.println("Article commandées !");
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

    public void addLivraisonToCommande(){
        for (long i = 0; i < commandeRepository.findAll().size(); i++) {
            Commande commande=commandeRepository.findById(i+1).get();
            Livraison livraison=livraisonRepository.findById(i+1).get();
            commande.setLivraison(livraison);
            commandeRepository.save(commande);
        }
        System.out.println("Commande Livrée Livraison terminé");
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
