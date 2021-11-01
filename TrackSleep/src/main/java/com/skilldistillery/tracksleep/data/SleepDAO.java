package com.skilldistillery.tracksleep.data;

import com.skilldistillery.tracksleep.entities.Sleep;

public interface SleepDAO {
	
	Sleep createSleep(Sleep sleep);
	Sleep updateSleep(Integer id, Sleep sleep);
	boolean deleteSleep(Integer id);

}
