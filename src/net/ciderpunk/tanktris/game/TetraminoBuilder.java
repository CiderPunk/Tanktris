package net.ciderpunk.tanktris.game;

public class TetraminoBuilder {

	
	//singleton pattern
	private static class TetraminoBuilderHolder{
		public static final TetraminoBuilder instance = new TetraminoBuilder();
	}
	
	//get instance
	public static TetraminoBuilder getInstance(){
		return TetraminoBuilderHolder.instance;
	}
	
	protected static Tetramino[] aTetraminos;
	
	
	protected TetraminoBuilder(){
		Tetramino[] aTetraminos = {
			new Tetramino( new Coord[]{ new Coord(0,1), new Coord(1,1), new Coord(1,0) },0),  // square
			new Tetramino( new Coord[]{new Coord(0,1), new Coord(0,2), new Coord(0,-1) },1), // line
			new Tetramino( new Coord[]{new Coord(-1,0), new Coord(-1,-1), new Coord(1,0) },3), // L
			new Tetramino( new Coord[]{ new Coord(-1,0), new Coord(-1,1), new Coord(1,0) },3), // J
			new Tetramino( new Coord[]{ new Coord(-1,0), new Coord(0,-1), new Coord(1,0) },3), // T
			new Tetramino( new Coord[]{ new Coord(-1,-1), new Coord(0,-1), new Coord(1,0) },3), // S
			new Tetramino( new Coord[]{ new Coord(-1,0), new Coord(-1,0), new Coord(1,-1) },3), // Z
		};
	}
	
	class Tetramino{
		Coord[] aCoords;
		int iRotations;	
		public Tetramino(Coord[] Coords, int iRots){
			aCoords = Coords;
			iRotations = iRots;
		}
		
	}
	
	class Coord{
		int x,y;
		public Coord(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	
	
	
}
