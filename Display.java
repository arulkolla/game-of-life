/**
 * Name: Arul Kolla
 * Date: 19/8/2
 * Program: GameOfLife
 */
package gameOfLifeFinal;

import java.awt.AWTException;

public class Display {
	public static DisplayDriver getDriver() throws AWTException {
        DisplayDriver driver;
        driver = new ConsoleDriver();
        return driver; //Display the board
    }
	
	private static class ConsoleDriver extends Console {
        public void displayBoard(Board board) {
            super.displayBoard(board); //Make a way to display the board
        }
    }
}
