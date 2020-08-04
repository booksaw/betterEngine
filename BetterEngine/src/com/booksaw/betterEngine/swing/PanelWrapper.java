package com.booksaw.betterEngine.swing;

import java.awt.Graphics;

import javax.swing.JPanel;

import com.booksaw.betterEngine.Game;
import com.booksaw.betterEngine.Logger;
import com.booksaw.betterEngine.gameRendering.GameRenderer;

/**
 * This class is used to wrap a game instance into a JPanel
 * 
 * @author booksaw
 *
 */
public class PanelWrapper extends JPanel implements GameRenderer {

	private static final long serialVersionUID = 296756653172992163L;

	private final Game game;

	public PanelWrapper(Game game) {
		Logger.info("Creating PanelWrapper instance");
		this.game = game;
		game.getRenderManager().addInstance(this);
	}

	public Game getGame() {
		return game;
	}

	@Override
	public void paint(Graphics g) {
		game.paint(g);
	}
}
