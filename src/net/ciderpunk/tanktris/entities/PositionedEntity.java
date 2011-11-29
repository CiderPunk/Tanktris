package net.ciderpunk.tanktris.entities;

public abstract class PositionedEntity extends Entity{


	PositionedEntity (int x, int y){
		super();
		iX = x;
		iY = y;
	}
	
	int iX,iY;
	public synchronized int getX(){ return iX; }
	public synchronized int getY(){ return iY; }
	
}
