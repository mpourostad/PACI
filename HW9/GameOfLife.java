import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class GameOfLife {
    public static void main(String[] args) throws IOException { 
    	final int M = 25;
    	final int N = 75;
		Scanner consoleReader = new Scanner(System.in);
		System.out.print ("Which file do you want to open?");
		String filename = consoleReader.next();
		File file = new File(filename);
		Scanner fileReader = null;
		try { 
		   fileReader = new Scanner (file);
		}
		catch (Exception e) {
		   System.out.print("file " + file + " does not exist");
		   System.exit(0);
		}
		
		char [][] original = new char[M][N];
		for (int i = 0; i < original.length; i++ ) {
			String line = fileReader.nextLine();
			for (int j = 0; j < original[i]. length; j++) {
				original[i][j] = line.charAt(j);
			}
		}
		for (int i = 0; i < M; i++ ) {
			for (int j = 0; j < N; j++) {
				System.out.print(original[i][j] + " ");
			}
			System.out.println();
		}
		// currentState array takes the value of the previous world.
		char [][] currentState = new char [M][N];
		for (int i = 0; i < original.length; i++ ) {
			for (int j = 0; j < original[i].length; j++) {
				currentState[i][j] = original[i][j];
			}
		}
		// futureBoard is the latest generation created from the previous world.
		char [][] futureBoard = new char [M][N];
		boolean equal = false;
		int count = 0;
		while(true) {
			count ++;
			System.out.println();
			System.out.println("generation " + count);
			System.out.println();
			char input = input();
			if (input == '1') {
//creating a new array with padding from the current state of the grid.				
				char [][] paddedBoard = pad(currentState);
				for (int i = 0; i < original.length; i++ ) {
					for (int j = 0; j < original[i]. length; j++) {
/* make a new version by going through each element in "CheckNeighbor" method and change their value accordingly. 
 * "checkNeighbor" takes the output of "getPartOfArray" which is a 3x3 array as a parameter.*/
						futureBoard[i][j] = checkNeighbor(getPartOfArray(paddedBoard, j + 1, i + 1));
					}
				}
				if (isAllDead(futureBoard) == true) {
					for (int i = 0; i < original.length; i++ ) {
						for (int j = 0; j < original[i]. length; j++) {
							System.out.print(futureBoard[i][j] + " ");
						}
						System.out.println();
					}
					System.out.println();
					System.out.println("No alive organism has been found. \n GAME OVER! ");
					System.exit(0);
				}
				if (isEqual(futureBoard, currentState) == true) {
					for (int i = 0; i < original.length; i++ ) {
						for (int j = 0; j < original[i]. length; j++) {
							System.out.print(currentState[i][j] + " ");
						}
						System.out.println();
					}
					System.out.println();
					System.out.println("the world is the same as the previous one. \n GAME OVER!");
					System.exit(0);
				}
				else {
					for (int i = 0; i < original.length; i++ ) {
						for (int j = 0; j < original[i]. length; j++) {
							currentState[i][j] = futureBoard[i][j];
						}
					}	
					for (int i = 0; i < original.length; i++ ) {
						for (int j = 0; j < original[i]. length; j++) {
							System.out.print(currentState[i][j] + " ");
						}
						System.out.println();
					}
					System.out.println("\n");
				}
			}
		}			
    }
    /* takes a 3x3 array and counts the number of "x"s in the array. 
     * it changes the element in the center of the given array and 
     * changes it based on the count of "X"s in other. */
    public static char checkNeighbor(char [][] neighbor) {
    	int count = 0;
    	for (int i = 0; i < 3; i++) {
    		for (int j = 0; j < 3; j++) {
    			if (neighbor[i][j].contains('X')) {
    				count++;
    			}
    		}
    	}
    	for (int i = 0; i < 3; i++) {
    		for (int j = 0; j < 3; j++) {
    			if (neighbor[1][1] == 'X') {
    				count --;
    				if (count == 2 || count == 3) {
    					return 'X';
    				}
    				else {
    					return '.';
    				}
    			}
    			if(neighbor [1][1] == '.') {
    				if (count == 3) {
    					return 'X';
    				}
    			}
    		}
    	}
    	return '.';
    }
    //takes two arrays and checks if they are the same.
    public static boolean isEqual(char [][] currentState, char [][] futureBoard) {
    	for (int i = 0; i < currentState.length; i++) {
    		for (int j = 0; j < currentState[i].length; j++) {
    			if (currentState[i][j] != futureBoard[i][j]) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
    // checks the array to see if it only contains dots.
    public static boolean isAllDead(char [][] board) {
    	for (int i = 0; i < board.length; i++) {
    		for (int j = 0; j < board[i].length; j++) {
    			if(board[i][j] != '.') {
    				return false;
    			}
    		}	
    	}
    	return true;
    }
    /* create two additional rows and two additional columns for the beginning and end of the give array. in this case the additional
     * rows and columns with dots. */
	public static char [][] pad(char [][] board){
		int row = board.length;
		int column = board[0].length;
		char [][] pad = new char [row + 2][column + 2];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				pad[i + 1][j + 1] = board [i][j];
			}
		}
		for (int i = 0; i < row + 2; i++) {
			for (int j = 0; j < column + 2; j++) {
				if ( pad[i][j] == '\0') {
					pad[i][j] = '.';
				}
			}
		}
		return pad;
	}
// takes a char and coordinates of an element, and return a 3x3 array with the given element in the center. 
	 public static char[][] getPartOfArray(char[][] source, int x, int y) {
		 char [][] part = new char [3][3];
		 int countX = 0; 
		 int countY = 0;
		 for (int i = y - 1 ; i < y + 2; i++) {
			 countX = 0;
			 for (int j = x - 1; j < x + 2; j++) {
				 part [countY][countX] = source [i][j];
				 countX++;
			 }
			 countY++;
		 }
		 return part;
	 }
	 public static char input() {
		boolean correctUserInput = false;
		int count = 0;
		char entry = '0';
		while(correctUserInput == false){
			count ++;
			if(count == 1){
				Scanner input = new Scanner(System.in);
				System.out.println("Please enter \" 1 \" if you would like to see next generation \n "
						+ "Enter \"Q\" to exit the game");
				System.out.println();
				System.out.print("input: ");
				entry = input.next().charAt(0);
			}	
			else{
				Scanner input = new Scanner(System.in);
				System.out.println("Error, Please choose either \"1\" or \"Q\". ");
				System.out.println();
				System.out.print("input: ");
				entry = input.next().charAt(0);
			}

			if(entry == '1' || entry == 'Q'){
				correctUserInput = true;
			}
			if(entry == 'Q'){
				System.exit(0);
			}	
		}
		return entry;
	}
}
