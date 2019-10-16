package com.revature.service;

import java.util.List;

import javax.jws.WebService;

import com.revature.exception.StudyException;
import com.revature.model.Flashcard;

@WebService
public interface StudySetService {

	List<Flashcard> getAllFlashcards();
	public String addFlashcard(Flashcard flashcard) throws StudyException;
	
}
