package net.ciderpunk.tanktris;

import java.awt.*;

import net.ciderpunk.tanktris.entities.Gun;
import net.ciderpunk.tanktris.graphics.Frame;

public class Game implements IGameState {
	
	
	Gun oGun;
	Frame oImage;


	public void init(){
		Gun.loadResources();
		oGun = new Gun(200,200);
		oGun.Fire();
		Frame oImg = new Frame("res/images/sprites.png");
		oImage = new Frame(oImg,0,0,36,96);
	}
	
	public void update(){
		oGun.update();
	}
	
	protected int x;

	public void draw(Graphics2D oGraphics) {
		// TODO Auto-generated method stub
		oGraphics.setColor(Color.green);
		oGraphics.fillRect(0,0,800,600);
		oGraphics.setColor(Color.WHITE);
		oGraphics.drawString("test",x++, 20);
		
		//oImage.draw(oGraphics, 100,100);
		oGun.draw(oGraphics);
	}
	
	
}
