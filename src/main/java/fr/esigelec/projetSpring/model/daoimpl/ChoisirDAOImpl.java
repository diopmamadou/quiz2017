package fr.esigelec.projetSpring.model.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.esigelec.projetSpring.model.Choisir;
import fr.esigelec.projetSpring.model.dao.IChoisirDAO;

@Repository("IChoisirDAO")

@Transactional
public class ChoisirDAOImpl implements IChoisirDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void addChoisir(Choisir choisir) {
		sessionFactory.getCurrentSession().save(choisir);
	}
	
}
