/**
 * Name: Arul Kolla
 * Date: 19/8/2
 * Program: GameOfLife
 */
package gameOfLifeFinal;
import java.util.Scanner;

public class GameOfLife {
	public static void main(String[] args) throws Exception {
        DisplayDriver dd = Display.getDriver();
        @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("Enter 1 for common Game of Life patterns, or 2 for a randomly generated board");
		int switchNum = in.nextInt();
		switch (switchNum) {
		case 1: //If you picked one
			System.out.println("Enter 1 for glider, 2 for pulsar, 3 for pentadecathlon");
			int switchNum2 = in.nextInt();
			switch (switchNum2) {
			case 1: //If you picked glider
				Board b1 = new Board(30, 30);
				Board.gliderSetup(); //Setup the board to a glider
		        for (int i = 0; i <= 60; i++) {
		        	dd.displayBoard(b1);
		            b1.doIt();
		            Thread.sleep(300);
		        }
				break;
			case 2: //If you picked pulsar
				Board b2 = new Board(15, 15);
				Board.pulsarSetup(); //Setup the board to a pulsar
		        for (int i = 0; i <= 50; i++) {
		        	dd.displayBoard(b2);
		            b2.doIt();
		            Thread.sleep(300);
		        }
				break;
			case 3: //If you picked pentadecathlon
				Board b3 = new Board(20, 20);
				Board.pentadecathlonSetup(); //Setup the board to a pentadecathlon
		        for (int i = 0; i <= 180; i++) {
		        	dd.displayBoard(b3);
		            b3.doIt();
		            Thread.sleep(200);
		        }
			default: //Defaults to glider
				System.out.println("Couldn't understand your input. Defaulting to glider. Please wait.");
				Thread.sleep(2000);
				Board bn = new Board(30, 30);
				Board.gliderSetup();
		        for (int i = 0; i <= 100; i++) {
		        	dd.displayBoard(bn);
		            bn.doIt();
		            Thread.sleep(300);
		        }
			}
			break;
		case 2: //If you wanted random
	        System.out.println("Enter number of iterations to run: ");
	        int iterations = in.nextInt();
	        System.out.println("Enter the size of the board: ");
	        int size = in.nextInt();
	        
	        Board b2 = new Board(size, size, 0.3);
	        for (int i = 0; i <= iterations; i++) { //Does as many iterations as asked for
	        	dd.displayBoard(b2);
	            b2.doIt();
	            Thread.sleep(100); //Gives a small pause between iterations
	        }
			break;
		default:
			System.out.println("Invalid! Try again.");
			break;
		}
    }
}
