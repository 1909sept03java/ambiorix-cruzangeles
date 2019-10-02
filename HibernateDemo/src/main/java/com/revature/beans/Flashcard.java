package com.revature.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "FLASHCARD")
public class Flashcard {

	private int id;
	private String question;
	private String answer;
	
	private Set<StudySet> studySets; // many flashcard for many study sets
	
	@Id // indicates that this is the primary key! ("persistence identity" of Flashcard)
	@Column(name = "FLASHCARD_ID")
	// SEQUENCE
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "flashcardSequence")
	// TRIGGER
	@SequenceGenerator(allocationSize = 1, name = "flashcardSequence", sequenceName = "FLASCARD_SEQUENCE_PK")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	
	
	public Flashcard(String question, String answer) {
		super();
		this.question = question;
		this.answer = answer;
	}
	
	
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "FLASHCARD_STUDY_SET", joinColumns = @JoinColumn(name = "FLASHCARD_ID"), inverseJoinColumns = @JoinColumn(name = "STUDY_SET_ID"))
	public Set<StudySet> getStudySets() {
		return studySets;
	}
	public void setStudySets(Set<StudySet> studySets) {
		this.studySets = studySets;
	}
	
}
