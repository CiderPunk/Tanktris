package net.ciderpunk.tanktris.graphics;

import java.util.ArrayList;
import java.util.concurrent.atomic.*;

public class Animation {

	private ArrayList aCells;
	private long lTotalTime;
	
	public Animation(){
		aCells = new ArrayList();
	}
	
	public void addFrame(Frame oFrame, long lDelay){
		lTotalTime += lDelay;
		aCells.add(new Cell(oFrame, lTotalTime));
	}
	
	/*
	public Frame getFrame(long lTime){
		AtomicInteger iCurrentFrame = new AtomicInteger(0);
		
		
	}
	*/
	
	protected class Cell{
		Frame oFrame;
		long lDelay;
		public Cell(Frame frame, long delay){
			oFrame = frame;
			lDelay = delay;
		}
	}
	
	
	
	
}
