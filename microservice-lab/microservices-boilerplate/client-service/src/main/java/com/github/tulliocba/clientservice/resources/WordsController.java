package com.github.tulliocba.clientservice.resources;

import com.github.tulliocba.clientservice.Word;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class WordsController {
    private final Random random = new Random();

    @Value("${words}")
    private String[] words;

    @GetMapping("/")
    @ResponseBody
    public Word getWord() {
        return new Word(words[random.nextInt(words.length)]);
    }

}
