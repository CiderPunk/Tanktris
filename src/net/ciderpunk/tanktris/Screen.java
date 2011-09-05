package net.ciderpunk.tanktris;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;

import javax.swing.*;

public class Screen extends Canvas  implements Runnable, KeyListener
{
	
	JFrame oFrame;
	protected  GameMode iMode;
	protected BufferStrategy oBuffer;
	
	IGameState oCurrentState;
	protected Game oGame;
	protected Pause oPause;
	
	
  public Screen()
  {
		oFrame = new JFrame("Tanktris");
		JPanel oPanel = (JPanel) oFrame.getContentPane();

		Dimension oSize = new Dimension(800,600);
		oFrame.setSize(oSize);		
		oPanel.setPreferredSize(oSize);

		oPanel.add(this);
		//oFrame.setSize(800, 600);
	
		setBounds(0,0,800,600);
		this.addKeyListener(this);
		oFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		oFrame.setVisible(true);
		oFrame.setIgnoreRepaint(true);
		oFrame.setResizable(false);
	
		oFrame.setLocationRelativeTo(null);
		
		this.createBufferStrategy(2);
		oBuffer = this.getBufferStrategy();
  }
  
  
	//updates display
	public void Update(){
		BufferStrategy oBS = this.getBufferStrategy();
		if (!oBS.contentsLost()){
			oBS.show();
		}
	}
  
	
	public void init(){
		oPause = new Pause();
		oGame = new Game();
		oGame.init();
	}
	
	

	public void run() {
		
		//init everything
		init();
		iMode = GameMode.Playing;
		oCurrentState = oGame;
		
		double fTimePerFrame = 1000.0f / 60.0f;
		long lTicks = 0;
		long lLastTime, lStartTime;
		lLastTime = lStartTime = System.currentTimeMillis();
		System.out.println("started");
		while (oCurrentState != null){
			//get current frame time
			long lCurrentTime = System.currentTimeMillis();
			long lFrameTime = lCurrentTime - lLastTime; 
			lLastTime = lCurrentTime;
			
			oCurrentState.update(lFrameTime);
			//draw stuff
			Graphics2D oG = (Graphics2D) oBuffer.getDrawGraphics();
			oCurrentState.draw(oG);
			oG.dispose();
			
			//flip buffers
			if (!oBuffer.contentsLost()){
				oBuffer.show();
			}

			//get time till next frame.
			lTicks++;
			long lNextFrame = (long) Math.floor(fTimePerFrame * lTicks) + lStartTime;
			long lDiff = lNextFrame - System.currentTimeMillis();
			//check for long delays
			if (lDiff < -10){
				//reset
				lStartTime = System.currentTimeMillis();
				lTicks = 0;
				System.out.println("frame resynch, delay: " + lDiff);
			}
			
			while(lDiff > 1){
				try { Thread.sleep(lDiff / 2); } catch (Exception e) {}
				lDiff = lNextFrame - System.currentTimeMillis();
			}
		}
		oFrame.dispose();
		//close
		
	}


	public void stop(){
		oCurrentState = null;
	}
	
	
	public void pause(){
		oCurrentState = oPause;
	}
	

	public void resume(){
		oCurrentState = oPause;
	}
	

	public void keyPressed(KeyEvent e){
		int iKeyCode = e.getKeyCode();
		if (iKeyCode == KeyEvent.VK_ESCAPE){
			this.stop();
		}
	}


	public void keyReleased(KeyEvent arg0) {
	}



	public void keyTyped(KeyEvent arg0) {
	}
  
  
  

}