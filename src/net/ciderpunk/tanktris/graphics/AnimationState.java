package net.ciderpunk.tanktris.graphics;


public class AnimationState{
	protected IFrame oCurrentFrame;
	protected int iFrameIndex;
	protected long lTotalTime;
	protected Animation oCurrentAnim;
	
	public void startAnim(Animation oAnim){
		iFrameIndex = 0;
		lTotalTime = 0;
		oCurrentAnim = oAnim;
		oCurrentFrame = NullFrame.getInstance();
	}
	
	public IFrame getFrame(){
		return oCurrentFrame;
	}
	
	public void update(long lElapsedTime){
		lTotalTime += lElapsedTime;
		oCurrentAnim.update(this);
	}
	
}