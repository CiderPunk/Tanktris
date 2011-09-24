package net.ciderpunk.tanktris.entities;

import java.awt.Graphics2D;

import net.ciderpunk.tanktris.game.Grid;
import net.ciderpunk.tanktris.game.TetraminoBuilder;
import net.ciderpunk.tanktris.graphics.Frame;

public class Block extends Entity{
	
	static Frame oBlockFrame;
	int iRow;
	int iCol;
	boolean bMoving;
	Grid oOwnerGrid;
	double dSpeed;
	double dX;
	boolean bUpdated;
	boolean bAlive;
	
	
	Block[] aLinks;
	
	
	public Block(Grid grid, int col, int row, double speed){
		super(col * Grid.BLOCK_WIDTH + grid.getXOffs(), row * Grid.BLOCK_HEIGHT + grid.getYOffs());
		iRow = row;
		iCol = col;
		dSpeed = speed;
		dX = (double) iX;
		oOwnerGrid = grid;
		aLinks = new Block[4];
		bMoving = true;
		bUpdated = false;
	}
	
	
	//links this block up with its neighbours
	public void setLink(TetraminoBuilder.LinkDirection dir, Block block){
		aLinks[dir.ordinal()] = block;		
	}
	
	//removes self from tetramino
	public void unlinkSelf(){
		for (int i = 0; i < aLinks.length; i++){
			if (aLinks != null){
				aLinks[i].unlink(i);
			}
		}
	}
	
	
	//handles an unlink request from another component of the tetramino 
	private void unlink(int linkId) {
		linkId += 2;
		if (linkId > 3){
			linkId -= 4;
		}
		aLinks[linkId] = null;
	}


	public static void loadResources(Frame oImg){
		Frame oBlockFrame = new Frame(oImg,0,127,36,36,0,0);
	}
	
	public void Destroy(){
		bAlive = false;
		
	}
	
	
	public void stop(){
		if (bMoving){
			for (int i =0; i<aLinks.length; i++){
				if (aLinks[i]!= null){
					aLinks[i].stop();
				}
			}
			bMoving = false;
		}				
	}
	
	@Override
	public void update() {
		if (!bUpdated && bAlive && bMoving){	
	
			dX += dSpeed;
			iX = (int) Math.round(dX); 
			int iNewCol = (int)  Math.floor(dX - oOwnerGrid.getXOffs() / Grid.BLOCK_WIDTH);
			if (iNewCol != iCol){
				if (oOwnerGrid.isBlock(iNewCol, iRow)){
					
					
				}
				
				if (oOwnerGrid.isBlock(iNewCol, iRow)){
					//STOP MOVING
					iX = oOwnerGrid.getXOffs() + (iCol *  Grid.BLOCK_WIDTH);
					oOwnerGrid.fixBlock(this, iCol, iRow);
					bMoving = false;
				}
				else{
					iCol = iNewCol;
				}
			}
		}
	}


	@Override
	public void draw(Graphics2D oG) {
		
		iCol = (int)  Math.floor(dX - oOwnerGrid.getXOffs() / Grid.BLOCK_WIDTH);
		bUpdated = false;
		oBlockFrame.draw(oG,iX,iY);
		
	}

}
