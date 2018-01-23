package fr.esigelec.projetSpring.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "quiz")
public class Quiz implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // pour les ID en auto incrément
	@Column(name = "idquiz")
	private int idQuiz;

	@Column(name = "libelle")
	private String libelle;

	@Column(name = "etat")
	private int etat;

	@Column(name = "dateDebutQuiz")
	private java.sql.Timestamp dateDebutQuiz;

	@Column(name = "noQuestionCourante")
	private int noQuestionCourante;

	@Column(name = "etape")
	private int etape;

	@Column(name = "dateDebutQuestion")
	private java.sql.Timestamp dateDebutQuestion;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "quiz_question", joinColumns = { @JoinColumn(name = "id_quiz") }, inverseJoinColumns = {
			@JoinColumn(name = "id_question") })
	private List<Question> questions;

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Quiz() {
	}

	public Quiz(String libelle, int etat, java.sql.Timestamp dateDebutQuiz, int noQuestionCourante, int etape,
			java.sql.Timestamp dateDebutQuestion, List<Question> questions) {
		super();
		this.libelle = libelle;
		this.etat = etat;
		this.dateDebutQuiz = dateDebutQuiz;
		this.noQuestionCourante = noQuestionCourante;
		this.etape = etape;
		this.dateDebutQuestion = dateDebutQuestion;
		this.questions = questions;
	}

	public int getIdQuiz() {
		return idQuiz;
	}

	public void setIdQuiz(int idQuiz) {
		this.idQuiz = idQuiz;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public int getNoQuestionCourante() {
		return noQuestionCourante;
	}

	public void setNoQuestionCourante(int noQuestionCourante) {
		this.noQuestionCourante = noQuestionCourante;
	}

	public int getEtape() {
		return etape;
	}

	public void setEtape(int etape) {
		this.etape = etape;
	}

	public java.sql.Timestamp getDateDebutQuiz() {
		return dateDebutQuiz;
	}

	public void setDateDebutQuiz(java.sql.Timestamp dateDebutQuiz) {
		this.dateDebutQuiz = dateDebutQuiz;
	}

	public java.sql.Timestamp getDateDebutQuestion() {
		return dateDebutQuestion;
	}

	public void setDateDebutQuestion(java.sql.Timestamp dateDebutQuestion) {
		this.dateDebutQuestion = dateDebutQuestion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateDebutQuestion == null) ? 0 : dateDebutQuestion.hashCode());
		result = prime * result + ((dateDebutQuiz == null) ? 0 : dateDebutQuiz.hashCode());
		result = prime * result + etape;
		result = prime * result + etat;
		result = prime * result + idQuiz;
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		result = prime * result + noQuestionCourante;
		result = prime * result + ((questions == null) ? 0 : questions.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quiz other = (Quiz) obj;
		if (dateDebutQuestion == null) {
			if (other.dateDebutQuestion != null)
				return false;
		} else if (!dateDebutQuestion.equals(other.dateDebutQuestion))
			return false;
		if (dateDebutQuiz == null) {
			if (other.dateDebutQuiz != null)
				return false;
		} else if (!dateDebutQuiz.equals(other.dateDebutQuiz))
			return false;
		if (etape != other.etape)
			return false;
		if (etat != other.etat)
			return false;
		if (idQuiz != other.idQuiz)
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		if (noQuestionCourante != other.noQuestionCourante)
			return false;
		if (questions == null) {
			if (other.questions != null)
				return false;
		} else if (!questions.equals(other.questions))
			return false;
		return true;
	}

}
