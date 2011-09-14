package net.ciderpunk.tanktris.ui;


import java.awt.event.*;

public class MouseHandler implements MouseListener, MouseMotionListener {

	
	int iMouseX;
	int iMouseY;
	boolean bClicked;
	boolean bLeftButton;
	boolean bMidButton;
	boolean bRightButton;
	
	
	public int getMouseX(){
		return iMouseX;
	}
	
	public int getMouseY(){
		return iMouseY;
	}
	
	public boolean getClicked(){
		return bClicked;
	}
	
	public boolean getLeft(){
		return bLeftButton;
	}
	public boolean getRight(){
		return bRightButton;
	}
	public boolean getMid(){
		return bMidButton;
	}

	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		bClicked = true;
		switch(e.getButton()){
		case MouseEvent.BUTTON1:
			bLeftButton = true;
			break;
		case MouseEvent.BUTTON2:
			bRightButton = true;
			break;
		case MouseEvent.BUTTON3:
			bMidButton = true;
			break;
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseMoved(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		iMouseX = e.getX();
		iMouseY = e.getY();
	
	}

}
