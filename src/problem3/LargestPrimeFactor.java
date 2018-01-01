package problem3;

import com.google.common.math.LongMath;
import java.math.RoundingMode;
import java.util.HashSet;

/*
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 600851475143 ?
 * */

public class LargestPrimeFactor {
	public static void main(String[] args) {
		long num = 600851475143L;
		long max = LongMath.sqrt(num + 1, RoundingMode.CEILING);
		HashSet<Long> foundPrime = new HashSet<Long>();

		foundPrime.add(2L);
		boolean isPrime = true;
		for (long i = 3; i < max; i += 2) {
			if (num % i == 0 && !foundPrime.contains(i)) {
				for (long s : foundPrime) {
					if (i % s == 0) {
						isPrime = false;
						break;
					}
				}
				if (isPrime) {
					foundPrime.add(i);
					System.out.println(i + ", ");
				} else
					isPrime = true;
			}
		}
	}
}