package net.ciderpunk.tanktris.entities;

import net.ciderpunk.tanktris.graphics.Animation;

public abstract class Entity {

	protected AnimationState oAState;
	
	
	public Entity(){
		oAState = new AnimationState();
		
		
	}
	
	
	public void update(long lTime){
		
		
	}

	
	public class AnimationState{
		protected int iFrameIndex;
		protected long lTotalTime;
		
		public void reset(){
			iFrameIndex = 0;
			lTotalTime = 0;
		}
		
	}
	
}
