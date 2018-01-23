package fr.esigelec.projetSpring.model.daoimpl.test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import fr.esigelec.projetSpring.model.Question;
import fr.esigelec.projetSpring.model.dao.IQuestionDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
@Transactional
public class QuestionDAOImplTest {

	@Autowired
	private IQuestionDAO questionDAO;

	@Test
	@Rollback(true)
	public void testGetListeQuestion() {
		assertNotNull(questionDAO.getListeQuestion());
		assertNotEquals(questionDAO.getListeQuestion(), 0);
	}

	@Test
	@Rollback(true)
	public void testGetQuestion() {
		Question question = questionDAO.getQuestion(1);
		assertNotNull(question);
		assertNotNull(question.getPropositions());
		assertNotEquals(question.getPropositions().size(), 0);

		question = questionDAO.getQuestion(0);
		assertNull(question);
	}

}
