package com.github.tullio.sentenceserver.dao;

import com.github.tullio.sentenceserver.domain.Word;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("VERB-SERVICE")
public interface VerbClient {
    @GetMapping("/")
    Word getWord();
}
