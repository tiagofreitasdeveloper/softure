package br.com.rf.scheduling.utils;

import java.math.BigDecimal;

import br.com.rf.scheduling.service.CalculateDate;

/**
 * @author tiago.freitas
 * Enum que contém as regras de intervalos dos dias de agendamento
 */
public enum RulesEnum {

	TRANSACTION_RULE1("B", null, RulesEnum.convertBigDecimal("10.0"), 0 , 30),
	TRANSACTION_RULE2("C", RulesEnum.convertBigDecimal("8.3") , null, 0, 5),
	TRANSACTION_RULE3("C", RulesEnum.convertBigDecimal("7.4") ,null, 5, 10),
	TRANSACTION_RULE4("C", RulesEnum.convertBigDecimal("6.7") ,null, 10, 15),
	TRANSACTION_RULE5("C", RulesEnum.convertBigDecimal("5.4") ,null, 15, 20),
	TRANSACTION_RULE6("C", RulesEnum.convertBigDecimal("4.3") ,null, 20, 25),
	TRANSACTION_RULE7("C", RulesEnum.convertBigDecimal("2.1") ,null, 25, 30);

	private String typeTransaction;
	private BigDecimal percent;
	private BigDecimal flatRate;
	private int [] intervalDate;
	
	private RulesEnum( String typeTransaction, BigDecimal percent, BigDecimal flatRate, int...intervalDate) {
		this.typeTransaction = typeTransaction;
		this.percent = percent;
		this.flatRate = flatRate;
		this.intervalDate = intervalDate;
	}
	/**
	 * Verifica e retorna enum que está dentro do intervalo de dias e tipo da transação
	 * @param interval
	 * @param typeTransaction
	 * @return
	 */
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
	
	public static final BigDecimal convertBigDecimal(String value){
		return new BigDecimal(value);
	}
	
	public String getTypeTransaction() {
		return typeTransaction;
	}
	
	public BigDecimal getPercent() {
		return percent;
	}

	public int[] getIntervalDate() {
		return intervalDate;
	}

	public BigDecimal getFlatRate() {
		return flatRate;
	}

}
