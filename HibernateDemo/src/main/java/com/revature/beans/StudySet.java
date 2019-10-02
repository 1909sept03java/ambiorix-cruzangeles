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
@Table(name="STUDY_SET")
public class StudySet {
	
	private int id;
	private String studySetName;
	private Set<Flashcard> flashcards; // many flashcard for many topic
	
	public StudySet(String studySetName) {
		super();
		this.studySetName = studySetName;
	}
	
	@Id // indicates that this is the primary key!
	@GeneratedValue(strategy=GenerationType.AUTO, generator="studySetSequence")
	@SequenceGenerator(allocationSize=1, name="studySetSequence", sequenceName="STUDY_SET_SEQUENCE_PK")
	@Column(name="STUDY_SET_ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudySetName() {
		return studySetName;
	}
	public void setStudySetName(String studySetName) {
		this.studySetName = studySetName;
	}
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "FLASHCARD_STUDY_SET", joinColumns = @JoinColumn(name = "FLASHCARD_ID"), inverseJoinColumns = @JoinColumn(name = "STUDY_SET_ID"))
	public Set<Flashcard> getFlashcards() {
		return flashcards;
	}
	public void setFlashcards(Set<Flashcard> flashcards) {
		this.flashcards = flashcards;
	}
	
}
