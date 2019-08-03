/**
 * Name: Arul Kolla
 * Date: 19/8/2
 * Program: GameOfLife
 */
package gameOfLifeFinal;

public class Board {
	//Fields
	private static Cell[][] plane;
	private int height = 7;
	private int width = 7;
	
	//Constructors
	public Board(Cell[][] g) {
        Board.plane = g;
        height = width = g.length;
    }
	
	public Board(int h, int w) { //Given a height and width, create a board with all dead cells
		height = h;
        width = w;
        plane = new Cell[height][width];
	}
	
	public Board(int h, int w, double p) { //Given a height, width, and probability that any cell is alive
        height = h;
        width = w;
        plane = new Cell[height][width];
        
        for (int i = 0; i < plane.length; i++){
            for (int j = 0; j < plane[i].length; j++){
                plane[i][j] = new Cell();
                if (Math.random() <= p){
                    plane[i][j].changeState(true);
                    plane[i][j].updateState();
                }
            }
        }
    }
	
	//Methods
	public static Cell[][] returnPlane() { //Give back the plane
		return plane;
	}
	    
	public int returnWidth() { //Give back the width
		return width;
	}
	
	public int returnHeight() { //Give back the height
		return height;
	}
	
	public boolean isAlive(int row, int col) { //Check if a cell is alive
        return plane[row][col].returnState();
    }
	
	public int neighborsSum(int row, int col) { //Find total number of alive cells
		int total = 0;
		
		if (row != 0 && col != 0) { //1 up, 1 left from our cell
			if (isAlive(row - 1, col - 1)) {total++;}
		}
		if (row != 0) { //1 up from our cell
			if (isAlive(row - 1, col)) {total++;}
		}
		if (row != 0 && col != width - 1) { //1 up, 1 right from our cell
			if (isAlive(row - 1, col + 1)) {total++;}
		}
		if (col != 0) { //1 left from our cell
			if (isAlive(row, col - 1)) {total++;}
		}
		if (col != width - 1) { //1 right from our cell
			if (isAlive(row, col + 1)) {total++;}
		}
		if (row != height - 1 && col != 0) { //1 down, 1 left from our cell
			if (isAlive(row + 1, col - 1)) {total++;}
		
		}
		if (row != height - 1) { //1 down from our cell
			if (isAlive(row + 1, col)) {total++;}
		}
		if (row != height - 1 && col != width - 1) { //1 down, 1 right from our cell
			if (isAlive(row + 1, col + 1)) {total++;}
		}
		
		return total;
	}
	
	private void checkRules() { //sort of like "preparation" before we actually change
        for (int h = 0; h < plane.length; h++){
            for (int w = 0; w < plane[0].length; w++){
                int number = neighborsSum(h, w);
                /*
                 * Here is where you can change the rules.
                 */
                if (number < 2) { plane[h][w].changeState(false);}  //underpopulation 
                else if (number > 3) { plane[h][w].changeState(false);} //overcrowdedness
                else if (number == 3) { plane[h][w].changeState(true);} //birth
                else if (number == 2) { plane[h][w].changeState(plane[h][w].returnState());} // don't change
            }
        }
    }

    private void changeCell() { //actually changing
        for (int h = 0; h < plane.length; h++){
            for (int w = 0; w < plane[h].length; w++){
                plane[h][w].updateState();
            }
        }
    }
    
    public void doIt() { //Both of the above in one step
    	checkRules();
    	changeCell();
    }
    
    public static void gliderSetup() {
    	for (int i = 0; i < plane.length; i++){
            for (int j = 0; j < plane[i].length; j++){
                plane[i][j] = new Cell(); //Initialize all the cells
            }
        }
    	
    	plane[1][2].changeState(true); //Change the glider cells to true
    	plane[2][3].changeState(true);
    	plane[3][1].changeState(true);
    	plane[3][2].changeState(true);
    	plane[3][3].changeState(true);
    	
    	plane[1][2].updateState();
    	plane[2][3].updateState();
    	plane[3][1].updateState();
    	plane[3][2].updateState();
    	plane[3][3].updateState();
    }
    
    public static void pulsarSetup() {
    	for (int i = 0; i < plane.length; i++){
            for (int j = 0; j < plane[i].length; j++){
                plane[i][j] = new Cell(); //Initialize all the cells
            }
        }
    	int a = 1;
    	plane[1][3].changeState(true); //Change the pulsar cells to true
    	plane[1][4].changeState(true);
    	plane[1][5].changeState(true);
    	plane[1][9].changeState(true);
    	plane[1][10].changeState(true);
    	plane[1][11].changeState(true);
    	for (int i = 3; i <= 5; i++) {
        	plane[i][1].changeState(true);
        	plane[i][6].changeState(true);
        	plane[i][8].changeState(true);
        	plane[i][13].changeState(true);
    	}
    	a = 6;
    	plane[a][3].changeState(true);
    	plane[a][4].changeState(true);
    	plane[a][5].changeState(true);
    	plane[a][9].changeState(true);
    	plane[a][10].changeState(true);
    	plane[a][11].changeState(true);
    	a = 8;
    	plane[a][3].changeState(true);
    	plane[a][4].changeState(true);
    	plane[a][5].changeState(true);
    	plane[a][9].changeState(true);
    	plane[a][10].changeState(true);
    	plane[a][11].changeState(true);
    	for (int i = 9; i <= 11; i++) {
        	plane[i][1].changeState(true);
        	plane[i][6].changeState(true);
        	plane[i][8].changeState(true);
        	plane[i][13].changeState(true);
    	}
    	a = 13;
    	plane[a][3].changeState(true);
    	plane[a][4].changeState(true);
    	plane[a][5].changeState(true);
    	plane[a][9].changeState(true);
    	plane[a][10].changeState(true);
    	plane[a][11].changeState(true);
    	
    	for (int i = 0; i < plane.length; i++){
            for (int j = 0; j < plane[i].length; j++){
                plane[i][j].updateState(); //Update all the cells
            }
        }
    }
    
    public static void pentadecathlonSetup() {
    	for (int i = 0; i < plane.length; i++){
            for (int j = 0; j < plane[i].length; j++){
                plane[i][j] = new Cell(); //Initialize all the cells
            }
        }
    	
    	plane[2][6].changeState(true); //Change the pentadecathlon cells
    	plane[2][11].changeState(true);
    	plane[4][6].changeState(true);
    	plane[4][11].changeState(true);	
    	for (int i = 4; i <= 13; i++) {
        	plane[3][i].changeState(true);
    	}
    	plane[3][6].changeState(false);
    	plane[3][11].changeState(false);
    			
    	for (int i = 0; i < plane.length; i++){
            for (int j = 0; j < plane[i].length; j++){
                plane[i][j].updateState(); //Update all the cells
            }
        }
    }
}
