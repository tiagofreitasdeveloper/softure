package br.com.rf.scheduling.entity;

import java.math.BigDecimal;

/**
 * @author tiago.freitas
 *
 */
public interface Transaction {
	
	BigDecimal calculateRate(Scheduling scheduling);
	
	BigDecimal getTransferValue();
}
