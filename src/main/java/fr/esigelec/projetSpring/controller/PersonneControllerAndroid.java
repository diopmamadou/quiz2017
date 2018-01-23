package fr.esigelec.projetSpring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.esigelec.projetSpring.donnees_de_test.DonneesQuiz;
import fr.esigelec.projetSpring.model.Personne;
import fr.esigelec.projetSpring.model.Quiz;
import fr.esigelec.projetSpring.model.dao.IPersonneDAO;
import fr.esigelec.projetSpring.model.dao.IQuizDAO;
import fr.esigelec.projetSpring.controller.JSONUtil;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@Controller
public class PersonneControllerAndroid {

	@Autowired
	private IPersonneDAO personneDAO;
	
	@Autowired
	private IQuizDAO quizDAO;
	
	private JSONUtil JSONUtil = new JSONUtil();
	
	@RequestMapping(value = "/ConnexionAndroid", method = RequestMethod.GET)
	@ResponseBody
	public String connexionPersonne(@RequestParam("mail") String mail, @RequestParam("mdp") String mdp ) {
		JSONArray resultArray = new JSONArray();
		JSONObject resultJson = new JSONObject();

		JSONObject JSONPersonne = new JSONObject();
		JSONObject JSONListQuiz = new JSONObject();;
		
		//on vérifie que l'utilisateur existe
		Personne personne = personneDAO.getPersonne(mail);
		if(personne!=null && personne.getMdp().equals(mdp)){
			JSONPersonne = JSONUtil.getJSONPersonne(personne);
			JSONListQuiz = JSONUtil.getJSONListQuiz();
		} else {
			JSONPersonne = JSONUtil.getJSONPersonne(null);
		}
		
		List<JSONObject> json = new ArrayList<JSONObject>();
		json.add(JSONPersonne);
		json.add(JSONListQuiz);
		return JSONUtil.generateJSONResponse(json).toJSONString();
		
		/*resultArray.add(JSONPersonne);
		resultArray.add(JSONListQuiz);
		resultJson.put("response", resultArray);
		return resultJson.toJSONString();*/
	}
	
	
	
	@RequestMapping(value = "/InscriptionAndroid", method = RequestMethod.GET)
	@ResponseBody
	public String inscriptionPersonne(@RequestParam("mail") String mail, @RequestParam("mdp") String mdp,
			@RequestParam("nom") String nom, @RequestParam("prenom") String prenom) {
		
		JSONObject JSONPersonne = new JSONObject();
		JSONObject JSONListQuiz = new JSONObject();
		int retour = -1;
		JSONArray resultArray = new JSONArray();
		JSONObject resultJson = new JSONObject();
		
		Personne p = new Personne();
		p.setPrenom(prenom);
		p.setNom(nom);
		p.setMail(mail);
		p.setMdp(mdp);
		p.setDroits(10);
		
		try {
			retour = personneDAO.addPersonne(p);
			p.setIdPersonne(retour);
			JSONPersonne = JSONUtil.getJSONPersonne(p);
			JSONListQuiz = JSONUtil.getJSONListQuiz();
		} catch(Exception e){
			JSONPersonne = JSONUtil.getJSONPersonne(null);
		}
		
		/*resultArray.add(JSONPersonne);
		resultArray.add(JSONListQuiz);
		resultJson.put("response", resultArray);
		return resultJson.toJSONString();*/
		
		List<JSONObject> json = new ArrayList<JSONObject>();
		json.add(JSONPersonne);
		json.add(JSONListQuiz);
		return JSONUtil.generateJSONResponse(json).toJSONString();
	}

}