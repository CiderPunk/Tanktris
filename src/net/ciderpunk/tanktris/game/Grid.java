package net.ciderpunk.tanktris.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import net.ciderpunk.tanktris.entities.Block;
import net.ciderpunk.tanktris.entities.LinkedEntity;

public class Grid {

	public final static  int BLOCK_WIDTH = 36;
	public final static  int BLOCK_HEIGHT = 36; 
	
	protected final LinkedEntity oMovingHead;
	
	int iRows;
	int iCols;
	int iXOffs;
	int iYOffs;
	
	Column[] aCols;
	
	public Grid(int rows, int cols, int xoff, int yoff){
		oMovingHead = new LinkedEntity();
		iRows = rows;
		iCols = cols;
		iXOffs = xoff;
		iYOffs = yoff;
		aCols = new Column[iCols];
		for (int i = 0; i < iCols; i++){
			aCols[i] = new Column(iRows);
		}
	}
	
	
	public synchronized int getRows() {
		return iRows;
	}

	public synchronized int getCols() {
		return iCols;
	}

	public synchronized int getXOffs() {
		return iXOffs;
	}
	
	public synchronized int getYOffs() {
		return iYOffs;
	}

	public void registerBlock(Block oblock){
		this.oMovingHead.insert(oblock);
	}

	public void draw(Graphics2D oG){
		oG.setColor(Color.WHITE);
		oG.drawRect(iXOffs,iYOffs, iRows * BLOCK_WIDTH , iCols * BLOCK_HEIGHT);
		for (int i = 0; i < iCols; i++){
			aCols[i].draw(oG);
		}
		Block oBlock = (Block) oMovingHead.getNext();
		while(oBlock != null){
			oBlock.draw(oG);
			oBlock = (Block)oBlock.getNext();
		}
	}
	
	//check for a collision
	public boolean isBlock(int col, int row){
		//check for end column
		if (col > iCols){
			return true;
		}
		return aCols[col].isBlock(row);
	}

	public void createBlock(){
		TetraminoBuilder.getInstance().buildTetramino(this);
	}
	
	
	protected class Column{
		Block[] aBlocks;
		
		Column(int iRows){
			aBlocks = new Block[iRows];
		}
				
		//checks if a row is fully populated
		public boolean isfull(){
			for (int i = 0; i < aBlocks.length; i++){
				if (aBlocks[i] == null){
					return false;
				}
			}
			return true;
		}
		
		//checks for a block att he specified row
		public boolean isBlock(int iRow){
			return (aBlocks[iRow] == null);
		}
		
		protected void draw(Graphics2D oG){
			for (int i = 0; i < aBlocks.length; i++){
				if (aBlocks[i] != null){
					aBlocks[i].draw(oG);
				}
			}
			
		}
		
		
	}


	public void fixBlock(Block oBlock, int iCol, int iRow) {
		
		
	}
	
}
