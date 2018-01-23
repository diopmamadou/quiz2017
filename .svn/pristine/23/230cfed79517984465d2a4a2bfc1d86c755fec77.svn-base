package fr.esigelec.projetSpring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import fr.esigelec.projetSpring.donnees_de_test.DonneesQuiz;
import fr.esigelec.projetSpring.model.Personne;
import fr.esigelec.projetSpring.model.dao.IPersonneDAO;
import fr.esigelec.projetSpring.model.dao.IQuizDAO;

@Controller
public class PersonneController {
	
	@Autowired
	private IPersonneDAO	personneDAO;
	@Autowired
	private IQuizDAO		quizDAO;
	
	@RequestMapping(value = "/")
	public String accueil() {
		return "index";
	}
	
	/**
	 * Handler permettant la connexion d'une personne
	 * 
	 * @param 	personne
	 * @return 	la page Quiz.jsp en cas de connexion, redirige vers l'index avec un 
	 * 			messae d'erreur sinon
	 */
	@RequestMapping(value = "/Connexion", method = RequestMethod.POST)
	public String connexionPersonne(@ModelAttribute("formulaireConnexion") Personne personne, final HttpSession session,
			final ModelMap modelMap) {

		Personne p = personneDAO.getPersonne(personne.getMail());

		if (p != null && p.getMdp().equals(personne.getMdp())) {
			modelMap.addAttribute("listeQuiz", quizDAO.getListeQuiz());
			//modelMap.addAttribute("listeQuiz", donnesQuiz.getListeQuiz());
			
			session.setAttribute("personne", p);
			return "quiz";
		} else {
			modelMap.addAttribute("messageErreur", "Email ou mot de passe incorrect");
			return "index";
		}
	}

	/**
	 * Handler permettant l'inscription d'une personne
	 * 
	 * @param personne
	 * @return la page Quiz.jsp en cas de succès, redirige vers l'index avec un
	 *         message d'erreur sinon
	 */
	@RequestMapping(value = "/Inscription", method = RequestMethod.POST)
	public String inscriptionPersonne(@ModelAttribute("formulaireInscription") Personne personne,
			final HttpSession session, final ModelMap modelMap) {

		int retour = -1;
		personne.setDroits(10);
		try { 
			retour = personneDAO.addPersonne(personne);
		} catch(Exception e){
			modelMap.addAttribute("messageErreur", "Cet email est déjà utilisé");
			return "inscription";
		}
		
		modelMap.addAttribute("listeQuiz", quizDAO.getListeQuiz());
		//modelMap.addAttribute("listeQuiz", donnesQuiz.getListeQuiz());
		session.setAttribute("personne", personne);
		return "quiz";
		
	}

	@RequestMapping(value = "/inscription", method = RequestMethod.GET)
	public String inscriptionPage() {
		return "inscription";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String indexPage() {
		return "index";
	}
	
}