package fr.esigelec.projetSpring.model.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.esigelec.projetSpring.model.Quiz;
import fr.esigelec.projetSpring.model.dao.IQuizDAO;

@Repository("IQuizDAO")
@Transactional(propagation = Propagation.SUPPORTS)
public class QuizDAOImpl implements IQuizDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Quiz> getListeQuiz() {
		return (List<Quiz>) sessionFactory.getCurrentSession().createCriteria(Quiz.class).list();
	}

	@Override
	@Transactional(readOnly = true)
	public Quiz getQuiz(int id) {
		return (Quiz) sessionFactory.getCurrentSession().get(Quiz.class, id);
	}

	@Override
	@Transactional
	public void updateQuiz(Quiz q) {
		sessionFactory.getCurrentSession().update(q);
	}

	@Transactional
	@Override
	public void addQuiz(Quiz q) {
		sessionFactory.getCurrentSession().save(q);
	}

	@Transactional
	@Override
	public void deleteQuiz(Quiz q) {
		sessionFactory.getCurrentSession().delete(q);
	}

}
