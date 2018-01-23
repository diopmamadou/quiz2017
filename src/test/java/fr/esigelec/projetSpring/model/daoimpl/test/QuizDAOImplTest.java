package fr.esigelec.projetSpring.model.daoimpl.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import fr.esigelec.projetSpring.model.Quiz;
import fr.esigelec.projetSpring.model.dao.IQuizDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
@Transactional
public class QuizDAOImplTest {

	@Autowired
	IQuizDAO quizDAO;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	@Rollback(true)
	public void testGetListeQuiz() {
		assertNotNull(quizDAO.getListeQuiz());
		assertNotEquals(quizDAO.getListeQuiz(), 0);
	}

	@Test
	@Rollback(true)
	public void testGetQuiz() {
		assertNotNull(quizDAO.getQuiz(1));
		assertNull(quizDAO.getQuiz(0));
	}

	@Test
	@Rollback(true)
	public void testUpdateQuiz() {
		Quiz quiz = quizDAO.getQuiz(1);
		
		quiz.setEtat(quiz.getEtat() + 1);
		quiz.setEtape(quiz.getEtape() + 1);
		quiz.setNoQuestionCourante(quiz.getNoQuestionCourante() + 1);
		
		quizDAO.updateQuiz(quiz);
		
		Quiz quizUpdated = quizDAO.getQuiz(1);
		assertEquals(quiz, quizUpdated);
	}

}
