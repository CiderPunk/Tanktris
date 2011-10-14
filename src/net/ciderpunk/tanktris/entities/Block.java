package net.ciderpunk.tanktris.entities;

import java.awt.Graphics2D;

import net.ciderpunk.tanktris.game.Grid;
import net.ciderpunk.tanktris.graphics.Frame;

public class Block extends Entity {

	static Frame oBlockFrame;
	Formation oOwner;
	int iXoffs;
	int iYoffs;
	
	Block(Formation formation, int xoff, int yoff) {
		super();
		oOwner = formation;
		iXoffs = xoff;
		iYoffs = yoff;
	}
	
	public static void loadResources(Frame oImg){
		oBlockFrame = new Frame(oImg,0,127,36,36,0,0);
	}
	
	

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics2D oG) {
		// TODO Auto-generated method stub
		oBlockFrame.draw(oG, getX(), getY());

	}

	@Override
	public int getX() {
		return oOwner.getX() + iXoffs * Grid.BLOCK_WIDTH;
	}

	@Override
	public int getY() {
		return oOwner.getX() + iYoffs * Grid.BLOCK_HEIGHT;
	}

}
