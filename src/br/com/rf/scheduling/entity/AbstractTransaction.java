package br.com.rf.scheduling.entity;

public abstract class AbstractTransaction implements Transaction{
	
	private double transferValue;

	public AbstractTransaction(double transferValue) {
		this.transferValue = transferValue;
	}

	public double getTransferValue() {
		return transferValue;
	}
	
}
