package fr.esigelec.projetSpring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="ranking")
public class Ranking implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_personne")
	private int personneID;
	
	@Id
	@Column(name="id_quiz")
	private int quizID;
	
	@Column(name ="participant")
	private String participant;
	
	@Column(name ="score")
	private int score;
	
	public Ranking(){
		
	}


	public Ranking(int personneID, int quizID, String participant, int score) {
		super();
		this.personneID = personneID;
		this.quizID = quizID;
		this.participant = participant;
		this.score = score;
	}

	public String getParticipant() {
		return participant;
	}

	public void setPrenom(String participant) {
		this.participant = participant;
	}


	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
