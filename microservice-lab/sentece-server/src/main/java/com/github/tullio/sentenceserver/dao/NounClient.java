package com.github.tullio.sentenceserver.dao;

import com.github.tullio.sentenceserver.domain.Word;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("NOUN")
public interface NounClient {
    @GetMapping("/")
    Word getWord();
}
