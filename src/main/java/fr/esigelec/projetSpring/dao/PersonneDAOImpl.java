package fr.esigelec.projetSpring.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.esigelec.projetSpring.model.Personne;

@Repository("personneDAO") //à mettre normalement sur la couche service (mais n'existe pas dans cet exemple)
@Transactional(propagation = Propagation.SUPPORTS)
public class PersonneDAOImpl implements PersonneDAO {

	
 @Autowired
 private SessionFactory sessionFactory;
 
 public void ajouterPersonne(Personne personne) {
   sessionFactory.getCurrentSession().save(personne);
 }


 @SuppressWarnings("unchecked")
 @Transactional(readOnly=true)
public List<Personne> getListePersonnes() {
  return (List<Personne>) sessionFactory.getCurrentSession().createCriteria(Personne.class).list();
 }

 @Transactional(readOnly=true)
 public Personne getPersonne(int id) {
  return (Personne) sessionFactory.getCurrentSession().get(Personne.class, id);
 }

}