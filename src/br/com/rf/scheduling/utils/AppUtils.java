package br.com.rf.scheduling.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;


/**
 * @author tiago.freitas
 * Classe utilitária para manipulação de números
 */
public class AppUtils {

	public static final BigDecimal percent(BigDecimal value, BigDecimal percent){
		return value.multiply(percent).divide(new BigDecimal("100"));
	}
	
	public static final boolean compareEquals(BigDecimal...value){
		return value[0].compareTo(value[1]) == 0; 
	}
	public static final boolean compareFirstNumberMajor(BigDecimal...value){
		return value[0].compareTo(value[1]) == 1;
	}
	public static final boolean compareFirstNumberMinor(BigDecimal...value){
		return value[0].compareTo(value[1]) == -1;
	}
	public static final boolean compareEqualsOrFirstNumberMajor(BigDecimal...value){
		return compareEquals(value[0], value[1]) || value[0].compareTo(value[1]) == 1;
	}
	public static final boolean compareEqualsOrFirstNumberMinor(BigDecimal...value){
		return compareEquals(value[0], value[1]) || value[0].compareTo(value[1]) == -1;
	}
	
	public static final boolean isBetween(BigDecimal...value){
		return value[0].compareTo(value[1]) > 0 && value[1].compareTo(value[0]) < 0;
	}
	
}
