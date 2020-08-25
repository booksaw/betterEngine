package com.booksaw.betterEditor.window;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public interface Window {

	public JPanel getPanel(JFrame frame);

	/**
	 * @return the starting size of the JFrame
	 */
	public Dimension getStartingSize();

	/**
	 * @return if the window should be able to be resized
	 */
	public boolean canResize();
}