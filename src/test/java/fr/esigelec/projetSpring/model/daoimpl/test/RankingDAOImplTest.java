package fr.esigelec.projetSpring.model.daoimpl.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import fr.esigelec.projetSpring.model.Ranking;
import fr.esigelec.projetSpring.model.dao.IRankingDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
@Transactional
public class RankingDAOImplTest {


	@Autowired
	private IRankingDAO rank;
	
	
	@Test
	public void testGetClassement() {
		List<Ranking> liste = rank.getClassement(3);
		
		assertEquals(liste.get(0).getScore(),3);
		/*
		Test
		*/
	}

}
