package net.ciderpunk.tanktris.entities;

import java.awt.Graphics2D;

import net.ciderpunk.tanktris.graphics.*;


public class Gun extends AnimatedEntity{


	//animations	
	static Animation oAnimGunFire; 
	static Animation oAnimIdle; 
	static Frame oFrameIdle;

	double iRads;
	
	public static void loadResources(){
		
		Frame oImg = new Frame("res/images/sprites.png");
		Frame oFrameIdle = new Frame(oImg,0,0,36,96,19,96);
		
		oAnimIdle = new Animation(false);
		oAnimIdle.addFrame(oFrameIdle,0);
		
		oAnimGunFire = new Animation(false);
		oAnimGunFire.addFrame(new Frame(oImg,0,0,36,96,19,96),3);
		oAnimGunFire.addFrame(new Frame(oImg,36,0,36,96,19,96),3);
		oAnimGunFire.addFrame(new Frame(oImg,72,0,36,96,19,96),3);
		oAnimGunFire.addFrame(new Frame(oImg,108,0,36,96,19,96),3);
		oAnimGunFire.addFrame(new Frame(oImg,144,0,36,96,19,96),3);
		oAnimGunFire.addFrame(new Frame(oImg,180,0,36,96,19,96),3);
		oAnimGunFire.addFrame(new Frame(oImg,216,0,36,96,19,96),3);
		oAnimGunFire.addFrame(new Frame(oImg,252,0,36,96,19,96),3);
		oAnimGunFire.addFrame(new Frame(oImg,288,0,36,96,19,96),3);
		oAnimGunFire.addFrame(new Frame(oImg,324,0,36,96,19,96),3);
		oAnimGunFire.addFrame(new Frame(oImg,360,0,36,96,19,96),3);
		oAnimGunFire.addFrame(new Frame(oImg,396,0,36,96,19,96),3);
		oAnimGunFire.addFrame(new Frame(oImg,432,0,36,96,19,96),3);
		oAnimGunFire.addFrame(oFrameIdle,0);	
		
	}
	
	
	public Gun(int x, int y){
		super(x,y);
		oAnimState.startAnim(oAnimIdle);
	}
	
	public void Fire(){
		oAnimState.startAnim(oAnimGunFire);
	}

	
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		super.update();	
		iRads+= 0.01;
	}


	@Override
	public void draw(Graphics2D oG) {
		this.oAnimState.getFrame().drawRotate(oG, this.iX, this.iY, iRads);
	}



	
	
	
}
