package minsweeper;

public enum Difficulty {
	Easy(10), Medium(20), Hard(30);
	
	private int val;
	
	private Difficulty(int val){
		this.val = val;
	}
	
	public int getValue(){
		return val;
	}
}
