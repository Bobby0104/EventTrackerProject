package com.skilldistillery.tracksleep.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.tracksleep.entities.Sleep;

@Transactional
@Service
public class SleepDAOImpl implements SleepDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Sleep createSleep(Sleep sleep) {
		em.persist(sleep);
		em.flush();
		return sleep;
	}

	@Override
	public Sleep updateSleep(Integer id, Sleep sleep) {
		Sleep managed = em.find(Sleep.class, id);
		if (managed != null) {
			managed.setDay(sleep.getDay());
			managed.setDesiredSleepTime(sleep.getDesiredSleepTime());
			managed.setSleepDuration(sleep.getSleepDuration());
			em.persist(managed);
			em.flush();
		}
		return managed;
	}

	@Override
	public boolean deleteSleep(Integer id) {
		boolean deleted = false;
		Sleep sleep = em.find(Sleep.class, id);
		if (sleep != null) {
			em.remove(sleep);
			deleted = true;
		}
		return deleted;
	}

}
