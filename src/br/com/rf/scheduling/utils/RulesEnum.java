package br.com.rf.scheduling.utils;

import br.com.rf.scheduling.service.CalculateDate;

public enum RulesEnum {

	TRANSACTION_RULE1("B", 0.0, 10, 0 , 30),
	TRANSACTION_RULE2("C", 8.3 ,0.0, 0, 5),
	TRANSACTION_RULE3("C", 7.4 ,0.0, 5, 10),
	TRANSACTION_RULE4("C", 6.7 ,0.0, 10, 15),
	TRANSACTION_RULE5("C", 5.4 ,0.0, 15, 20),
	TRANSACTION_RULE6("C", 4.3 ,0.0, 20, 25),
	TRANSACTION_RULE7("C", 2.1 ,0.0, 25, 30);

	private String typeTransaction;
	private double percent;
	private double flatRate;
	private int [] intervalDate;
	
	private RulesEnum( String typeTransaction, double percent, double flatRate, int...intervalDate) {
		this.typeTransaction = typeTransaction;
		this.percent = percent;
		this.flatRate = flatRate;
		this.intervalDate = intervalDate;
	}

	public static final RulesEnum isIntervalDate(long interval, String typeTransaction){
		
		RulesEnum rules[] = RulesEnum.values();
		
		for (RulesEnum r : rules) {
			if(new CalculateDate().isBetweenTwoDays(interval, r.getIntervalDate()[0], r.getIntervalDate()[1])
					&& r.getTypeTransaction().equals(typeTransaction)){
				return r;
			}
		}
		
		return null;
	}
	

	public String getTypeTransaction() {
		return typeTransaction;
	}


	public double getPercent() {
		return percent;
	}

	public int[] getIntervalDate() {
		return intervalDate;
	}

	public double getFlatRate() {
		return flatRate;
	}

}
