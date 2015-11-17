package br.com.rf.scheduling.entity;

import java.math.BigDecimal;

/**
 * @author tiago.freitas
 * Abstra��o do tipo de transa��o
 */
public abstract class AbstractTransaction implements Transaction{
	
	private BigDecimal transferValue;
	
	public AbstractTransaction(BigDecimal transferValue) {
		this.transferValue = transferValue;
	}

	public BigDecimal getTransferValue() {
		return transferValue;
	}
	
}
