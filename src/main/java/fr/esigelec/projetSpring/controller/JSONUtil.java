package fr.esigelec.projetSpring.controller;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import fr.esigelec.projetSpring.donnees_de_test.DonneesQuiz;
import fr.esigelec.projetSpring.model.Personne;
import fr.esigelec.projetSpring.model.Quiz;
import fr.esigelec.projetSpring.model.dao.IQuizDAO;

public class JSONUtil {
	
	//private DonneesQuiz donneesQuiz = new DonneesQuiz();
	
	@Autowired
	private IQuizDAO quizDAO;
	
	public JSONObject getJSONPersonne(Personne personne){
		JSONObject jsonPersonne = new JSONObject();
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		
		if(personne != null) {
			json.put("Etat", "Oui");
			json.put("IdPersonne", personne.getIdPersonne());
			array.add(json);
			jsonPersonne.put("Connexion", array);
		} else {
			json.put("Etat", "Non");
			array.add(json);
			jsonPersonne.put("Connexion", array);
		}
		return jsonPersonne;
	}
	
	public JSONObject getJSONListQuiz(){
		List<Quiz> listQuiz = quizDAO.getListeQuiz();
		JSONObject jsonQuiz = new JSONObject();
		JSONArray array = new JSONArray();
		
		
		for(int i = 0; i<listQuiz.size(); i++){
			JSONObject json = new JSONObject();
			json.put("idQuiz", String.valueOf(listQuiz.get(i).getIdQuiz()));
			json.put("libelle", listQuiz.get(i).getLibelle().toString());
			json.put("etat", String.valueOf(listQuiz.get(i).getEtat()));
			json.put("dateDebutQuiz", listQuiz.get(i).getDateDebutQuiz());
			json.put("noQuestionCourante", String.valueOf(listQuiz.get(i).getNoQuestionCourante()));
			json.put("etape", String.valueOf(listQuiz.get(i).getEtape()));
			json.put("dateDebutQuestion", listQuiz.get(i).getDateDebutQuestion().toString());
			array.add(json);
		}
		
		jsonQuiz.put("Quiz", array);
		System.out.println(jsonQuiz.toJSONString());
		return jsonQuiz;
	}
	
	public JSONObject generateJSONResponse(List<JSONObject> json){
		JSONArray resultArray = new JSONArray();
		JSONObject resultJson = new JSONObject();
		
		for(int i = 0; i<json.size(); i++){
			resultArray.add(json.get(i));
		}
		resultJson.put("response", resultArray);
		return resultJson;
	}
}
