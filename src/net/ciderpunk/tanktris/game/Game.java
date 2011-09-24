package net.ciderpunk.tanktris.game;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import net.ciderpunk.tanktris.IGameState;
import net.ciderpunk.tanktris.entities.*;
import net.ciderpunk.tanktris.graphics.Frame;

public class Game implements IGameState, MouseMotionListener, MouseListener {
	
	
	//singleton pattern
	private static class GameHolder{
		public static final Game instance = new Game();
	}
	
	//get instance
	public static Game getInstance(){
		return GameHolder.instance;
	}
	
	Gun[] aGuns;
	Grid oGrid;
	Frame oImage;
	
	

	final LinkedEntity oHead;

	private Game(){
		oHead = new LinkedEntity();
	}
	
	
	public void init(){
		
		Frame oImg = new Frame("res/images/sprites.png");
		
		Gun.loadResources(oImg);
		Shot.loadResources(oImg);
		Explosion.loadResources();

		aGuns = new Gun[8];
		aGuns[0] = new Gun(720,50);
		aGuns[1] = new Gun(720,550);

		aGuns[2] = new Gun(620,50);
		aGuns[3] = new Gun(620,550);

		aGuns[4] = new Gun(520,50);
		aGuns[5] = new Gun(520,550);

		aGuns[6] = new Gun(420,50);
		aGuns[7] = new Gun(420,550);

		
		for (int i = 0; i < aGuns.length; i++){
			registerEntity(aGuns[i]);
		}
		registerEntity(new FrameCounter(20,20));
		oGrid = new Grid(20,12, 0, 84); 
		
	}
	
	
	public void registerEntity(Entity oEnt){
		oHead.insert(oEnt);
	}
	
	public void update(){
		Entity oEnt = (Entity) oHead.getNext();
		while (oEnt != null){
			Entity oNextEnt = (Entity) oEnt.getNext();
			oEnt.update();
			oEnt = (Entity)oEnt.getNext();
			oEnt = oNextEnt;
		}

	}
	

	public void draw(Graphics2D oGraphics) {
		// TODO Auto-generated method stub
		oGraphics.setColor(Color.green);
		oGraphics.fillRect(0,0,800,600);
		oGraphics.setColor(Color.WHITE);
		
		oGrid.draw(oGraphics);
		
		Entity oEnt = (Entity) oHead.getNext();
		while (oEnt != null){
			oEnt.draw(oGraphics);
			oEnt = (Entity)oEnt.getNext();
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
	public void mousePressed(MouseEvent e) {
		for(int i = 0; i < aGuns.length; i++){
			aGuns[i].fire(e.getX(), e.getY());
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
