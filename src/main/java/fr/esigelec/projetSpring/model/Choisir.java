package fr.esigelec.projetSpring.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;


@Entity
@Table(name = "choisir")
@AssociationOverrides({
    @AssociationOverride(name = "personne", 
        joinColumns = @JoinColumn(name = "idpersonne")),
    @AssociationOverride(name = "quiz", 
        joinColumns = @JoinColumn(name = "idquiz")),
    @AssociationOverride(name = "proposition", 
    joinColumns = @JoinColumn(name = "idproposition"))})
public class Choisir {

	@Column(name = "date")
	private java.sql.Timestamp date;

	private Personne personne;
	private Quiz quiz;
	private Proposition proposition;

	public Choisir() {
	}

	
	public Choisir(Timestamp date, Personne personne, Quiz quiz, Proposition proposition) {
		super();
		this.date = date;
		this.personne = personne;
		this.quiz = quiz;
		this.proposition = proposition;
	}



	public java.sql.Timestamp getDate() {
		return date;
	}


	public void setDate(java.sql.Timestamp date) {
		this.date = date;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Proposition getProposition() {
		return proposition;
	}

	public void setProposition(Proposition proposition) {
		this.proposition = proposition;
	}

}
