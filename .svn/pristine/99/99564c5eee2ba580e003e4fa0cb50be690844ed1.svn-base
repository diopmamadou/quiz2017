package fr.esigelec.projetSpring.model.daoimpl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import fr.esigelec.projetSpring.model.Personne;
import fr.esigelec.projetSpring.model.dao.IPersonneDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
@Transactional
public class PersonneDAOImplTest {

	@Autowired
	private IPersonneDAO personneDAO;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	@Rollback(true)
	public void testAddPersonne() {
		Personne addedPersonne = new Personne("test nom", "test prenom", "junit test mail", "test mdp", 10);
		Personne selectedPersonne = new Personne();

		personneDAO.addPersonne(addedPersonne);
		selectedPersonne = personneDAO.getPersonne(addedPersonne.getIdPersonne());

		assertEquals(selectedPersonne, addedPersonne);
	}

	@Test
	@Rollback(true)
	public void testGetPersonneInt() {
		Personne personne = new Personne("test nom", "test prenom", "junit test mail", "test mdp", 10);
		personneDAO.addPersonne(personne);
		assertNotNull(personneDAO.getPersonne(personne.getIdPersonne()));
		
		assertNull(personneDAO.getPersonne(0));
	}

	@Test
	@Rollback(true)
	public void testGetPersonneString() {
		Personne personne = new Personne("test nom", "test prenom", "junit test mail", "test mdp", 10);
		personneDAO.addPersonne(personne);
		assertNotNull(personneDAO.getPersonne("test mail"));
		
		//personne = personneDAO.getPersonne(null);
		assertNull(personneDAO.getPersonne(null));
	}

}
