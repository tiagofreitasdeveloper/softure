package br.com.rf.scheduling.test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import br.com.rf.scheduling.entity.Account;
import br.com.rf.scheduling.entity.Scheduling;
import br.com.rf.scheduling.entity.TransactionA;
import br.com.rf.scheduling.entity.TransactionB;
import br.com.rf.scheduling.entity.TransactionC;
import br.com.rf.scheduling.entity.TransactionD;


/**
 * @author tiago.freitas
 * Realiza o testes a respeito das regras das transações
 */
public class RuleTransactionTest {

	private String value = "1000";
	
	@Test
	public void calculateRuleTransactionA(){
		
		Scheduling scheduling = new Scheduling(new Account("123456"), new Account("123456"), LocalDateTime.of(2015, 11, 16, 00, 00) , 
				LocalDateTime.of(2015, 11, 30, 00, 00), new TransactionA(convertValue(value)));
		
		Assert.assertEquals(convertValue("32.00"), scheduling.getTransaction().calculateRate(scheduling));
	}
	
	@Test
	public void calculateRuleTransactionB(){
		
		Scheduling scheduling = new Scheduling(new Account("123456"), new Account("123456"), LocalDateTime.of(2015, 11, 16, 00, 00) , 
				LocalDateTime.of(2015, 11, 30, 00, 00), new TransactionB(convertValue(value)));
		
		Scheduling scheduling2 = new Scheduling(new Account("123456"), new Account("123456"), LocalDateTime.of(2015, 11, 16, 00, 00) , 
				LocalDateTime.of(2015, 12, 17, 00, 00), new TransactionB(convertValue(value)));
		
		Assert.assertEquals(convertValue("10.0"), scheduling.getTransaction().calculateRate(scheduling));
		Assert.assertEquals(convertValue("8.0"), scheduling.getTransaction().calculateRate(scheduling2));
	}
	
	@Test
	public void calculateRuleTransactionC(){
		
		
		Scheduling scheduling = new Scheduling(new Account("123456"), new Account("123456"), LocalDateTime.of(2015, 11, 16, 00, 00) , 
				LocalDateTime.of(2015, 11, 17, 00, 00), new TransactionC(convertValue(value)));
		Scheduling scheduling1 = new Scheduling(new Account("123456"), new Account("123456"), LocalDateTime.of(2015, 11, 16, 00, 00) , 
				LocalDateTime.of(2015, 11, 22, 00, 00), new TransactionC(convertValue(value)));
		Scheduling scheduling2 = new Scheduling(new Account("123456"), new Account("123456"), LocalDateTime.of(2015, 11, 16, 00, 00) , 
				LocalDateTime.of(2015, 11, 28, 00, 00), new TransactionC(convertValue(value)));
		Scheduling scheduling3 = new Scheduling(new Account("123456"), new Account("123456"), LocalDateTime.of(2015, 11, 16, 00, 00) , 
				LocalDateTime.of(2015, 12, 2, 00, 00), new TransactionC(convertValue(value)));
		Scheduling scheduling4 = new Scheduling(new Account("123456"), new Account("123456"), LocalDateTime.of(2015, 11, 16, 00, 00) , 
				LocalDateTime.of(2015, 12, 7, 00, 00), new TransactionC(convertValue(value)));
		Scheduling scheduling5 = new Scheduling(new Account("123456"), new Account("123456"), LocalDateTime.of(2015, 11, 16, 00, 00) , 
				LocalDateTime.of(2015, 12, 13, 00, 00), new TransactionC(convertValue(value)));
		Scheduling scheduling6 = new Scheduling(new Account("123456"), new Account("123456"), LocalDateTime.of(2015, 11, 16, 00, 00) , 
				LocalDateTime.of(2015, 12, 19, 00, 00), new TransactionC(convertValue(value)));
		Scheduling scheduling7 = new Scheduling(new Account("123456"), new Account("123456"), LocalDateTime.of(2015, 11, 16, 00, 00) , 
				LocalDateTime.of(2015, 12, 25, 00, 00), new TransactionC(convertValue(value)));
		
		
		Assert.assertEquals(convertValue("83.0"), scheduling.getTransaction().calculateRate(scheduling));
		Assert.assertEquals(convertValue("74.0"), scheduling.getTransaction().calculateRate(scheduling1));
		Assert.assertEquals(convertValue("67.0"), scheduling.getTransaction().calculateRate(scheduling2));
		Assert.assertEquals(convertValue("54.0"), scheduling.getTransaction().calculateRate(scheduling3));
		Assert.assertEquals(convertValue("43.0"), scheduling.getTransaction().calculateRate(scheduling4));
		Assert.assertEquals(convertValue("21.0"), scheduling.getTransaction().calculateRate(scheduling5));
		Assert.assertEquals(convertValue("12.0"), scheduling.getTransaction().calculateRate(scheduling6));
		Assert.assertEquals(convertValue("12.0"), scheduling.getTransaction().calculateRate(scheduling7));
		
	}
	
	@Test
	public void calculateRuleTransactionD(){
		
		Scheduling scheduling = new Scheduling(new Account("123456"), new Account("123456"), LocalDateTime.of(2015, 11, 16, 00, 00) , 
				LocalDateTime.of(2015, 11, 30, 00, 00), new TransactionD(convertValue("25000.0")));
		Scheduling scheduling2 = new Scheduling(new Account("123456"), new Account("123456"), LocalDateTime.of(2015, 11, 16, 00, 00) , 
				LocalDateTime.of(2015, 11, 30, 00, 00), new TransactionD(convertValue("25001.0")));
		Scheduling scheduling3 = new Scheduling(new Account("123456"), new Account("123456"), LocalDateTime.of(2015, 11, 16, 00, 00) , 
				LocalDateTime.of(2015, 11, 17, 00, 00), new TransactionD(convertValue("121000.0")));
		
		Assert.assertEquals(convertValue("752.000"), scheduling.getTransaction().calculateRate(scheduling));
		Assert.assertEquals(convertValue("10.0"), scheduling2.getTransaction().calculateRate(scheduling2));
		Assert.assertEquals(convertValue("10043.00"), scheduling3.getTransaction().calculateRate(scheduling3));
	}
	
	public BigDecimal convertValue(String value){
		return new BigDecimal(value);
	}
	
	@Test
	public void listSchedules() {

		List<Scheduling> schedulings = new ArrayList<>();
		schedulings.add(new Scheduling(new Account("123456"), new Account("789445512"), LocalDateTime.of(2015, 11, 16, 00, 00) , 
				LocalDateTime.of(2015, 11, 30, 00, 00), new TransactionA(new BigDecimal("1000.00"))));
		schedulings.add(new Scheduling(new Account("54321"), new Account("1111111"), LocalDateTime.of(2015, 11, 20, 00, 00) , 
				LocalDateTime.of(2015, 11, 21, 00, 00), new TransactionC(new BigDecimal("1000.00"))));
			
			for (Scheduling scheduling : schedulings) {
				System.out.println("OriginAccount: " + scheduling.getOriginAccount().getNumber());
				System.out.println("TargetAccount: " + scheduling.getTargetAccount().getNumber());
				System.out.println("DateRegister: " + scheduling.getDateRegister());
				System.out.println("DateScheduling: " + scheduling.getDateShcheduling());
				System.out.println("Rate: " + scheduling.getTransaction().calculateRate(scheduling));
				System.out.println("TransferValue: " + scheduling.getTransaction().getTransferValue());
			}
			
			
	}
}


