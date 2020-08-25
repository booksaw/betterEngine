package com.booksaw.betterEditor.window;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.booksaw.betterEditor.panels.BlankPanel;
import com.booksaw.betterEditor.panels.Subdivision;
import com.booksaw.betterEngine.Game;

/**
 * This is the main display frame, this is used to manage most the rendering for
 * the system
 * 
 * @author booksaw
 *
 */
public class MainWindow implements Window {

	private JFrame frame;
	private Game game;

	public MainWindow(Game game) {
		this.game = game;
	}

	@Override
	public JPanel getPanel(JFrame frame) {
		JPanel panel = new JPanel(new GridLayout());
		panel.add(new Subdivision(new BlankPanel(null), new BlankPanel(null), true, true, null).getPanel());
		return panel;
	}

	@Override
	public Dimension getStartingSize() {
		return new Dimension(1280, 720);
	}

	@Override
	public boolean canResize() {
		return true;
	}

}