package br.com.rf.scheduling.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author tiago.freitas
 * Classe que realiza cálculo de datas
 */
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
	/**
	 * Realiza cálculo entre duas datas e rotorna o intervalo entre elas
	 * @return
	 */
	public long diffTwoDates(){
		return ChronoUnit.DAYS.between(this.firstDate, this.lastDate);
	}
	/**
	 * Verifica se o intervalor está contido entre as duas datas nos argumentos
	 * @param interval
	 * @param dayOne
	 * @param dayTwo
	 * @return  
	 */
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
