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
	
	
	public void draw(Graphics oG){
		oG.setColor(Color.WHITE);
		oG.drawRect(iXOffs,iYOffs, iRows * BLOCK_WIDTH , iCols * BLOCK_HEIGHT);
	}
	
	

	
	protected class Column{
		Block[] aBlocks;
		Column(int iRows){
			aBlocks = new Block[iRows];
		}
	}
	
}
