package problem20;

import java.math.BigInteger;

/*
 * n! means n × (n - 1) × ... × 3 × 2 × 1
 * 
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * 
 * Find the sum of the digits in the number 100!
 * 
 * */

public class FactorialDigitSum {
	public static void main(String[] args) {
		int curr = 100;
		BigInteger product = new BigInteger("1");
		while (curr > 0) {
			product = product.multiply(new BigInteger(curr + ""));
			curr--;
		}
		String output = product.toString();
		int sum = 0;
		for (int i = 0; i < output.length(); i++) {
			sum += Integer.parseInt(output.charAt(i) + "");
		}
		System.out.println(sum);
	}
}
