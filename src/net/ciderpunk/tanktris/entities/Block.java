package net.ciderpunk.tanktris.entities;

import java.awt.Graphics2D;

import net.ciderpunk.tanktris.graphics.Frame;

public class Block extends Entity{

	
	static Frame oBlockFrame;
	
	public Block(int x,int y){
		super(x,y);
	}
	
	
	public static void loadResources(Frame oImg){
		Frame oBlockFrame = new Frame(oImg,0,127,36,36,0,0);
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
