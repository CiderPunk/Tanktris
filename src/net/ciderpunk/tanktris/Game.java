package net.ciderpunk.tanktris;

import java.awt.*;

public class Game implements IGameState {
	
	public void init(){
		
	}
	
	public void update(long lTime){
		
	}
	
	protected int x;

	public void draw(Graphics2D oGraphics) {
		// TODO Auto-generated method stub
		oGraphics.setColor(Color.black);
		oGraphics.fillRect(0,0,800,600);
		oGraphics.setColor(Color.WHITE);
		oGraphics.drawString("motherfucker",x++, 20);
		
	}
	
	
}
