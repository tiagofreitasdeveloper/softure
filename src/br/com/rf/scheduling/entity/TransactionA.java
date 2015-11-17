package br.com.rf.scheduling.entity;

import java.math.BigDecimal;

import br.com.rf.scheduling.utils.AppUtils;

/**
 * @author tiago.freitas
 *
 */
public class TransactionA extends AbstractTransaction{

	public TransactionA(BigDecimal transferValue) {
		super(transferValue);
	}

	@Override
	public BigDecimal calculateRate(Scheduling scheduling) {
		return getTransferValue().multiply(new BigDecimal("0.03")).add(new BigDecimal(2));
	}

	
}
