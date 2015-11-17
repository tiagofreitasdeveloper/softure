package br.com.rf.scheduling.entity;

import java.math.BigDecimal;

import br.com.rf.scheduling.service.CalculateDate;
import br.com.rf.scheduling.utils.RulesEnum;

/**
 * @author tiago.freitas
 *
 */
public class TransactionB extends AbstractTransaction{
	
	private Scheduling scheduling;
	
	public TransactionB(BigDecimal transferValue) {
		super(transferValue);
	}

	@Override
	public BigDecimal calculateRate(Scheduling scheduling) {
		
		long interval = new CalculateDate(scheduling.getDateRegister(), scheduling.getDateShcheduling()).diffTwoDates();
		
		RulesEnum ruleEnum = RulesEnum.isIntervalDate(interval, "B");
		
		return ruleEnum != null ? ruleEnum.getFlatRate() : new BigDecimal("8.0");
				
	}

	public Scheduling getScheduling() {
		return scheduling;
	}
	

}
