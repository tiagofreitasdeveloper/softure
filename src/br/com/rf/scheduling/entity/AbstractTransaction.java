package br.com.rf.scheduling.entity;

import java.math.BigDecimal;

/**
 * @author tiago.freitas
 * Abstração do tipo de transação
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
