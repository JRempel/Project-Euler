package problem6;

import com.google.common.math.LongMath;

/*
 * The sum of the squares of the first ten natural numbers is,
 * 12 + 22 + ... + 102 = 385
 * 
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)2 = 552 = 3025
 * 
 * Hence the difference between the sum of the squares of the 
 * first ten natural numbers and the square of the sum is 
 * 3025 − 385 = 2640.
 * 
 * Find the difference between the sum of the squares of the 
 * first one hundred natural numbers and the square of the sum.
 * */

public class SquareSum {
	public static void main(String[] args) {
		int max = 100;
		long sumSquared = 0;
		long squaresSummed = 0;
		
		for (int i = 1; i <= max; i++)
			sumSquared += i;
		sumSquared = LongMath.pow(sumSquared, 2);
		
		for (int i = 1; i <= max; i++)
			squaresSummed += Math.pow(i, 2);
		
		long difference = sumSquared - squaresSummed;
		System.out.println(difference);
	}
}
