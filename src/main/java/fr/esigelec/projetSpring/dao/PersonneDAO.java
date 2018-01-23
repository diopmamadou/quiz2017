package fr.esigelec.projetSpring.dao;

import java.util.List;

import fr.esigelec.projetSpring.model.Personne;

public interface PersonneDAO {
	 
	 public void ajouterPersonne(Personne p);

	 public List<Personne> getListePersonnes();
	 
	 public Personne getPersonne(int id);
	 
	}