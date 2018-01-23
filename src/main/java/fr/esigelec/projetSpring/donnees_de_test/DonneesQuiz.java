package fr.esigelec.projetSpring.donnees_de_test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sun.jmx.snmp.Timestamp;

import fr.esigelec.projetSpring.model.Proposition;
import fr.esigelec.projetSpring.model.Question;
import fr.esigelec.projetSpring.model.Quiz;

public class DonneesQuiz {
	
	private List<Question> listeDeQuestion;
	private List<Quiz> listeDeQuiz;
	
	private void getQuestions(){
		
		listeDeQuestion = new ArrayList<Question>();
		for(int i = 0; i < 9; i++) {
			Question question = new Question();
			question.setIdQuestion(i+1);
			question.setLibelle("Question"+(i+1));
			
			List<Proposition> listeDesPropositions = new ArrayList<Proposition>();
			for(int j = 0; j < 4; j++) {
				Proposition proposition = new Proposition();
				proposition.setIdProposition(((i*4)+j));
				proposition.setLibelle("Proposition"+i+"_"+j);
				if(j == 2) {
					proposition.setBonneReponse(true);
				}else {
					proposition.setBonneReponse(false);
				}
				
				listeDesPropositions.add(proposition);
			}
			
			question.setPropositions(listeDesPropositions);
			
			listeDeQuestion.add(question);
		}
		
	}
	
	public List<Quiz> getListeQuiz() {
			
			List<Quiz> quiz = new ArrayList<Quiz>();
			java.sql.Timestamp timesTamp = new java.sql.Timestamp(12000000);
			getQuestions();
			
			for(int i = 0; i < 3; i++) {
				Quiz q = new Quiz();
				q.setIdQuiz(i+1);
				q.setLibelle("Quiz"+(i+1));
				q.setEtat(0);
				q.setEtape(1);
				q.setNoQuestionCourante(1);
				q.setDateDebutQuestion(timesTamp);
				q.setQuestions(listeDeQuestion);
				quiz.add(q);
			}
			return quiz;
	}
	
	public Quiz getQuiz(int id) {
		
		List<Quiz> quiz = new ArrayList<Quiz>();
		java.sql.Timestamp timesTamp = new java.sql.Timestamp(12000000);
		getQuestions();
		
		for(int i = 0; i < 3; i++) {
			Quiz q = new Quiz();
			q.setIdQuiz(i+1);
			q.setLibelle("Quiz"+(i+1));
			q.setEtat(0);
			q.setEtape(1);
			q.setNoQuestionCourante(1);
			q.setDateDebutQuestion(timesTamp);
			q.setQuestions(listeDeQuestion);
			quiz.add(q);
		}
		
		return quiz.get(id-1);
	}
}
