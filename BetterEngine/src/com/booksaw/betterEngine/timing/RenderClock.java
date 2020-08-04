package com.booksaw.betterEngine.timing;

import java.awt.event.ActionEvent;

import com.booksaw.betterEngine.Game;

/**
 * A class used to repaint the screen async as regually as possible
 * 
 * @author booksaw
 *
 */
public class RenderClock extends Clock {

	private final Game game;

	public RenderClock(Game game) {
		super(1);
		this.game = game;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		game.getRenderManager().repaint();
	}

}
