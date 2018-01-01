package problem31;

/*
 * In England the currency is made up of pound, �, and pence, 
 * p, and there are eight coins in general circulation:
 * 
 * 1p, 2p, 5p, 10p, 20p, 50p, �1 (100p) and �2 (200p).
 * 
 * It is possible to make �2 in the following way:
 * 
 * 1ף1 + 1�50p + 2�20p + 1�5p + 1�2p + 3�1p
 * 
 * How many different ways can �2 be made using any number of 
 * coins?
 * 
 * */

public class CoinSums {
	private static int max = 200;
	private static int[] coins = { 1, 2, 5, 10, 20, 50, 100, 200 };

	public static void main(String[] args) {
		System.out.println(count(max, coins.length - 1, coins));
	}

	private static int count(int maximum, int index, int[] coins) {
		if (maximum == 0) {
			return 1;
		}
		if (maximum < 0) {
			return 0;
		}
		if (index < 0 && maximum > 0) {
			return 0;
		}
		return count(maximum, index - 1, coins) + count(maximum - coins[index], index, coins);
	}
}
