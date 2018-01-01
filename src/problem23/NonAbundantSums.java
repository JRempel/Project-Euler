package problem23;

import java.util.ArrayList;
import java.util.HashSet;

/*
 * A perfect number is a number for which the sum of its proper
 * divisors is exactly equal to the number. For example, the sum
 * of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28,
 * which means that 28 is a perfect number.
 * 
 * A number n is called deficient if the sum of its proper divisors
 * is less than n and it is called abundant if this sum exceeds n.
 * 
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16,
 * the smallest number that can be written as the sum of two abundant
 * numbers is 24. By mathematical analysis, it can be shown that all
 * integers greater than 28123 can be written as the sum of two
 * abundant numbers. However, this upper limit cannot be reduced any
 * further by analysis even though it is known that the greatest number
 * that cannot be expressed as the sum of two abundant numbers is less
 * than this limit.
 * 
 * Find the sum of all the positive integers which cannot be written
 * as the sum of two abundant numbers.
 * 
 * */

public class NonAbundantSums {
	public static void main(String[] args) {
		int max = 28123;
		ArrayList<Integer> abundantNums = new ArrayList<Integer>();
		for (int i = 0; i <= max; i++) {
			if (isAbundant(i))
				abundantNums.add(i);
		}
		HashSet<Integer> abundantSum = new HashSet<Integer>();
		for (int i = 0; i < abundantNums.size(); i++) {
			for (int j = i; j < abundantNums.size(); j++) {
				abundantSum.add(abundantNums.get(i) + abundantNums.get(j));
			}
		}
		int sum = 0;
		for (int i = 0; i <= max; i++) {
			if (!abundantSum.contains(i))
				sum += i;
		}
		System.out.println(sum);
	}

	private static boolean isAbundant(int n) {
		int max = (int) Math.sqrt(n);
		ArrayList<Integer> divisors = new ArrayList<Integer>();
		for (int i = 1; i <= max; i++) {
			if (n % i == 0) {
				divisors.add(i);
				if (i != n / i)
					divisors.add(n / i);
			}
		}
		divisors.remove((Integer) n);
		int sum = 0;
		for (Integer s : divisors) {
			sum += s;
		}
		if (sum > n)
			return true;
		else
			return false;
	}
}
