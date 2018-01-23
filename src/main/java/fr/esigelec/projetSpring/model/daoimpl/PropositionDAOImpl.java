package fr.esigelec.projetSpring.model.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.esigelec.projetSpring.model.Proposition;
import fr.esigelec.projetSpring.model.dao.IPropositionDAO;

/***
 * 
 * @author CHEN Yuzhe
 * @deprecated 
 * 
 */
@Repository("IPropositionDAO")
@Transactional(propagation = Propagation.SUPPORTS)
public class PropositionDAOImpl implements IPropositionDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional(readOnly = true)
	public Proposition getProposition(int id) {
		return (Proposition) sessionFactory.getCurrentSession().get(Proposition.class, id);
	}

	/*
	 * public void majProposition(Proposition p) {
	 * sessionFactory.getCurrentSession().update(p); }
	 * 
	 * 
	 * public void supprimerProposition(Proposition p) {
	 * sessionFactory.getCurrentSession().delete(p); }
	 */

}
