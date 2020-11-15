package com.booksaw.betterEditor.window;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.booksaw.betterEditor.panels.ConsolePanel;
import com.booksaw.betterEditor.panels.GamePanel;
import com.booksaw.betterEditor.panels.MenuBar;
import com.booksaw.betterEditor.panels.PropertiesPanel;
import com.booksaw.betterEditor.panels.SelectionPanel;
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
	private final Game game;

	public MainWindow(Game game) {
		this.game = game;
	}

	@Override
	public JPanel getPanel(JFrame frame) {
		this.frame = frame;

		JPanel panel = new JPanel(new GridLayout());

		Subdivision gameSub = new Subdivision(
				new Subdivision(new GamePanel(null), new ConsolePanel(null), false, true, null),
				new PropertiesPanel(null), true, true, null);

		Subdivision sub = new Subdivision(new SelectionPanel(null), gameSub, true, true, null);

		panel.add(new Subdivision(new MenuBar(null), sub, false, true, null).getPanel());
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

	public JFrame getFrame() {
		return frame;
	}

	public Game getGame() {
		return game;
	}

}