package fr.esigelec.projetSpring.model.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.esigelec.projetSpring.model.Question;
import fr.esigelec.projetSpring.model.dao.IQuestionDAO;

@Repository("IQuestionDAO") // 锟� mettre normalement sur la couche service (mais n'existe pas dans cet
							// exemple)
@Transactional(propagation = Propagation.SUPPORTS)
public class QuestionDAOImpl implements IQuestionDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Question> getListeQuestion() {
		return (List<Question>) sessionFactory.getCurrentSession().createCriteria(Question.class).list();
	}

	@Override
	@Transactional(readOnly = true)
	public Question getQuestion(int id) {
		return (Question) sessionFactory.getCurrentSession().get(Question.class, id);
	}

	/*
	 * @Transactional public void ajouterQuestion(Question q) {
	 * sessionFactory.getCurrentSession().save(q); }
	 * 
	 * @Transactional public void majQuestion(Question q) {
	 * sessionFactory.getCurrentSession().update(q); }
	 * 
	 * 
	 * public void supprimerQuestion(Question q) {
	 * sessionFactory.getCurrentSession().delete(q); }
	 */

}
