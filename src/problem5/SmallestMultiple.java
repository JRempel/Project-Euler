package problem5;

import java.util.ArrayList;

/*
 * 2520 is the smallest number that can be divided by each of 
 * the numbers from 1 to 10 without any remainder.
 * 
 * What is the smallest positive number that is evenly divisible 
 * by all of the numbers from 1 to 20?
 * */

public class SmallestMultiple {
	public static void main(String[] args) {
		long max = 1;
		long smallestMultiple;
		for (int i = 2; i <= 20; i++) {
			max *= i;
		}
		ArrayList<Integer> toCheck = new ArrayList<Integer>();
		// if a composite number is evenly divisible, it's factors must
		// necessarily also be evenly divisible
		for (int i = 10; i <= 20; i++) {
			toCheck.add(i);
		}
		smallestMultiple = max;
		boolean allDivideEvenly = true;
		for (long i = 20; i < max; i += 20) {
			for (Integer s : toCheck) {
				if (i % s != 0)
					allDivideEvenly = false;
			}
			if (allDivideEvenly) {
				smallestMultiple = i;
				System.out.println(smallestMultiple);
				break;
			} else
				allDivideEvenly = true;
		}
	}
}
