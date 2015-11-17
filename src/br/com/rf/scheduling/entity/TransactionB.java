package br.com.rf.scheduling.entity;

import br.com.rf.scheduling.service.CalculateDate;
import br.com.rf.scheduling.utils.RulesEnum;

public class TransactionB extends AbstractTransaction{
	
	private Scheduling scheduling;
	
	public TransactionB(double transferValue) {
		super(transferValue);
	}

	@Override
	public double calculateRate() {
		return 0;
	}

	@Override
	public double calculateRate(Scheduling scheduling) {
		
		long interval = new CalculateDate(scheduling.getDateRegister(), scheduling.getDateShcheduling()).diffTwoDates();
		
		RulesEnum ruleEnum = RulesEnum.isIntervalDate(interval, "B");
		
		return !ruleEnum.equals(null) ? ruleEnum.getFlatRate() : 8.0;
				
	}

	public Scheduling getScheduling() {
		return scheduling;
	}
	

}
