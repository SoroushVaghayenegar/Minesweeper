package minsweeper;


import java.util.Arrays;
import java.util.Random;

public class Minesweeper {
	
	private Board board;
	private Difficulty difficulty;
	private boolean gameOver = false;
	
	
	public Minesweeper(int row, int col, Difficulty dif) {
		this.board = new Board(row,col);
		this.difficulty = dif;
		AssembleGame();
		refresh("");
	}
	
	public void click(int row, int col){
		String message = "";
		if(board.getCell(row, col).getType() == CellType.Bomb){
			this.gameOver = true;
			flipAll();
			message = "\n GAME OVER! Cell (" + (row+1) + "," + (col+1) + ") was a bomb ...";
		}
		
		else if (board.getCell(row, col).getType() == CellType.Number){
			board.getCell(row, col).flip();
			message ="Pick next one";
		}
		
		else{
			flipSurroundingEmpties(row,col);
			message ="Pick next one";
		}
		refresh(message);
	}
	
	private void flipSurroundingEmpties(int row, int col) {
		if(board.getCell(row, col) == null)
			return;
		if(board.getCell(row, col).getType() == CellType.Number){
			board.getCell(row, col).flip();
			return;
		}
		if(board.getCell(row, col).isFlipped())
			return;
			
		board.getCell(row, col).flip();
		flipSurroundingEmpties(row+1,col);
		flipSurroundingEmpties(row-1,col);
		flipSurroundingEmpties(row,col+1);
		flipSurroundingEmpties(row,col-1);
	}

	private void flipAll() {
		for(Cell[] row : board.getBoard()){
			for(Cell c : row)
				c.flip();
		}
		
	}

	//fill the board with boms, numbers and numbers
	private void AssembleGame() {
		
		//add bombs
		addBombs();
		
		
		// add numbers and empty spaces;
		for(int i=0 ; i<board.getRow() ; i++){
			for(int j=0 ; j<board.getColumn() ; j++){
				if(board.isCellNull(i, j)){
					int count = getNumOfSurroundingBombs(i,j);
					if(count == 0)
						board.setCellValue(i, j, CellType.Empty, " ");
					else
						board.setCellValue(i, j, CellType.Number, Integer.toString(count));
				}
			}
		}
		
	}
	
	private int getNumOfSurroundingBombs(int row, int col) {
		int result = 0;
		
		if(board.getCell(row-1, col) != null)
			result += board.getCell(row-1, col).isBomb() ? 1 : 0;
		
		if(board.getCell(row-1, col-1) != null)
			result += board.getCell(row-1, col-1).isBomb() ? 1 : 0;
		
		if(board.getCell(row-1, col+1) != null)
			result += board.getCell(row-1, col+1).isBomb() ? 1 : 0;
		
		if(board.getCell(row, col-1) != null)
			result += board.getCell(row, col-1).isBomb() ? 1 : 0;
		
		if(board.getCell(row, col+1) != null)
			result += board.getCell(row, col+1).isBomb() ? 1 : 0;
		
		if(board.getCell(row+1, col-1) != null)
			result += board.getCell(row+1, col-1).isBomb() ? 1 : 0;
		
		if(board.getCell(row+1, col) != null)
			result += board.getCell(row+1, col).isBomb() ? 1 : 0;
		
		if(board.getCell(row+1, col+1) != null)
			result += board.getCell(row+1, col+1).isBomb() ? 1 : 0;
		
		return result;
	}

	//adds bombs according to difficulty
	private void addBombs() {
		double numOfBombs = Math.ceil((double)(difficulty.getValue() * board.getColumn() * board.getRow()) / 100);
		Random rand = new Random();
		while(numOfBombs > 0){
			int row = rand.nextInt(board.getRow());
			int col = rand.nextInt(board.getColumn());
			if(board.isCellNull(row, col)){
				board.setCellValue(row, col, CellType.Bomb,  "*");
				numOfBombs--;
			}
		}
		
	}
	
	public boolean isGameOver(){
		return gameOver;
	}
	public void refresh(String message){
        
		for(Cell[] row : board.getBoard()){
			System.out.println(Arrays.toString(row));
		}
		if(!message.isEmpty())
			System.out.println(message);
	}
}
