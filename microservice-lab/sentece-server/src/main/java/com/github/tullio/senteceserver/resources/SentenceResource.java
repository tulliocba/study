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
    private DiscoveryClient client;
    @GetMapping("/sentence")
    public @ResponseBody String getSentence() {
        return getWord("subject-server".toUpperCase()) + " "
                + getWord("verb-server".toUpperCase()) + " "
                + getWord("article-server".toUpperCase()) + " "
                + getWord("adjective-server".toUpperCase()) + " "
                + getWord("noun-server".toUpperCase()) + "."
                ;
    }

    public String getWord(String service) {
        List<ServiceInstance> list = client.getInstances(service);
        if (list != null && list.size() > 0 ) {
            URI uri = list.get(0).getUri();
            if (uri !=null ) {
                return (new RestTemplate()).getForObject(uri,String.class);
            }
        }
        return null;
    }
}
