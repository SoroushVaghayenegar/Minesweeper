package application;



import java.util.Arrays;
import java.util.Scanner;

import minsweeper.Difficulty;
import minsweeper.Minesweeper;
import sorting.InsertionSort;

public class Application {

	public static void main(String[] args) {
		//start game
		Minesweeper m = new Minesweeper(5,5,Difficulty.Easy);
		
		while(!m.isGameOver()){
			Scanner reader = new Scanner(System.in);  // Reading from System.in
			System.out.println("\nEnter a row: ");
			int row = reader.nextInt();
			System.out.println("Enter a column: ");
			int col = reader.nextInt();
			
			m.click(row-1, col-1);
		}

	}

}
