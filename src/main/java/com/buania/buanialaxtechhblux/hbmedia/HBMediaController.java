package com.buania.buanialaxtechhblux.hbmedia;

import com.buania.buanialaxtechhblux.article.Article;
import com.buania.buanialaxtechhblux.article.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("media")
@CrossOrigin("*")
public class HBMediaController  {

    @Autowired
    private HBMediaRepository hbMediaRepository;
    @Autowired
    private ArticleRepository articleRepository;
    private List <String> urlsPhoto=new ArrayList<>();

    public  static String uploadDirectory=System
            .getProperty("user.home")+"/Downloads/ROBERTS/website/hblux front/src/assets/images";

    public HBMediaController (){

    }

    @GetMapping("all")
    public List<Hbmedia> getAllHbmedia(){
        return hbMediaRepository.findAll();
    }

    @GetMapping("byarticle")
    public List<Hbmedia> getAllHbmediaByArticle(@PathVariable long id){

        Article article=articleRepository.findById(id).get();
        return hbMediaRepository.findAllByArticle(article);
    }

    @PostMapping("new")
    public Hbmedia createHbmedia(@RequestBody Hbmedia hbmedia){
        return hbMediaRepository.save(hbmedia);
    }

    @PutMapping("edit")
    public Hbmedia updateHbmedia(@RequestBody Hbmedia hbmediaUpdate){

        return hbMediaRepository.save(hbmediaUpdate);
    }


    
    @PutMapping(path = "uploadPhoto/{id}")
    public Hbmedia uploadPhoto(MultipartFile file, @PathVariable Long id) throws Exception{
       Hbmedia media=hbMediaRepository.findById(id).get();
       System.out.println(file);
       media.setMediaUrl(file.getOriginalFilename());
       // Files.write(Paths.get(System.getProperty("user.home")+"/ecom/products/",file.getBytes());
      // Files.write(Paths.get(System.getProperty("user.home")+"/Downloads/ROBERTS/website/hblux front/src/assets/images"+media.setMediaUrl(file.getOriginalFilename())),file.getBytes());

        Path fileNameAndPath= Paths.get(uploadDirectory,file.getOriginalFilename());

        try {
            Files.write(fileNameAndPath,file.getBytes());
            return hbMediaRepository.save(media);
        } catch (IOException e) {
            return null;
        }


    }
}
