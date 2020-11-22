package model.persistence.Game;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.persistence.GamerDTO;

public class GameDTOTest {
	
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Init test GameDTO");

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Finish test GameDTO");
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testGetPoints() {
		GameDTO g = new GameDTO(1, LocalDateTime.now(),200, "Juego1"); 
		assertEquals(200, g.getPoints());
	}

	@Test
	public void testSetPoints() {
		GameDTO g = new GameDTO(1, LocalDateTime.now(),200, "Juego1"); 
		g.setPoints(500);
		assertEquals(500, g.getPoints());
	}

	@Test
	public void testGetFk_idGamer() {
		for (int i = 0; i <100; i++) {
			GameDTO g = new GameDTO(i, LocalDateTime.now(),200, "Juego1"); 
			assertEquals(i, g.getFk_idGamer());
		}
		
	}

	@Test
	public void testSetFk_idGamer() {
		for (int i = 0; i <100; i++) {
			GameDTO g = new GameDTO(1, LocalDateTime.now(),200, "Juego1"); 
			g.setFk_idGamer(i);
			assertEquals(i, g.getFk_idGamer());
		}
	}


}
