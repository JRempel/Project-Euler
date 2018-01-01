package problem28;

import java.math.BigInteger;

/*
 * Starting with the number 1 and moving to the right in a
 * clockwise direction a 5 by 5 spiral is formed as follows:
 * 
 * 21 22 23 24 25
 * 20  7  8  9 10
 * 19  6  1  2 11
 * 18  5  4  3 12
 * 17 16 15 14 13
 * 
 * It can be verified that the sum of the numbers on the
 * diagonals is 101.
 * 
 * What is the sum of the numbers on the diagonals in a 1001
 * by 1001 spiral formed in the same way?
 * 
 * */

public class NumberSpiralDiagonals {
	public static void main(String[] args) {
		int size = 1001;
		int[][] array = new int[size][size];
		int counter = size * size;
		int x = size - 1;
		int y = 0;
		while (counter > 0) {
			array[y][x] = counter;
			counter--;
			// top left
			if (x - 1 < 0 && y - 1 < 0)
				y++;
			// bottom left
			else if (y + 1 >= size & x - 1 < 0)
				x++;
			// bottom right
			else if (x + 1 >= size && y + 1 >= size)
				y--;
			// top right
			else if (x + 1 >= size && y - 1 < 0)
				x--;
			// first left
			else if (x - 1 >= 0 && array[y][x - 1] == 0 && y - 1 < 0)
				x--;
			// first down
			else if (y + 1 < size && array[y + 1][x] == 0 && x - 1 < 0)
				y++;
			// first right
			else if (x + 1 < size && array[y][x + 1] == 0 && y + 1 >= size)
				x++;
			// first up
			else if (y - 1 >= 0 && array[y - 1][x] == 0 && x + 1 >= size)
				y--;
			// go left
			else if (array[y - 1][x] > 0 && array[y][x - 1] == 0)
				x--;
			// go down
			else if (array[y][x - 1] > 0 && array[y + 1][x] == 0)
				y++;
			// go right
			else if (array[y + 1][x] > 0 && array[y][x + 1] == 0)
				x++;
			// go up
			else if (array[y][x + 1] > 0 && array[y - 1][x] == 0)
				y--;
		}
		BigInteger sum = new BigInteger("0");
		for (int ypos = 0; ypos < size; ypos++) {
			for (int xpos = 0; xpos < size; xpos++) {
				if (xpos == ypos || ypos == (size - xpos - 1))
					sum = sum.add(new BigInteger(array[ypos][xpos] + ""));
			}
		}
		System.out.println(sum);
		
	}
}
