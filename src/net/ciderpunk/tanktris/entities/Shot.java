package net.ciderpunk.tanktris.entities;

import java.awt.Graphics2D;

import net.ciderpunk.tanktris.graphics.Animation;
import net.ciderpunk.tanktris.graphics.Frame;

public class Shot extends Entity{
	
	
	
	
	public Shot(int x, int y, double iDirection, double dblSpeed) {
		super(x, y);
		
		
		
		// TODO Auto-generated constructor stub
	}

	public static void loadResources(Frame oSpriteSheet){
		Frame oFrameShot = new Frame(oSpriteSheet,0,0,36,96,19,104);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D oG) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
