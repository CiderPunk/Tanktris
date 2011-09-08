package net.ciderpunk.tanktris;

import java.awt.*;

import net.ciderpunk.tanktris.entities.Gun;

public class Game implements IGameState {
	
	
	Gun oGun;
	
	
	public void init(){
		Gun.loadResources();
		oGun = new Gun(200,200);
	}
	
	public void update(long lTime){
		oGun.update(lTime);
	}
	
	protected int x;

	public void draw(Graphics2D oGraphics) {
		// TODO Auto-generated method stub
		oGraphics.setColor(Color.black);
		oGraphics.fillRect(0,0,800,600);
		oGraphics.setColor(Color.WHITE);
		oGraphics.drawString("motherfucker",x++, 20);
	
		
		
		oGun.draw(oGraphics);
	}
	
	
}
