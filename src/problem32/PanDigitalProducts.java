package problem32;

import java.util.HashSet;

public class PanDigitalProducts {

	public static void main(String[] args) {
		HashSet<Long> products = new HashSet<Long>();

		// need to reduce search space!!
		long product;
		for (long i = 10; i < 100; i++) {
			for (long j = 1000000; j < 9999999; j++) {
				product = i * j;
				if (isPandigital(concatNums(i, j, product), 9))
					products.add(product);
			}
		}

		int sum = 0;
		for (long num : products) {
			sum += num;
		}
		System.out.println(sum);
	}

	public static boolean isPandigital(long input, int intendedLength) {
		// check lengths
		if (input <= 0)
			return false;
		int max = numlength(input);
		if (max != intendedLength)
			return false;
		// store used digits as a boolean array
		boolean[] nums = new boolean[max];
		while (input != 0) {
			int last = (int) (input % max);
			if (nums[last])
				return false;
			else
				nums[last] = true;
			input /= 10;
		}

		// check if boolean array is true
		for (boolean val : nums) {
			if (!val)
				return false;
		}
		return true;
	}

	// get the length of a long
	public static int numlength(long num) {
		int length;
		for (length = 0; num > 0; ++length)
			num /= 10;
		return length;
	}

	// concatenate 3 numbers
	public static long concatNums(long one, long two, long product) {
		long temp = one * (numlength(two) * 10) + two;
		return temp * (numlength(product) * 10) + product;
	}
}
