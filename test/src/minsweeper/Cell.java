package minsweeper;

public class Cell {
	
	private CellType type;
	private String value;
	private String valueToShow = "?";
	private boolean isFlipped = false;
	
	public Cell(CellType type, String value){
		this.type = type;
		this.value = value;
	}

	public CellType getType() {
		return type;
	}

	public String getValue() {
		return value;
	}

	public String getValueToShow() {
		return valueToShow;
	}
	
	public void flip(){
		this.valueToShow = this.value;
		this.isFlipped = true;
	}

	public boolean isFlipped() {
		return isFlipped;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public boolean isBomb(){
		return type == CellType.Bomb;
	}
	
	public String toString() {
        return valueToShow;
    }
}
