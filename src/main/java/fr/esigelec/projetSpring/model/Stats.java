package fr.esigelec.projetSpring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="stats")
public class Stats implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "id_proposition")
	private int propositionID;
	
	@Id
	@Column(name="id_quiz")
	private int quizID;
	
	@Column(name ="numeroQuestion")
	private int numeroQuestion;
	
	@Column(name ="nombre")
	private int nombre;
	
	public Stats(){}
	
	public Stats(int propositionID, int quizID, int numeroQuestion, int nombre) {
		super();
		this.propositionID = propositionID;
		this.quizID = quizID;
		this.numeroQuestion = numeroQuestion;
		this.nombre = nombre;
	}

	public int getPropositionID() {
		return propositionID;
	}

	public void setPropositionID(int propositionID) {
		this.propositionID = propositionID;
	}

	public int getQuizID() {
		return quizID;
	}

	public void setQuizID(int quizID) {
		this.quizID = quizID;
	}

	public int getNumeroQuestion() {
		return numeroQuestion;
	}

	public void setNumeroQuestion(int numeroQuestion) {
		this.numeroQuestion = numeroQuestion;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	
	

}
