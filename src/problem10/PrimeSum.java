package problem10;

import java.math.BigInteger;
import java.util.HashSet;

/*
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 * */

public class PrimeSum {
	public static void main(String[] args) {
		int counter = 3;
		BigInteger sum = new BigInteger("0");
		int max = 2000000;
		boolean isPrime = true;
		HashSet<Integer> primeList = new HashSet<Integer>();
		primeList.add(2);
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
		for (int s: primeList) {
			sum = sum.add(new BigInteger("" + s));
		}
		System.out.println(sum);
	}
}
