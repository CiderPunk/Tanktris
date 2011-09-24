package net.ciderpunk.tanktris.game;

import java.awt.Color;
import java.awt.Graphics;

import net.ciderpunk.tanktris.entities.Block;

public class Grid {

	
	
	
	public final static  int BLOCK_WIDTH = 36;
	public final static  int BLOCK_HEIGHT = 36; 
	
	int iRows;
	int iCols;
	int iXOffs;
	int iYOffs;
	
	Column[] aCols;
	
	public Grid(int rows, int cols, int xoff, int yoff){
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


	public void draw(Graphics oG){
		oG.setColor(Color.WHITE);
		oG.drawRect(iXOffs,iYOffs, iRows * BLOCK_WIDTH , iCols * BLOCK_HEIGHT);
	}
	
	//check for a collision
	public boolean isBlock(int col, int row){
		//check for end column
		if (col > iCols){
			return true;
		}
		return aCols[col].isBlock(row);
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
	}


	public void fixBlock(Block oBlock, int iCol, int iRow) {
		
		
	}
	
}
