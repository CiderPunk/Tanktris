package net.ciderpunk.tanktris.graphics;

import java.util.ArrayList;
import java.util.concurrent.atomic.*;

public class Animation {

	private ArrayList aCells;
	private long lTotalTime;
	private boolean bLoop;
	
	//constructors
	public Animation(){
		this(true);
	}
	
	public Animation(boolean loop){
		aCells = new ArrayList();
		bLoop = loop;
	}
	
	/*
	//add a new cell to an animation sequence
	public void addFrame(Frame oFrame, long lDelay){
		addFrame((IFrame) oFrame, lDelay);
	}
	*/
	//add a new cell to an animation sequence
	public void addFrame(IFrame oFrame, long lDelay){
		lTotalTime += lDelay;
		aCells.add(new Cell(oFrame, lTotalTime));
	}
	
	//update an instance of the animation
	public void update(AnimationState oState){
		if (oState.lTotalTime > lTotalTime){

			if (bLoop){
				oState.iFrameIndex = 0;
				oState.lTotalTime = 0;
			}
			else{
				return;
			}
		}
		while( ((Cell) aCells.get(oState.iFrameIndex)).lTime < oState.lTotalTime){
			oState.iFrameIndex++;
		}
		oState.oCurrentFrame =  (IFrame) ((Cell) aCells.get(oState.iFrameIndex)).oFrame;
	}

	
	protected class Cell{
		IFrame oFrame;
		long lTime;
		public Cell(IFrame frame, long time){
			oFrame = frame;
			lTime = time;
		}
	}
	

	
	
}
