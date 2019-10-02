package com.revature;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.revature.beans.Flashcard;
import com.revature.beans.Topic;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		
		SessionFactory sf = ConnectionUtil.getSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		
		// one to many
		Topic topic = new Topic("Adventure");
		
		Flashcard flashcard = new Flashcard("Question?", "Answer.");
		Flashcard flashcard2 = new Flashcard("Question2?", "Answer2.");
		Flashcard flashcard3 = new Flashcard("Question3?", "Answer3.");
		
		Set<Flashcard> flashcards = new HashSet<>();
		
		flashcards.add(flashcard);
		flashcards.add(flashcard2);
		flashcards.add(flashcard3);
		
		topic.setFlashcards(flashcards);
		
		// hibernate stuff, similar to persist
		s.save(topic);
		
		
		s.getTransaction().commit();
		s.close();
		
		/*
		 * 
		 */
		
		// many to many
		/*
		 * 
		s.beginTransaction();
		StudySet studySet = new StudySet("set1");
		
		Set<StudySet> studySets = new HashSet<>();
		
		studySets.add(studySet);
		
		flashcard.setStudySets(studySets);
		studySet.setFlashcards(flashcards);

		s.save(flashcard);
		s.save(studySet);
		s.getTransaction().commit();
		s.close();
		 */
		
	}

}
