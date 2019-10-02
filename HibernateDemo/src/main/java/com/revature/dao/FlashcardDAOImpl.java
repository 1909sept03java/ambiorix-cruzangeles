package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
			System.out.println(s.getStatistics());
		}
		return flashcardList;
	}

	@Override
	public boolean addFlashcard(Flashcard flashcard) {
		boolean isAdded = false;
		// try with resources on an AutoCloseable resource, closes at thend of control
		try (Session s = sf.openSession()) {
			// autocommit is OFF in Hibernate
			Transaction tx = s.beginTransaction();
			
			s.persist(flashcard);
			System.out.println(s.getStatistics());
			tx.commit();
			isAdded = true;
		}
		return isAdded;
	}

	@Override
	public boolean updateFlashcard(Flashcard flashcard, String answer) {
		boolean isUpdated = false;
		// try with resources on an AutoCloseable resource, closes at thend of control
		try (Session s = sf.openSession()) {
			// autocommit is OFF in Hibernate
			Transaction tx = s.beginTransaction();
			String queryStr = "Update Flashcard Set FLASHCARD_ANSWER = :answer Where FLASHCARD_ID = :id";
			Query query = s.createQuery(queryStr);
			query.setParameter("answer", answer);
			query.setParameter("id", flashcard.getId());
			query.executeUpdate();
			// s.persist(flashcard);
			// System.out.println(s.getStatistics());
			tx.commit();
			isUpdated = true;
		}
		return isUpdated;
	}

	@Override
	public boolean deleteFlashcard(Flashcard flashcard) {
		boolean isDeleted = false;
		// try with resources on an AutoCloseable resource, closes at thend of control
		try (Session s = sf.openSession()) {
			// autocommit is OFF in Hibernate
			Transaction tx = s.beginTransaction();
			String queryStr = "Delete from Flashcard Where FLASHCARD_ID = :id";
			Query query = s.createQuery(queryStr);
			query.setParameter("id", flashcard.getId());
			query.executeUpdate();
			// s.persist(flashcard);
			// System.out.println(s.getStatistics());
			tx.commit();
			isDeleted = true;
		}
		return isDeleted;
	}

	@Override
	public List<Flashcard> getByQuestion(String question) {
		List<Flashcard> flashcardList = new ArrayList<Flashcard>();
		// try with resources on an AutoCloseable resource, closes at thend of control
		try (Session s = sf.openSession()) {
			// autocommit is OFF in Hibernate
			//Transaction tx = s.beginTransaction();
			String queryStr = "from Flashcard Where FLASHCARD_QUESTION = :que";
			Query<Flashcard> query = s.createQuery(queryStr);
			query.setParameter("que", question);
			//tx.commit();
			flashcardList = query.list();
			// s.persist(flashcard);
			// System.out.println(s.getStatistics());
		}
		return flashcardList;
	}

}
