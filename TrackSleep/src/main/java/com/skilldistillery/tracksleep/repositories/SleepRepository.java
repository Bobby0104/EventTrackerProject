package com.skilldistillery.tracksleep.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.tracksleep.entities.Sleep;

public interface SleepRepository extends JpaRepository<Sleep, Integer> {
	
	

}
