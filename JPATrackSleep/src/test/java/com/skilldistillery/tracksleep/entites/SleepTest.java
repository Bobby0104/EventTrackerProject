package com.skilldistillery.tracksleep.entites;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.tracksleep.entities.Sleep;

class SleepTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	
	private Sleep sleep;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPATrackSleep");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		sleep = em.find(Sleep.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		sleep = null;
	}

	@Test
	void test() {
		assertNotNull(sleep);
		assertEquals("Monday", sleep.getDay());
//		assertEquals("8.0", sleep.getSleepDuration());
//		assertEquals("desired_sleep_time", sleep.getDesiredSleepTime());
//		assertEquals(LocalDateTime.of(2021, 29, 10, 00, 00), sleep.getCreatedAt());
//		assertEquals(LocalDateTime.of(2021, 29, 10, 00, 00), sleep.getUpdatedAt());
	}

}
