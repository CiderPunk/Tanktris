package net.ciderpunk.tanktris.entities;

import java.awt.Graphics2D;

import net.ciderpunk.tanktris.graphics.*;


public class Gun extends AnimatedEntity{

		
	static Animation oGunFire; 
	
	AnimationState oAnim;
	
	
	
	public static void loadResources(){
		Frame oImg = new Frame("res/images/sprites.png");
		oGunFire = new Animation(false);
		oGunFire.addFrame(new Frame(oImg,0,0,36,96),20);
		oGunFire.addFrame(new Frame(oImg,36,0,36,96),20);
		oGunFire.addFrame(new Frame(oImg,72,0,36,96),20);
		oGunFire.addFrame(new Frame(oImg,108,0,36,96),20);
		oGunFire.addFrame(new Frame(oImg,144,0,36,96),20);
		oGunFire.addFrame(new Frame(oImg,180,0,36,96),20);
		oGunFire.addFrame(new Frame(oImg,216,0,36,96),20);
		oGunFire.addFrame(new Frame(oImg,252,0,36,96),20);
		oGunFire.addFrame(new Frame(oImg,288,0,36,96),20);
		oGunFire.addFrame(new Frame(oImg,324,0,36,96),20);
		oGunFire.addFrame(new Frame(oImg,360,0,36,96),20);
		oGunFire.addFrame(new Frame(oImg,396,0,36,96),20);
		oGunFire.addFrame(new Frame(oImg,432,0,36,96),20);
		oGunFire.addFrame(new Frame(oImg,468,0,36,96),20);	
	}
	
	
	public Gun(int x, int y){
		super(x,y);
	
	}
	
	public void Fire(){
		oAnimState.startAnim(oGunFire);
	}


	@Override
	public void update(long lTime) {
		oAnim.update(lTime);
		
	}


	
	
	
}
