package fr.esigelec.projetSpring.model.daoimpl.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import fr.esigelec.projetSpring.model.Stats;
import fr.esigelec.projetSpring.model.dao.IStatsDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
@Transactional
public class StatsDAOImplTest {

	
	@Autowired
	private IStatsDAO stats;
	
	@Test
	public void testGetStatistiquesQuestionCourante() {
		List<Stats> statsList = stats.getStatistiquesQuestionCourante(3);
		assertEquals(statsList.get(0).getPropositionID(),41);
	}

}
