package br.com.rf.scheduling.entity;

public interface Transaction {
	
	double calculateRate();
	
	double calculateRate(Scheduling scheduling);
	
	double getTransferValue();
}
