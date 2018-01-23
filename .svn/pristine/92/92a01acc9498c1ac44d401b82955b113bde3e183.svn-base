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
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "question")
public class Question implements Serializable {
	
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //pour les ID en auto incrément
	@Column(name = "idquestion")
	private int idQuestion;
	
	@Column(name = "libelle")
	private String libelle;
	
	@OneToMany(mappedBy="question",fetch = FetchType.EAGER)
	private List<Proposition> propositions;
	
	public Question(){}
	
	public Question(int idQuestion, String libelle) {
		super();
		this.idQuestion = idQuestion;
		this.libelle = libelle;
	}
	

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "numeroQuestion")
	public int getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}

	public List<Proposition> getPropositions() {
		return propositions;
	}

	public void setPropositions(List<Proposition> propositions) {
		this.propositions = propositions;
	}

	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
