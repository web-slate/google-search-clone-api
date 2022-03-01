package com.gsearch.api;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.gsearch.dto.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class gsearchController {

    /**
     *
     * @param searchterm
     * @return
     * @throws JsonProcessingException
     */
    @GetMapping(value = "/search")
    public ResponseEntity<?> search(@RequestParam String searchterm) throws JsonProcessingException {
        List<Data> searchResponse =  testData();
        Optional<Data> matchingObject = searchResponse.stream().
                filter(p -> p.getTitle().equals(searchterm)).
                findFirst();
        Data responseData = matchingObject.get();
        return ResponseEntity.ok().body(responseData);
    }


    public List<Data> testData(){
        List<Data> searchResponse = new ArrayList<>();
        Data obj = new Data();
        obj.setTitle("google");
        obj.setContent("Search the world's information, including webpages, images, videos and more. Google has many special features to help you find exactly what you're looking");
        obj.setUrl("www.google.com");
        searchResponse.add(obj);
        obj = new Data();
        obj.setTitle("facebook");
        obj.setContent("Create an account or log into Facebook. Connect with friends, family and other people you know. Share photos and videos, send messages and get updates.");
        obj.setUrl("https://www.facebook.com/");
        searchResponse.add(obj);
        obj = new Data();
        obj.setTitle("whatsapp web");
        obj.setContent("Quickly send and receive WhatsApp messages right from your computer");
        obj.setUrl("https://web.whatsapp.com/");
        searchResponse.add(obj);
        obj = new Data();
        obj.setTitle("whatsapp web");
        obj.setContent("Quickly send and receive WhatsApp messages right from your computer");
        obj.setUrl("https://web.whatsapp.com/");
        searchResponse.add(obj);
        obj = new Data();
        obj.setTitle("youtube");
        obj.setContent("Enjoy the videos and music you love, upload original content, and share it all with friends, family, and the world on YouTube.");
        obj.setUrl("https://www.youtube.com/");
        searchResponse.add(obj);
        obj = new Data();
        obj.setTitle("gmail");
        obj.setContent("No information is available for this page.");
        obj.setUrl("https://mail.google.com/");
        searchResponse.add(obj);
        obj = new Data();
        obj.setTitle("amazon");
        obj.setContent("Free shipping on millions of items. Get the best of Shopping and Entertainment with Prime. Enjoy low prices and great deals on the largest selection");
        obj.setUrl("https://www.amazon.com/");
        searchResponse.add(obj);
        obj = new Data();
        obj.setTitle("google translate");
        obj.setContent("Google's free service instantly translates words, phrases, and web pages between English and over 100 other languages.");
        obj.setUrl("https://translate.google.com/");
        searchResponse.add(obj);
        obj = new Data();
        obj.setTitle("tranductor");
        obj.setContent("Este servicio gratuito de Google traduce instantáneamente palabras, frases y páginas web del español a más de 100 idiomas y viceversa.");
        obj.setUrl("https://translate.google.com/");
        searchResponse.add(obj);
        obj = new Data();
        obj.setTitle("hotmail");
        obj.setContent("Get free Outlook email and calendar, plus Office Online apps like Word, Excel and PowerPoint. Sign in to access your Outlook, Hotmail or Live email account.");
        obj.setUrl("https://outlook.live.com/owa/");
        searchResponse.add(obj);

        return searchResponse;
    }

}
