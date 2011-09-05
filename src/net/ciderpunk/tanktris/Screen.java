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
		oPanel.setPreferredSize(new Dimension(800,600));
		oPanel.add(this);
		oFrame.setSize(800, 600);
		setBounds(0,0,800,600);
		
		oFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		oFrame.setVisible(true);
		oFrame.setIgnoreRepaint(true);
		oFrame.setResizable(false);
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
		
		while (oCurrentState != null){
			oCurrentState.update();
			Graphics2D oG = (Graphics2D) oBuffer.getDrawGraphics();
			oCurrentState.draw(oG);
			//flip buffers
			
			oG.dispose();
			if (!oBuffer.contentsLost()){
				oBuffer.show();
			}

		}
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