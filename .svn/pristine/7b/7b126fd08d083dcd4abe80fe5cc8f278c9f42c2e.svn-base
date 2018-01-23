package fr.esigelec.projetSpring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "proposition")
public class Proposition implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //pour les ID en auto incrément
	@Column(name = "idproposition")
	private int idProposition;
	
	@Column(name = "libelle")
	private String libelle;
	
	
	@Column(name = "bonneReponse")
	private boolean bonneReponse;
	
	@ManyToOne(targetEntity = Question.class)
	@JoinColumn(name = "numeroQuestion")
	private Question question;

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Proposition(){}

	public Proposition(int idProposition, String libelle, boolean bonneReponse) {
		super();
		this.idProposition = idProposition;
		this.libelle = libelle;
		this.bonneReponse = bonneReponse;
	}

	public int getIdProposition() {
		return idProposition;
	}

	public void setIdProposition(int idProposition) {
		this.idProposition = idProposition;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public boolean isBonneReponse() {
		return bonneReponse;
	}

	public void setBonneReponse(boolean bonneReponse) {
		this.bonneReponse = bonneReponse;
	}
	
}