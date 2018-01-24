package fr.esigelec.projetSpring.model.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.esigelec.projetSpring.model.Personne;
import fr.esigelec.projetSpring.model.dao.IPersonneDAO;

@Repository("IPersonneDAO")

@Transactional
public class PersonneDAOImpl implements IPersonneDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public int addPersonne(Personne personne) {
		//return (int) sessionFactory.getCurrentSession().save(personne);
		return 1;
	}

	@Transactional(readOnly = true)
	@Override
	public Personne getPersonne(int idPersonne) {
		return sessionFactory.getCurrentSession().get(Personne.class, idPersonne);
	}

	@Transactional(readOnly = true)
	@Override
	public Personne getPersonne(String mail) {
		String hql = "from Personne where mail = :mail";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("mail", mail);
		@SuppressWarnings("unchecked")
		List<Personne> personnes = query.list();

		return personnes == null || personnes.size() == 0 ? null : personnes.get(0);
	}

}
