package net.ciderpunk.tanktris.game;

import net.ciderpunk.tanktris.entities.Block;

public class TetraminoBuilder {

	
	
 public enum LinkDirection{
		LINK_UP,
		LINK_RIGHT,
		LINK_DOWN,
		LINK_LEFT,
	}
	
	
	//singleton pattern
	private static class TetraminoBuilderHolder{
		public static final TetraminoBuilder instance = new TetraminoBuilder();
	}
	
	//get instance
	public static TetraminoBuilder getInstance(){
		return TetraminoBuilderHolder.instance;
	}
	
	protected final  Tetramino[] aTetraminos;
	
	
	protected TetraminoBuilder(){
		Tetramino[] aTets = {
			new Tetramino( new Point[]{ new Point(0,0), new Point(0,1), new Point(1,1), new Point(1,0) },1),  // square
			new Tetramino( new Point[]{ new Point(0,0), new Point(0,1), new Point(0,2), new Point(0,-1) },2), // line
			new Tetramino( new Point[]{ new Point(0,0), new Point(-1,0), new Point(-1,-1), new Point(1,0) },4), // L
			new Tetramino( new Point[]{ new Point(0,0), new Point(-1,0), new Point(-1,1), new Point(1,0) },4), // J
			new Tetramino( new Point[]{ new Point(0,0), new Point(-1,0), new Point(0,-1), new Point(1,0) },4), // T
			new Tetramino( new Point[]{ new Point(0,0), new Point(-1,-1), new Point(0,-1), new Point(1,0) },4), // S
			new Tetramino( new Point[]{ new Point(0,0), new Point(-1,0), new Point(-1,0), new Point(1,-1) },4), // Z
		};
		aTetraminos = aTets;
	}
	
	
	public void buildTetramino(Grid oGrid){
	//pick a random tetramino
		int id = (int) Math.floor(Math.random() * (double) aTetraminos.length);
		aTetraminos[id].buildTetramino(oGrid);
	}
	
	
	class Tetramino{
		
		Shape[] aShapes;
		
		public Tetramino(Point[] points, int iRots){
			aShapes = new Shape[iRots];
			for (int i = 0; i< iRots; i++){
				aShapes[i] = new Shape(points);
				//rotate coords thru 90 degrees
				for (int j = 0; j < points.length; j++){
					points[j].rotate90();
				}
			}
		}

		public void buildTetramino(Grid oGrid) {
			//pick a random shape
			int id = (int) Math.floor(Math.random() * (double) aShapes.length);
			aShapes[id].buildShape(oGrid);
			
			
		}
	}
	
	
	
	
	
	class Shape{

		Point[] aPoints;
		int iWidth;
		int iHeight;
		int iXoffs;
		int iYoffs;
		
		
		protected int getLink(int x, int y,Point[] points){
			for (int i = 0; i < points.length; i++){
				if (points[i].x == x && points[i].y == y){
					return i;
				}
			}
			return  -1;
		}
		
		public void buildShape(Grid oGrid) {
			Block[] aBlocks = new Block[aPoints.length];
			//pick a row
			int iRow =  (int) Math.floor(Math.random() * (double) (oGrid.iRows - iHeight)) + iYoffs;
			//int iCol = iYoffs;
			int iCol = 5;
			//create blocks
			for (int i = 0; i < aPoints.length; i++){
				aBlocks[i] = new Block(oGrid, iCol + aPoints[i].x, iRow + aPoints[i].y, 0.4);
				oGrid.registerBlock(aBlocks[i]);
			}
			//create links
			for (int i = 0; i < aPoints.length; i++){
			
			}
			
		}

		public Shape(Point[] points){
			aPoints = new Point[points.length];
			int iXmax = 0, iXmin = 0,iYmax = 0,iYmin = 0;
			for (int i = 0; i < points.length; i++){
				iXmin = (points[i].x < iXmin ? points[i].x : iXmin);
				iXmax = (points[i].x > iXmax ? points[i].x : iXmax);
				iYmin = (points[i].x < iYmin ? points[i].x : iYmin);
				iYmax = (points[i].x > iYmax ? points[i].x : iYmax);
				//copy point
				aPoints[i] = new Point(points[i]);
				//build links
				aPoints[i].setLink(LinkDirection.LINK_UP, getLink(aPoints[i].x, points[i].y - 1, points));
				aPoints[i].setLink(LinkDirection.LINK_DOWN, getLink(aPoints[i].x, points[i].y + 1, points));
				aPoints[i].setLink(LinkDirection.LINK_LEFT, getLink(aPoints[i].x - 1, points[i].y, points));
				aPoints[i].setLink(LinkDirection.LINK_RIGHT, getLink(aPoints[i].x + 1, points[i].y, points));
			}
			iWidth = iXmax - iXmin;
			iHeight = iYmax - iYmin;
			iXoffs = iXmin;
			iYoffs = iYmin;
		}
	}
	
	
	
	
	class Point{
		int x,y;
		int[] aLinks;
		
		public Point(Point p){
			this(p.x, p.y);
		}
		
		
		public void  rotate90(){
			int iNewX = y;
			y = x * -1;
			x = iNewX;
		}
		
		public Point(int x, int y){
			this.x = x;
			this.y = y;
			aLinks = new int[4];
		}
		
		public int getLink(LinkDirection dir){
			return aLinks[dir.ordinal()];
		}
		
		public void setLink(TetraminoBuilder.LinkDirection dir, int block){
			aLinks[dir.ordinal()] = block;
		}
		
	}

	
	
	
}
