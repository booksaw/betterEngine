package com.booksaw.betterEngine.swing;

import java.awt.Graphics;

import javax.swing.JPanel;

import com.booksaw.betterEngine.Game;
import com.booksaw.betterEngine.Logger;

/**
 * This class is used to wrap a game instance into a JPanel
 * 
 * @author booksaw
 *
 */
public class PanelWrapper extends JPanel {

	private static final long serialVersionUID = 296756653172992163L;

	private final Game game;

	public PanelWrapper(Game game) {
		Logger.info("Creating PanelWrapper instance");
		this.game = game;
	}

	public Game getGame() {
		return game;
	}


	@Override
	public void paint(Graphics g) {
		game.paint(g);
	}
}
