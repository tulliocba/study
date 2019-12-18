package com.github.tullio.sentenceserver.service;

import com.github.tullio.sentenceserver.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SentenceServiceImpl implements SentenceService {
    @Autowired WordService wordService;

    @Override
    public String buildSentence() {
        return
                String.format("%s %s %s %s %s.",
                        wordService.getSubject().getString(),
                        wordService.getVerb().getString(),
                        wordService.getArticle().getString(),
                        wordService.getAdjective().getString(),
                        wordService.getNoun().getString() )
                ;
    }
}
