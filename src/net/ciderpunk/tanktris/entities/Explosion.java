package net.ciderpunk.tanktris.entities;

import java.awt.Graphics2D;

import net.ciderpunk.tanktris.graphics.*;

public class Explosion extends AnimatedEntity {

	static Animation oExplodeAnim;
	
	public static void loadResources(){
		Frame oBaseImg = new Frame("res/images/splosion.png");
		oExplodeAnim = new Animation(false);
		for (int i = 0; i<25; i++){
			int x = i % 8;
			int y = i / 8;
			oExplodeAnim.addFrame(new Frame(oBaseImg, x*100, y*100, 100,100,50,50), 2);
		}
	}
	
	
	public Explosion(int x, int y){
		super(x,y);	
		oAnimState.startAnim(oExplodeAnim);
	}
	
	
	@Override
	public void update() {
		super.update();
		if (oAnimState.getFrameCount() > 100){
			this.remove();
		}
	}

}
