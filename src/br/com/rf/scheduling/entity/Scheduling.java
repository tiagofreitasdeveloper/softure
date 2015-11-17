package br.com.rf.scheduling.entity;

import java.time.LocalDateTime;

import br.com.rf.scheduling.service.CalculateDate;

public class Scheduling {
	
	private Account originAccount;

	private Account targetAccount;
	
	private LocalDateTime dateRegister;
	
	private LocalDateTime dateShcheduling;
	
	private Transaction transaction;

	public Scheduling(Account originAccount, Account targetAccount, LocalDateTime dateRegister,
			LocalDateTime dateShcheduling, Transaction transaction) {
		this.originAccount = originAccount;
		this.targetAccount = targetAccount;
		this.dateRegister = dateRegister;
		this.dateShcheduling = dateShcheduling;
		this.transaction = transaction;
	}

	public LocalDateTime getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(LocalDateTime dateRegister) {
		this.dateRegister = dateRegister;
	}

	public LocalDateTime getDateShcheduling() {
		return dateShcheduling;
	}

	public void setDateShcheduling(LocalDateTime dateShcheduling) {
		this.dateShcheduling = dateShcheduling;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public Account getOriginAccount() {
		return originAccount;
	}

	public Account getTargetAccount() {
		return targetAccount;
	}

	
}
