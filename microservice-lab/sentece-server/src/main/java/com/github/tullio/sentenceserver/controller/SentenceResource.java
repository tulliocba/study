package com.github.tullio.sentenceserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SentenceResource {
    @Autowired
    private RestTemplate client;

    @GetMapping("/sentence")
    public @ResponseBody
    String getSentence() {
        return getWord("subject-service".toUpperCase()) + " "
                + getWord("verb-service".toUpperCase()) + " "
                + getWord("article-service".toUpperCase()) + " "
                + getWord("adjective-service".toUpperCase()) + " "
                + getWord("noun-service".toUpperCase()) + "."
                ;
    }

    public String getWord(String service) {
        return client.getForObject("http://" + service, String.class);
    }
}
