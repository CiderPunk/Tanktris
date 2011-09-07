package net.ciderpunk.tanktris.entities;

import java.awt.Graphics2D;

import net.ciderpunk.tanktris.graphics.Animation;

public class Gun extends Entity{

	
	static Animation oGunFire; 
	
	public static void loadResources(){
		oGunFire = new Animation(false);
		
	}

	@Override
	public void draw(Graphics2D oG) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
