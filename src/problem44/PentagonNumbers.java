package problem44;

public class PentagonNumbers {
	public static void main(String[] args) {
		boolean found = false;
		int index = 1;
		int n = 0, m = 0;
		while (!found) {
			index++;
			n = generatePentagonal(index);
			for (int i = index - 1; i > 0; i--) {
				m = generatePentagonal(i);
				if (isPentagonal(n + m) && isPentagonal(n - m)) {
					found = true;
					break;
				}
				if (m == 2167)
					System.out.println("hey!");
			}
		}
		System.out.println("Pentagonal Pair: " + (Math.sqrt(24.0 * n + 1.0) + 1.0) / 6.0 + ", "
				+ (Math.sqrt(24.0 * m + 1.0) + 1.0) / 6.0);
		System.out.println(n - m);

	}

	private static boolean isPentagonal(int n) {
		double test = (Math.sqrt(24.0 * n + 1.0) + 1.0) / 6.0;
		return (test == (int) test) ? true : false;
	}

	private static int generatePentagonal(int n) {
		return n * (3 * n - 1) / 2;
	}
}
