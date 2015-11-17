package br.com.rf.scheduling.entity;

public class TransactionA extends AbstractTransaction{

	public TransactionA(double transferValue) {
		super(transferValue);
	}

	@Override
	public double calculateRate() {
		return (getTransferValue() * 0.03) + 2;
	}

	@Override
	public double calculateRate(Scheduling scheduling) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
