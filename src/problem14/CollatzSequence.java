//package problem14;

import java.math.BigInteger;
import java.util.HashMap;

/*
 * The following iterative sequence is defined for the set of positive integers:
 * 
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 * 
 * Using the rule above and starting with 13, we generate the following sequence:
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * 
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 
 * 10 terms. Although it has not been proved yet (Collatz Problem), it is thought 
 * that all starting numbers finish at 1.
 * 
 * Which starting number, under one million, produces the longest chain?
 * 
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 * */

public class CollatzSequence {
	public static void main(String[] args) {
		BigInteger tempVal, maxCounter, counter;
		HashMap<BigInteger, BigInteger> found = new HashMap<BigInteger, BigInteger>();
		tempVal = maxCounter = counter = BigInteger.ZERO;
		int startVal, maxVal;
		startVal = maxVal = 0;
		// number of iterations
		for (int i = 1; i < 1000000; i++) {
			startVal = i;
			tempVal = BigInteger.valueOf(startVal);
			// while the chain continues
			while (tempVal.compareTo(BigInteger.ONE) != 0) {
				tempVal = getNext(tempVal);
				counter = counter.add(BigInteger.ONE);
				// check for previously found values
				if (found.containsKey(tempVal)) {
					counter = counter.add(found.get(tempVal));
					break;
				}
			}
			found.put(BigInteger.valueOf(startVal), counter);
			counter = counter.add(BigInteger.ONE);
			// replace if new larger value
			if (counter.compareTo(maxCounter) == 1) {
				maxCounter = counter;
				maxVal = startVal;
			}
			counter = BigInteger.ZERO;
		}
		System.out.println(maxVal + " " + maxCounter);
	}

	// get next value in chain
	private static BigInteger getNext(BigInteger n) {
		if (n.mod(BigInteger.valueOf(2)).compareTo(BigInteger.ZERO) == 0) {
			return (n.divide(BigInteger.valueOf(2)));
		} else {
			return ((n.multiply(BigInteger.valueOf(3))).add(BigInteger.ONE));
		}
	}
}
