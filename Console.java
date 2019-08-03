/**
 * Name: Arul Kolla
 * Date: 19/8/2
 * Program: GameOfLife
 */
package gameOfLifeFinal;

public class Console implements DisplayDriver {
	@Override //Override the DisplayDriver interface method
	public void displayBoard(Board board) {
		Cell[][] plane = Board.returnPlane();
		String border = String.format("+%0" + 2 * plane.length + "d+", 0).replace("0", "-"); //Get top row of the border
        
        System.out.println(border); //Print top row of border
        
        for (Cell[] row : plane) {
            String r = "|";
            for (Cell c : row) {
                if (c.returnState() == true) {r += " \u25a0";} //add circle for alive cell
                else {r += "  ";} //leave space for dead cell
            }
            r += "|";
            System.out.println(r);
        }
        
        System.out.println(border); //Print bottom row of border
	}
}
