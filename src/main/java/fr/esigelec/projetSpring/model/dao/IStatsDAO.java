package fr.esigelec.projetSpring.model.dao;
import java.util.List;
import fr.esigelec.projetSpring.model.*;

public interface IStatsDAO {

	public List <Stats> getStatistiquesQuestionCourante(int idQuiz);
	
}
