package net.ciderpunk.tanktris.game;

import java.awt.*;
import java.awt.event.*;

import net.ciderpunk.tanktris.IGameState;
import net.ciderpunk.tanktris.entities.Gun;
import net.ciderpunk.tanktris.graphics.Frame;

public class Game implements IGameState, MouseMotionListener, MouseListener {
	
	
	Gun[] aGuns;
	Frame oImage;


	public void init(){
		Gun.loadResources();
		aGuns = new Gun[10];
		aGuns[0] = new Gun(600,100);
		aGuns[1] = new Gun(600,500);
		aGuns[2] = new Gun(400,100);
		aGuns[3] = new Gun(400,500);
		aGuns[4] = new Gun(200,100);
		aGuns[5] = new Gun(200,500);
		aGuns[6] = new Gun(100,100);
		aGuns[7] = new Gun(100,500);

		aGuns[8] = new Gun(300,100);
		aGuns[9] = new Gun(300,500);
	}
	
	public void update(){
		for(int i = 0; i < aGuns.length; i++){
			aGuns[i].update();
		}
	}
	
	protected int x;

	public void draw(Graphics2D oGraphics) {
		// TODO Auto-generated method stub
		oGraphics.setColor(Color.green);
		oGraphics.fillRect(0,0,800,600);
		oGraphics.setColor(Color.WHITE);
		oGraphics.drawString("test",x++, 20);
		
		for(int i = 0; i < aGuns.length; i++){
			aGuns[i].draw(oGraphics);
		}
	}



	@Override
	public void mouseDragged(MouseEvent e) {
		mouseMoved(e);
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		for(int i = 0; i < aGuns.length; i++){
			aGuns[i].trackTo(e.getX(), e.getY());
		}
	}

	@Override
	public void start(Component oComponent) {
		oComponent.addMouseMotionListener(this);
		oComponent.addMouseListener(this);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop(Component oComponent) {
		// TODO Auto-generated method stub
		oComponent.removeMouseMotionListener(this);

		oComponent.removeMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		for(int i = 0; i < aGuns.length; i++){
			aGuns[i].fire();
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
