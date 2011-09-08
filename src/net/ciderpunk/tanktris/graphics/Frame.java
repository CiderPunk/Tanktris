package net.ciderpunk.tanktris.graphics;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import net.ciderpunk.tanktris.Screen;

public class Frame implements IFrame {

	
	protected BufferedImage oImage; 
	protected int iXOffs; 
	protected int iYOffs;
	
	
	//constructors
	//instantiate frame from image path
	public Frame(String sPath){
		this(sPath,0,0);
	}
	
	//instantiate frame from image with offset coordinates 
	public Frame(String sPath, int iXOffset, int iYOffset){
		try{
		oImage = ImageIO.read(new File(sPath));
		}
		catch(Exception ex){}
		//oImage = new ImageIcon(sPath).getImage();
		iXOffs = iXOffset;
		iYOffs = iYOffset;
	}
	

	public Frame(Frame oBaseFrame, int iX, int iY, int iW, int iH){
		this(oBaseFrame, iX, iY, iW, iH, 0, 0);
	}
	
	
	public Frame(Frame oBaseFrame, int iX, int iY, int iW, int iH, int iXOffset, int iYOffset){
	//	oImage = Screen.getInstance().createImage(iW,  iH);
		oImage = new BufferedImage(iW,iH,BufferedImage.TYPE_INT_ARGB);
		Graphics oG = oImage.getGraphics();
		oG.drawImage(oBaseFrame.getImage(),0,0,iW,iH,iX,iY,iX+iW,iY+iH, null);
		iXOffs = iXOffset;
		iYOffs = iYOffset;
	}
	
	//get underlying image
	public Image getImage(){
		return oImage;
	}
	
	//draw image
	public void draw(Graphics oG, int x, int y){
		oG.drawImage(oImage, x - iXOffs, y - iYOffs, null);
	}
	//draw image with some rotation
	public void drawRotate(Graphics2D oG, int x, int y, double iRads){
		AffineTransform oTransform = new AffineTransform();
		oTransform.setToTranslation(x, y);
		oTransform.rotate(iRads,iXOffs, iYOffs);
		oG.drawImage(oImage, oTransform, null);
	}

	public int getXOffset(){
		return iXOffs;
	}
	
	public int getYOffset(){
		return iYOffs;
	}
	
	public int getWidth(){
		return oImage.getWidth(null);
	}

	public int getHeight(){
		return oImage.getHeight(null);
	}
	
}
