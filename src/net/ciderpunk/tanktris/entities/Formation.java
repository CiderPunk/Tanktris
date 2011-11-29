package net.ciderpunk.tanktris.entities;

import java.awt.Graphics2D;

import net.ciderpunk.tanktris.game.Grid;

public abstract class Formation extends PositionedEntity {
	
	final LinkedEntity oBlockHead;
	final Grid oGrid;
	
	//constructor
	Formation(Grid grid, int col, int row){
		super(grid.getXOffs() + (col * Grid.BLOCK_WIDTH), grid.getYOffs() + (row * Grid.BLOCK_HEIGHT));
		oGrid = grid;
		oBlockHead = new LinkedEntity(); 
	}
	
	
	public Block getBlock(int iX,int iY){
		
	}
	
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D oG) {
		// TODO Auto-generated method stub
		Entity oBlock = (Entity) oBlockHead.getNext();
		
				
		while(oBlock != null){
			oBlock = (Entity) oBlock.getNext();
			oBlock.draw(oG);
		}
		
	}




/*
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}





	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}
*/
}
