package test;

public abstract class Car {
	private int speed;
	
	public Car(){
		this.speed  = 0;
	}



	public int getSpeed(){
		return this.speed;
	}
	public void setSpeed(int speed){
		this.speed = speed;
	}
	
	
}
