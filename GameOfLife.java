/**
 * GameOfLife main program - by Arul Kolla
 * Constructors: 
 */
package gameOfLife;

import java.util.Arrays;

public class GameOfLife {
	//Fields
	private char[][] board;
	private int length, width;
	
	//Constants
	public final char alive = '*';
	public final char dead = 'o'; //defines what the alive and dead character looks like
	
	//Constructors
	public GameOfLife() {
		board = new char[7][7]; //default board is 7 by 7
		Arrays.fill(board, dead);
		length = 7;
		width = 7;
	}
	public GameOfLife(int s) {
		board = new char[s][s]; //only one parameter makes it a square board
		Arrays.fill(board, dead);
		length = s;
		width = s;
	}
	public GameOfLife(int l, int w) {
		board = new char[l][w]; //two parameters makes it a rectangular board
		Arrays.fill(board, dead);
		length = l;
		width = w;
	}
	
	//Methods
	public int aliveNeighbors(int i, int j) { //returns the number of alive neighbors the cell (i, j) has [top left corner is (1, 1)]
		int total = 0;
		/*
		 * We have a lot of if-else to catch all the edge cases - literally.
		 * We need to catch the corners and edges because their neighbor counts are a little different.
		 * Don't worry if you get caught in the forest of if-else statements - there are comments as sign posts.
		 * There's probably a better way to do this :P
		 */
		if (i == 1) { //Go to left edge
			if (j == 1) { //Upper left corner
				if (board[0][1] == alive) total++;
				if (board[1][0] == alive) total++;
				if (board[1][1] == alive) total++; //Manually program the three neighbors, since this is actually more efficient
			}
			else if (j == board.length) { //Lower left corner
				if (board[0][board.length - 2] == alive) total++;
				if (board[1][board.length - 1] == alive) total++;
				if (board[1][board.length - 2] == alive) total++; //Manually program the three neighbors, since this is actually more efficient
			}
			else { //On the left edge
				
			}
		}
		else if (i == board[0].length) { //Go to right edge
			if (j == 1) { //Upper right corner
				if (board[board[0].length - 1][1] == alive) total++;
				if (board[board[0].length][0] == alive) total++;
				if (board[board[0].length][1] == alive) total++; //Manually program the three neighbors, since this is actually more efficient
			}
			else if (j == board.length) { //Lower right corner
				if (board[board[0].length - 1][board.length - 2] == alive) total++;
				if (board[board[0].length][board.length - 1] == alive) total++;
				if (board[board[0].length][board.length - 2] == alive) total++; //Manually program the three neighbors, since this is actually more efficient
			}
			else { //On the right edge
				
			}	
		}
		else if (j == 1) { //On the upper edge
			
		}
		else if (j == board.length) { //On the bottom edge
			
		}
		else { //Not an edge
			for (int k1 = i - 2; k1 <= i; k1++) {
				for (int k2 = j - 2; k2 <= j; k2++) {
					if (((k1 != i - 1) || (k2 != i - 1)) && (board[k1][k2] == alive)) total++; //Adds 1 every time it detects an alive cell
				}
			}
		}
		return total;
	}
}
