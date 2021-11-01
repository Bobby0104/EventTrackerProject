package com.skilldistillery.tracksleep.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.tracksleep.data.SleepDAO;
import com.skilldistillery.tracksleep.entities.Sleep;
import com.skilldistillery.tracksleep.services.SleepService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4204"})
public class SleepController {
	
	@Autowired
	private SleepDAO sleepDAO;
	
	@Autowired
	private SleepService sleepSvc;
	
	
	@GetMapping("sleep")
	public List<Sleep> sleepIndex() {
		return sleepSvc.getSleep();
		
	}
	


	@PostMapping("sleep")
	public Sleep createSleep(@RequestBody Sleep sleep, HttpServletResponse resp, HttpServletRequest req) {
		try {
			sleepDAO.createSleep(sleep);
			resp.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(sleep.getId());
			String location = url.toString();
			resp.addHeader("Location", location);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
			sleep = null;
		}
		return sleep;
	}

	@PutMapping("sleep/{id}")
	public Sleep updateSleep(@PathVariable("id") Integer id, @RequestBody Sleep sleep, HttpServletResponse resp) {
		try {
			sleep = sleepDAO.updateSleep(id, sleep);
			if (sleep == null) {
				resp.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			sleep = null;
		}
		return sleep;
	}
	
	@DeleteMapping("sleep/{id}")
	public void deleteSleep(@PathVariable("id") Integer id, HttpServletResponse resp) {
		try {
			boolean deleted = sleepDAO.deleteSleep(id);
			if (deleted) {
				resp.setStatus(204);
			} else {
				resp.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
		}
	}

}
