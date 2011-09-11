package net.ciderpunk.tanktris.entities;
import java.awt.*;
import net.ciderpunk.tanktris.graphics.Animation;

public abstract class Entity extends LinkedEntity {
	


	public abstract int getX();
	public abstract int getY();
	
 
	public abstract void update();
	public abstract void draw(Graphics2D oG);
}
