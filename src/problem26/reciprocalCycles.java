package problem26;

import java.util.ArrayList;
import java.util.HashSet;

/* A unit fraction contains 1 in the numerator. The decimal representation 
 * of the unit fractions with denominators 2 to 10 are given:
 * 
 * 1/2	= 	0.5
 * 1/3	= 	0.(3)
 * 1/4	= 	0.25
 * 1/5	= 	0.2
 * 1/6	= 	0.1(6)
 * 1/7	= 	0.(142857)
 * 1/8	= 	0.125
 * 1/9	= 	0.(1)
 * 1/10	= 	0.1 
 * 
 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It 
 * can be seen that 1/7 has a 6-digit recurring cycle.
 * 
 * Find the value of d < 1000 for which 1/d contains the longest recurring
 * cycle in its decimal fraction part.
 * 
 * */

public class reciprocalCycles {
	public static void main(String[] args) {
		boolean isPrime = true;
		HashSet<Integer> primeList = new HashSet<Integer>();
		primeList.add(2);
		int counter = 3;
		int max = 1000;
		// find primes under max
		while (counter < max) {
			for (int s : primeList) {
				if (counter % s == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primeList.add(counter);
			} else
				isPrime = true;
			counter++;
		}
		// check for repeating remainder via mod
		int longest = 0;
		int numDecimals = 0;
		for (Integer s : primeList) {
			ArrayList<Integer> decimals = new ArrayList<Integer>();
			int decimal = 0;
			int temp = 1;
			while (true) {
				decimal = temp % s;
				if (!decimals.contains(decimal))
					decimals.add(decimal);
				else
					break;
				temp = decimal * 10;
			}
			if (decimals.size() > numDecimals) {
				longest = s;
				numDecimals = decimals.size();
			}
		}
		System.out.println(longest + " recurring cycle is: " + numDecimals);
	}
}
