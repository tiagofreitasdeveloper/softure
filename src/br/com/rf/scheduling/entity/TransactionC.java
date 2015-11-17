package br.com.rf.scheduling.entity;

import java.math.BigDecimal;

import br.com.rf.scheduling.service.CalculateDate;
import br.com.rf.scheduling.utils.AppUtils;
import br.com.rf.scheduling.utils.RulesEnum;


/**
 * @author tiago.freitas
 *
 */
public class TransactionC extends AbstractTransaction{

	public TransactionC(BigDecimal transferValue) {
		super(transferValue);
	}

	@Override
	public BigDecimal calculateRate(Scheduling scheduling) {
		
		long interval = new CalculateDate(scheduling.getDateRegister(), scheduling.getDateShcheduling()).diffTwoDates();
		
		RulesEnum ruleEnum = RulesEnum.isIntervalDate(interval, "C");
		
		//1.2 é referente ao percentual que não contém intervalos na regra, no caso maior que 30 dias 
	    BigDecimal percent = (ruleEnum != null ? ruleEnum.getPercent() : new BigDecimal("1.2")); 
	    
		return AppUtils.percent(getTransferValue(), percent);
	}
	
	
	

}
