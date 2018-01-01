package problem30;

import java.util.ArrayList;

/*
 * Surprisingly there are only three numbers that can be 
 * written as the sum of fourth powers of their digits:
 * 
 * 1634 = 1^4 + 6^4 + 3^4 + 4^4
 * 8208 = 8^4 + 2^4 + 0^4 + 8^4
 * 9474 = 9^4 + 4^4 + 7^4 + 4^4
 * 
 * As 1 = 14 is not a sum it is not included.
 * 
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 * 
 * Find the sum of all the numbers that can be written as 
 * the sum of fifth powers of their digits.
 * 
 * */

public class DigitFifthPowers {
	public static void main(String[] args) {
		/*
		 * The maximum possible value is given by: max = ⌊1+log10(max)⌋ * 9 ^ 5
		 * This is because the number of digits in a number is d(n) =
		 * ⌊1+log10(max)⌋ , and the maximum value of any digit is 9.
		 */
		// calculate upper bound
		int limit = 1;
		int result = -1;
		while (limit != result) {
			result = (int) (Math.floor(1 + Math.log10(limit)) * Math.pow(9, 5));
			limit++;
		}
		// calculate list of digit fifth power sums
		ArrayList<Integer> fifthPowerSum = new ArrayList<Integer>();
		for (int i = 2; i < limit; i++) {
			int test = i;
			int sum = 0;
			int digit = i;
			while (test > 0) {
				digit = test % 10;
				sum += Math.pow(digit, 5);
				test = test / 10;
			}
			if (sum == i)
				fifthPowerSum.add(i);
		}
		int totalSum = 0;
		for (Integer s : fifthPowerSum) {
			totalSum += s;
		}
		System.out.println(totalSum);
	}
}
