package net.ciderpunk.tanktris.entities;
import java.awt.*;
import net.ciderpunk.tanktris.graphics.Animation;

public abstract class Entity {
	
	public Entity(int x, int y){
		iX = x;
		iY = y;
	}
	
	int iX;
	int iY;

	public abstract void update();
	public abstract void draw(Graphics2D oG);
}
