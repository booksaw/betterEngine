package com.booksaw.betterEngine.swing;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.booksaw.betterEngine.Game;
import com.booksaw.betterEngine.Logger;
import com.booksaw.betterEngine.input.KeyboardManager;

/**
 * This class is used to wrap the game within a JFrame (panel wrapper is still
 * used for processing)
 * <p>
 * If you change the content pane of this JFrame, the game will no longer be
 * visible
 * </p>
 * 
 * @author booksaw
 *
 */
public class FrameWrapper extends JFrame {

	/**
	 * This method is used to build a frame correctly
	 * 
	 * @return the instance of a frame wrapper which has been built correctly
	 */
	public static FrameWrapper buildDefaultFrame(Game game) {
		Logger.info("Creating instance of FrameWrapper");
		FrameWrapper frame = new FrameWrapper(game);
		// TODO GAME NAME
		frame.setName("GAME");

		// TODO improved dimensions
		frame.getContentPane().setPreferredSize(new Dimension(700, 400));

		frame.pack();
		frame.setLocationRelativeTo(null);
		return frame;
	}

	private static final long serialVersionUID = 1456466L;
	private final Game game;
	private final PanelWrapper panelWrapper;

	public FrameWrapper(Game game) {
		this.game = game;

		panelWrapper = new PanelWrapper(game);
		setContentPane(panelWrapper);
		addKeyListener(KeyboardManager.keyboardManager);
	}

	public Game getGame() {
		return game;
	}

	public PanelWrapper getPanelWrapper() {
		return panelWrapper;
	}

}
