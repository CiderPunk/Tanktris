package net.ciderpunk.tanktris;

import java.awt.Graphics2D;

public interface IGameState {
	public void init();
	public void update(long lTime);
	public void draw(Graphics2D oGraphics);
}
