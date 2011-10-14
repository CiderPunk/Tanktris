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
	final LinkedEntity oShots;
	final LinkedEntity oGuns;
	
	private Game(){
		oHead = new LinkedEntity();
		oShots = new LinkedEntity();
		oGuns = new LinkedEntity();
	}
	
	
	public void init(){
		
		Frame oImg = new Frame("res/images/sprites.png");
		
		Gun.loadResources(oImg);
		Shot.loadResources(oImg);
		Block.loadResources(oImg);
		Explosion.loadResources();
		
		this.registerGun(new Gun(620,50));
		this.registerGun(new Gun(620,550));
		registerEntity(new FrameCounter(20,20));
		oGrid = new Grid(20,12, 0, 84); 
		//oGrid.createBlock();	
	}
	
	
	public void registerEntity(Entity oEnt){
		oHead.insert(oEnt);
	}
	
	public void registerShot(Shot oEnt){
		this.oShots.insert(oEnt);
	}
	
	public void registerGun(Gun oEnt){
		this.oGuns.insert(oEnt);
	}
	
	//draws a linked list of entities
	protected void drawList(LinkedEntity oHeadEnt, Graphics2D oGraphics){
		Entity oEnt = (Entity) oHeadEnt.getNext();
		while (oEnt != null){
			oEnt.draw(oGraphics);
			oEnt = (Entity)oEnt.getNext();
		}
	}
	
	//updates a linked list of entities
	protected void updateList(LinkedEntity oHeadEnt){
		Entity oEnt = (Entity) oHeadEnt.getNext();

		while (oEnt != null){
			Entity oNextEnt = (Entity) oEnt.getNext();
			oEnt.update();
			oEnt = (Entity)oEnt.getNext();
			oEnt = oNextEnt;
		}
	}
	
	public void update(){
		updateList(oHead);
		updateList(oGuns);
		updateList(oShots);
	}

	public void draw(Graphics2D oGraphics) {
		// TODO Auto-generated method stub
		oGraphics.setColor(Color.green);
		oGraphics.fillRect(0,0,800,600);
		oGraphics.setColor(Color.WHITE);
		oGrid.draw(oGraphics);
		drawList(oHead, oGraphics);
		drawList(oShots, oGraphics);
		drawList(oGuns, oGraphics);
	}



	@Override
	public void mouseDragged(MouseEvent e) {
		mouseMoved(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Gun oGun =(Gun) oGuns.getNext();
		while(oGun != null){
			oGun.trackTo(e.getX(), e.getY());
			oGun =(Gun) oGun.getNext();
		}
	}

	@Override
	public void start(Component oComponent) {
		oComponent.addMouseMotionListener(this);
		oComponent.addMouseListener(this);	
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
		Gun oGun =(Gun) oGuns.getNext();
		while(oGun != null){
			oGun.fire(e.getX(), e.getY());
			oGun =(Gun) oGun.getNext();
		}	
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	
	
}
