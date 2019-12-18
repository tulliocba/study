package com.github.tullio.sentenceserver.service;

import com.github.tullio.sentenceserver.dao.*;
import com.github.tullio.sentenceserver.domain.Word;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordServiceImpl implements WordService {

	@Autowired
	VerbClient verbClient;
	@Autowired
	SubjectClient subjectClient;
	@Autowired
	ArticleClient articleClient;
	@Autowired
	AdjectiveClient adjectiveClient;
	@Autowired
	NounClient nounClient;
	
	
	@Override
	public Word getSubject() {
		return subjectClient.getWord();
	}
	
	@Override
	public Word getVerb() {
		return verbClient.getWord();
	}
	
	@Override
	public Word getArticle() {
		return articleClient.getWord();
	}
	
	@Override
	@HystrixCommand(fallbackMethod = "getFallbackAdjective")
	public Word getAdjective() {
		return adjectiveClient.getWord();
	}
	public Word getFallbackAdjective() {
		return new Word("");
	}
	
	@Override
	public Word getNoun() {
		return nounClient.getWord();
	}	
}