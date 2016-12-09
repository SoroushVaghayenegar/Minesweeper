package minsweeper;

public class Board {
	private Cell[][] board;
	private int row;
	private int column;
	
	public Board(int row, int col){
		this.board = new Cell[row][col];
		this.row = row;
		this.column = col;
	}

	public Cell[][] getBoard() {
		return board;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}
	
	public Cell getCell(int row, int col){
		if(row < 0 || row >= this.row)
			return null;
		if(col < 0 || col >= this.column)
			return null;
		return board[row][col];
	}
	
	public void setCellValue(int row, int col, CellType type, String val){
		if(board[row][col] == null){
			board[row][col] = new Cell(type, val);
		}
		else{
			board[row][col].setValue(val);
		}
	}
	
	public boolean isCellNull(int row, int col){
		return board[row][col] == null;
	}
}
