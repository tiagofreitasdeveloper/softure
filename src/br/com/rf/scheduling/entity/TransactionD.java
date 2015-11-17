package br.com.rf.scheduling.entity;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

public class TransactionD extends AbstractTransaction{

	Map<Boolean, Double> rulesValuesTransaction;
	
	public TransactionD(double transferValue) {
		super(transferValue);
	}
	

	@Override
	public double calculateRate() {
		
		rulesValuesTransaction = new HashMap<Boolean, Double>();
		rulesValuesTransaction.put(25000.00 >= getTransferValue(), new TransactionA(getTransferValue()).calculateRate());
		rulesValuesTransaction.put(25001.00 <= getTransferValue() && 120000.00 >= getTransferValue(), new TransactionB(getTransferValue()).calculateRate());
		rulesValuesTransaction.put(120000.00 < getTransferValue(), new TransactionC(getTransferValue()).calculateRate());
		
		return rulesValuesTransaction.get(true);
	}

	@Override
	public double calculateRate(Scheduling scheduling) {
		// TODO Auto-generated method stub
		return 0;
	}

}
