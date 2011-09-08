package net.ciderpunk.tanktris.entities;

import java.awt.Graphics2D;

import net.ciderpunk.tanktris.graphics.*;

public abstract class AnimatedEntity extends Entity {

	AnimationState oAnimState;
	
	public AnimatedEntity(int x, int y){
		super(x,y);
		oAnimState = new AnimationState();
	}
	
	

	@Override
	public void update(long lTime) {
		oAnimState.update(lTime);
		
	}
	@Override
	public void draw(Graphics2D oG) {
		oAnimState.getFrame().draw(oG, iX, iY);
	}

}
