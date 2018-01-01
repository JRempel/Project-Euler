package problem9;

/*
 * A Pythagorean triplet is a set of three natural numbers,
 * a < b < c, for which, a2 + b2 = c2
 * 
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 * 
 * There exists exactly one Pythagorean triplet for which 
 * a + b + c = 1000.
 * 
 * Find the product abc.
 * */

public class SumPythagoreanTrimple {
	public static void main(String[] args) {
		int a, b, c;
		for (int m = 2; m < 1000; m++) {
			for (int n = 1; n < m; n++) {
				a = (int) (Math.pow(m, 2) - Math.pow(n, 2));
				b = (2 * m * n);
				c = (int) (Math.pow(m, 2) + Math.pow(n, 2));
				if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {
					if (a + b + c == 1000) {
						System.out.println(a + " * " + b + " * " + c + " = " + (a * b * c));
					}
				}
			}
		}
	}
}