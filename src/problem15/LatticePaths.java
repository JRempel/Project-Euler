package problem15;

import java.math.BigInteger;

/*
 * Starting in the top left corner of a 2×2 grid, and 
 * only being able to move to the right and down, there 
 * are exactly 6 routes to the bottom right corner.
 * 
 * How many such routes are there through a 20×20 grid?
 * */

public class LatticePaths {
	public static void main(String[] args) {
		int size = 20;
		BigInteger[][] grid = new BigInteger[size][size];
		for (int i = 0; i < size; i++) {
			grid[0][i] = BigInteger.ONE;
			grid[i][0] = BigInteger.ONE;
		}
		for (int y = 1; y < size; y++) {
			for (int x = 1; x < size; x++) {
				grid[y][x] = (grid[y][x-1].add(grid[y-1][x]));
			}
		}
		BigInteger sum = BigInteger.ONE;
		for (int y = 0; y < size; y++) {
			for (int x = 0; x < size; x++) {
				sum = sum.add(grid[y][x]);
			}
		}
		System.out.println("Number of paths through a " + size + "x" + size +  " sized grid is: " + sum);
	}
}
