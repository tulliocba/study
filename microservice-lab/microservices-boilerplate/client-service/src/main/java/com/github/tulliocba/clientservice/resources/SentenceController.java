package com.github.tulliocba.clientservice.resources;

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
public class SentenceController {
    @Autowired
    DiscoveryClient client;

    @GetMapping("/sentence")
    @ResponseBody
    public String getSentence() {
        return String.format("%s %s %s %s %s.",
                getWord("SUBJECT-SERVICE"),
                getWord("VERB-SERVICE"),
                getWord("ARTICLE-SERVICE"),
                getWord("ADJECTIVE-SERVICE"),
                getWord("NOUN-SERVICE"));
    }

    public String getWord(String service) {
        List<ServiceInstance> list = client.getInstances(service);
        if (list != null && list.size() > 0) {
            URI uri = list.get(0).getUri();
            if (uri != null) {
                return (new RestTemplate()).getForObject(uri, String.class);
            }
        }
        return null;
    }
}
