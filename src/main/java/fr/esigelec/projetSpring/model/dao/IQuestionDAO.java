package fr.esigelec.projetSpring.model.dao;

import java.util.List;

import fr.esigelec.projetSpring.model.Question;

public interface IQuestionDAO {
	
	public List<Question> getListeQuestion();
	
	public Question getQuestion(int id);
		
	//public void ajouterQuestion(Question q);
	
	//public void majQuestion(Question q);
	
	//public void supprimerQuestion(Question q);
}
