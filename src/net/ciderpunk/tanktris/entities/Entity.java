package net.ciderpunk.tanktris.entities;
import java.awt.*;

import net.ciderpunk.tanktris.IGameState;
import net.ciderpunk.tanktris.game.Game;
import net.ciderpunk.tanktris.graphics.Animation;

public abstract class Entity extends LinkedEntity {
	
	Entity (int x, int y){
		iX = x;
		iY = y;
	}
	
	int iX,iY;
	
	public int getX(){return iX;}
	public int getY(){return iY;}
	
 
	public abstract void update();
	public abstract void draw(Graphics2D oG);
}
