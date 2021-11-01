package com.skilldistillery.tracksleep.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Sleep {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String day;

	@Column(name = "sleep_duration")
	private double sleepDuration;

	@Column(name = "desired_sleep_time")
	private double desiredSleepTime;

	@Column(name = "created_at")
	@CreationTimestamp
	public LocalDateTime createdAt;

	@Column(name = "updated_at")
	@UpdateTimestamp
	public LocalDateTime updatedAt;

	public Sleep() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public double getSleepDuration() {
		return sleepDuration;
	}

	public void setSleepDuration(double sleepDuration) {
		this.sleepDuration = sleepDuration;
	}

	public double getDesiredSleepTime() {
		return desiredSleepTime;
	}

	public void setDesiredSleepTime(double desiredSleepTime) {
		this.desiredSleepTime = desiredSleepTime;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Sleep [id=" + id + ", day=" + day + ", sleepDuration=" + sleepDuration + ", desiredSleepTime="
				+ desiredSleepTime + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}