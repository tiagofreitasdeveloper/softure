package br.com.rf.scheduling.test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import br.com.rf.scheduling.entity.Account;
import br.com.rf.scheduling.entity.Scheduling;
import br.com.rf.scheduling.entity.Transaction;
import br.com.rf.scheduling.entity.TransactionA;
import br.com.rf.scheduling.entity.TransactionC;
import br.com.rf.scheduling.entity.TransactionD;

public class RuleTransactionTest {

	@Test
	public void calculateRuleTransactionC(){
		
		Transaction transaction = new TransactionC(1000.00);
		
		Scheduling scheduling = new Scheduling(new Account("123456"), new Account("123456"), LocalDateTime.of(2015, 11, 16, 00, 00) , 
				LocalDateTime.of(2015, 11, 30, 00, 00), transaction);
		
		Assert.assertEquals(50.0, transaction.calculateRate(scheduling));
	}
	
	@Test
	public void calculateRuleTransactionD(){
		
		Transaction transaction = new TransactionD(1000.0);
		
		Assert.assertEquals(32.0, transaction.calculateRate());
	}
	
	public static void main(String[] args) {
		
		List<Scheduling> schedulings = new ArrayList<>();
		schedulings.add(new Scheduling(new Account("123456"), new Account("789445512"), LocalDateTime.of(2015, 11, 16, 00, 00) , 
				LocalDateTime.of(2015, 11, 30, 00, 00), new TransactionA(1000.00)));
		schedulings.add(new Scheduling(new Account("54321"), new Account("1111111"), LocalDateTime.of(2015, 11, 20, 00, 00) , 
				LocalDateTime.of(2015, 11, 21, 00, 00), new TransactionC(1000.00)));
		
		for (Scheduling scheduling : schedulings) {
			System.out.println(scheduling.getOriginAccount().getNumber());
			System.out.println(scheduling.getTargetAccount().getNumber());
			System.out.println(scheduling.getDateRegister());
			System.out.println(scheduling.getDateShcheduling());
			System.out.println(scheduling.getTransaction().calculateRate());
			System.out.println(scheduling.getTransaction().getTransferValue());
		}
		
		
	}
}
