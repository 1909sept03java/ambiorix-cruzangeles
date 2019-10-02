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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TOPIC")
public class Topic {

	private int id;
	private String topicName;

	private Set<Flashcard> flashcards; // many flashcard for one topic

	public Topic(String topicName) {
		super();
		this.topicName = topicName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "topicSequence")
	@SequenceGenerator(allocationSize = 1, name = "topicSequence", sequenceName = "TOPIC_SEQUENCE_PK")
	@Column(name = "TOPIC_ID")
	public int getTopicId() {
		return id;
	}

	public void setTopicId(int topicId) {
		this.id = topicId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	// one topic to many flashcards
	@OneToMany(cascade = CascadeType.ALL)
	// middle man, joins the id from flashcard_id and topic_id
	@JoinTable(name = "FLASHCARD_TOPIC",
	joinColumns = @JoinColumn(name = "TOPIC_ID"),
	inverseJoinColumns = @JoinColumn(name = "FLASHCARD_ID"))
	public Set<Flashcard> getFlashcards() {
		return flashcards;
	}
	public void setFlashcards(Set<Flashcard> flashcards) {
		this.flashcards = flashcards;
	}

}
