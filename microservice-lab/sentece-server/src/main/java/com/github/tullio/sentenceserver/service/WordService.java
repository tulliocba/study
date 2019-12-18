package com.github.tullio.sentenceserver.service;

import com.github.tullio.sentenceserver.domain.Word;

public interface WordService {

	Word getSubject();
	Word getVerb();
	Word getArticle();
	Word getAdjective();
	Word getNoun();
	
}