package problem21;

import java.util.ArrayList;

/*
 * Let d(n) be defined as the sum of proper divisors of n (numbers
 * less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an
 * amicable pair and each of a and b are called amicable numbers.
 * 
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20,
 * 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of
 * 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 * 
 * */

public class AmicableNumbers {
	public static void main(String[] args) {
		int max = 10000;
		int test;
		ArrayList<Integer> amicable = new ArrayList<Integer>();
		for (int i = 1; i < max; i++) {
			test = isAmicable(i);
			if (test > 0 && !amicable.contains(i) && i != test) {
				amicable.add(i);
				amicable.add(test);
			}
		}
		int sum = 0;
		for (Integer s: amicable) {
			sum += s;
		}
		System.out.println(sum);
	}

	private static int isAmicable(int n) {
		int max = (int) Math.sqrt(n);
		ArrayList<Integer> divisors = new ArrayList<Integer>();
		for (int i = 1; i <= max; i++) {
			if (n % i == 0) {
				divisors.add(i);
				divisors.add(n / i);
			}
		}
		divisors.remove((Integer) n);
		int sum = 0;
		for (Integer s: divisors) {
			sum += s;
		}
		int pair = sum;
		max = (int) Math.sqrt(sum);
		divisors.clear();
		for (int i = 1; i <= max; i++) {
			if (sum % i == 0) {
				divisors.add(i);
				divisors.add(sum / i);
			}
		}
		divisors.remove((Integer) sum);
		sum = 0;
		for (Integer s: divisors) {
			sum += s;
		}
		if (sum == n)
			return pair;
		else
			return -1;
	}
}
