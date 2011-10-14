package net.ciderpunk.tanktris.entities;

import java.awt.Graphics2D;

import net.ciderpunk.tanktris.IGameState;
import net.ciderpunk.tanktris.Screen;
import net.ciderpunk.tanktris.game.Game;
import net.ciderpunk.tanktris.graphics.Animation;
import net.ciderpunk.tanktris.graphics.Frame;

public class Shot extends PositionedEntity{
	
	static Frame oFrameShot;
	double dX;
	double dY;
	double dDX;
	double dDY;
	
	int iTime;
	
	public Shot(int x, int y, double iDirection, double dSpeed, int time) {
		super(x, y);
		dX = x;
		dY = y;
		dDX = Math.cos(iDirection - (Math.PI  / 2)) * dSpeed;
		dDY = Math.sin(iDirection - (Math.PI  / 2)) * dSpeed;
		iTime = time;
		
		
		// TODO Auto-generated constructor stub
	}

	public static void loadResources(Frame oSpriteSheet){
		oFrameShot = new Frame(oSpriteSheet,31,109,8,8,4,4);
	}
	

	public void update() {
		dX += dDX;
		dY += dDY;
		iX = (int) Math.round(dX);
		iY = (int) Math.round(dY);
		
		if (iTime-- == 0){
			Explosion oExp = new Explosion(iX, iY);
			Game.getInstance().registerEntity(oExp);
			this.remove();
		}
		
		if (iX > Screen.getInstance().getWidth() || iX < 0 || iY < 0 || iY > Screen.getInstance().getHeight()){
			this.remove();
		}
		
	}

	@Override
	public void draw(Graphics2D oG) {
		// TODO Auto-generated method stub
		oFrameShot.draw(oG, this.getX(), this.getY());
		
	}

	
	
	
}
