package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.Flashcard;
import com.revature.util.ConnectionUtil;

public class FlashcardDAOImpl implements FlashcardDAO {

	private SessionFactory sf = ConnectionUtil.getSessionFactory();

	@Override
	public Flashcard getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Flashcard> getAll() {
		List<Flashcard> flashcardList = new ArrayList<>();
		try (Session s = sf.openSession()) {
			flashcardList = s.createQuery("from Flashcard").getResultList();
		}
		return flashcardList;
	}

	@Override
	public boolean addFlashcard(Flashcard flashcard) {
		boolean isAdded = false;
		try (Session s = sf.openSession()) {
			// autocommit is OFF in Hibernate
			Transaction tx = s.beginTransaction();
			s.persist(flashcard);
			tx.commit();
			isAdded = true;
		}
		return isAdded;
	}

	@Override
	public boolean updateFlashcard(Flashcard flashcard) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteFlashcard(Flashcard flashcard) {
		// TODO Auto-generated method stub
		return false;
	}

}
