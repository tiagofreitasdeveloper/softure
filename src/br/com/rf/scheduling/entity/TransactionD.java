package br.com.rf.scheduling.entity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import br.com.rf.scheduling.utils.AppUtils;

/**
 * @author tiago.freitas
 *
 */
public class TransactionD extends AbstractTransaction{

	Map<Boolean, Transaction> rulesValuesTransaction;
	
	public TransactionD(BigDecimal transferValue) {
		super(transferValue);
	}

	@Override
	public BigDecimal calculateRate(Scheduling scheduling) {
		
		rulesValuesTransaction = new HashMap<Boolean, Transaction>();
		rulesValuesTransaction.put(AppUtils.compareEqualsOrFirstNumberMajor(new BigDecimal("25000.0"), getTransferValue()) , new TransactionA(getTransferValue()));
		rulesValuesTransaction.put(AppUtils.compareEqualsOrFirstNumberMinor(new BigDecimal("25001.0"), getTransferValue())  
									&& AppUtils.compareEqualsOrFirstNumberMajor(new BigDecimal("120000.0"), getTransferValue()), new TransactionB(getTransferValue()));
		rulesValuesTransaction.put(AppUtils.compareFirstNumberMinor(new BigDecimal("120000.0"), getTransferValue()), new TransactionC(getTransferValue()));
		
		return rulesValuesTransaction.get(true).calculateRate(scheduling);
	}

}
