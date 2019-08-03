/**
 * Name: Arul Kolla
 * Date: 19/8/2
 * Program: GameOfLife
 */
package gameOfLifeFinal;

public class Cell {
	//Fields
	private boolean state = false;
	private boolean newState;
	
	//Constructors
	public Cell() {
		//nothing here since state is already false
	}
	public Cell(boolean s) { //to initialize a cell
		state = s;
	}
	
	//Methods
	public void changeState(boolean s) { //temporarily changes the cell in a dummy state
		newState = s;
	}
	
	public void updateState() { //fully update the state of a cell once we are ready
		state = newState;
	}
	
	public boolean returnState() { //tell us the state of the cell
		return state;
	}
}
