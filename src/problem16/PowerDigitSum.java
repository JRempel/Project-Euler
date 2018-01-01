package problem16;

import java.math.BigInteger;

/*
 * 215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * 
 * What is the sum of the digits of the number 2^1000?
 * */

public class PowerDigitSum {
	public static void main(String[] args) {
		BigInteger power = BigInteger.valueOf(2).pow(1000);
		String toParse = power.toString();
		int sum = 0;
		for (int i = 0; i < toParse.length(); i++) {
			sum += Integer.parseInt("" + toParse.charAt(i));
		}
		System.out.println(sum);
	}
}
