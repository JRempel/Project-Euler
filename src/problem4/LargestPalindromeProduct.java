package problem4;

import java.util.ArrayList;
import java.util.HashSet;

/*
 * A palindromic number reads the same both ways. The largest palindrome 
 * made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * 
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * */

public class LargestPalindromeProduct {
	public static void main(String[] args) {
		ArrayList<String> foundPalindrome = new ArrayList<String>();
		String toCheck = "";
		int one = 0;
		int two = 0;
		int three = 0;

		for (int i = 999; i > 99; i--) {
			for (int j = 999; j > 99; j--) {
				HashSet<Integer> temp = new HashSet<Integer>();
				temp.add(i);
				temp.add(j);
				toCheck = "" + (i * j);
				if (!toCheck.equals(new StringBuilder(toCheck).reverse().toString())) {
					toCheck = "";
				} else {
					foundPalindrome.add(toCheck + " -> " + i + ", " + j);
					if (i * j > one) {
						one = i * j;
						two = i;
						three = j;
					}
				}
			}
		}
		System.out.println(one + " -> " + two + ", " + three);
	}
}
