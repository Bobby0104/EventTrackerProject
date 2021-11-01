package com.skilldistillery.tracksleep.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.tracksleep.entities.Sleep;
import com.skilldistillery.tracksleep.repositories.SleepRepository;

@Service
public class SleepServiceImpl implements SleepService {
	
	@Autowired
	private SleepRepository sleepRepo;

	@Override
	public List<Sleep> getSleep() {
		return sleepRepo.findAll();
	}

}
