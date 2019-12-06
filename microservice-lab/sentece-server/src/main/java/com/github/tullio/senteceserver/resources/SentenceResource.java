package com.github.tullio.senteceserver.resources;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

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
