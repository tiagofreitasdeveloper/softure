package br.com.rf.scheduling.entity;

import br.com.rf.scheduling.service.CalculateDate;
import br.com.rf.scheduling.utils.RulesEnum;

public class TransactionC extends AbstractTransaction{

	public TransactionC(double transferValue) {
		super(transferValue);
	}

	@Override
	public double calculateRate() {
		return 0;
	}

	@Override
	public double calculateRate(Scheduling scheduling) {
		
		long interval = new CalculateDate(scheduling.getDateRegister(), scheduling.getDateShcheduling()).diffTwoDates();
		
		RulesEnum ruleEnum = RulesEnum.isIntervalDate(interval, "C");
		
	    double percent = (!ruleEnum.equals(null) ? ruleEnum.getPercent() : 1.2) / 100; 
	    
		return getTransferValue() * percent;
	}
	
	

}
