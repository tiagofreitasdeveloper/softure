package br.com.rf.scheduling.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public final class CalculateDate {

	private LocalDateTime firstDate;
	
	private LocalDateTime lastDate;

	public CalculateDate(LocalDateTime firstDate, LocalDateTime lastDate) {
		this.firstDate = firstDate;
		this.lastDate = lastDate;
	}
	
	public CalculateDate() {
		// TODO Auto-generated constructor stub
	}
	
	public long diffTwoDates(){
		return ChronoUnit.DAYS.between(this.firstDate, this.lastDate);
	}
	
	public boolean isBetweenTwoDays(long interval, int dayOne, int dayTwo){
		return (interval >= dayOne && interval <= dayTwo);
	}
	
	

	public LocalDateTime getFirstDate() {
		return firstDate;
	}

	public LocalDateTime getLastDate() {
		return lastDate;
	}
	
}
