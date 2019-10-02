package com.revature;

import java.util.List;

import com.revature.beans.Flashcard;
import com.revature.dao.FlashcardDAO;
import com.revature.dao.FlashcardDAOImpl;

public class Driver {

	public static void main(String[] args) {
		//System.out.println(ConnectionUtil.getSessionFactory());
		//SessionFactory sf = ConnectionUtil.getSessionFactory();
		//Session s = sf.openSession();
		//System.out.println(s.getStatistics());
		//s.close();
		
		FlashcardDAO fd = new FlashcardDAOImpl();
		String question = "What is your name?";
		List<Flashcard> fd2 = fd.getByQuestion(question);
		for (Flashcard f : fd2) {
			System.out.println(f);
		}
		//f.setId(4);
		// fd.addFlashcard(f);
		//fd.deleteFlashcard(f);
		// fd.addFlashcard(new Flashcard("What is the answer to life, the universe, and everything?", "42"));
		//for(Flashcard f : fd.getAll()) {
		//	System.out.println(f);
		//}
	}

}
