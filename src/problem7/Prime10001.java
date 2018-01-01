package problem7;

import java.util.HashSet;

/*
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, 
 * and 13, we can see that the 6th prime is 13.
 * 
 * What is the 10 001st prime number?
 * */

public class Prime10001 {
	public static void main(String[] args) {
		int counter = 3;
		int max = 10001;
		int currPrime = 2;
		boolean isPrime = true;
		HashSet<Integer> primeList = new HashSet<Integer>();
		primeList.add(2);
		while (primeList.size() < max) {
			for (int s : primeList) {
				if (counter % s == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primeList.add(counter);
				currPrime = counter;
			} else
				isPrime = true;
			counter++;
		}
		System.out.println(currPrime);
	}
}
