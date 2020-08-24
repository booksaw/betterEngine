package com.booksaw.betterEditor;

import javax.swing.JFrame;

/**
 * The main class of the editor
 * 
 * @author booksaw
 *
 */
public class Main {

	private static final String NAME = "BetterEngine";

	private JFrame editorFrame;

	public static Main instance;

	public static void main(String[] args) {
		new Main();
	}

	private Main() {
		// only a single instance can exist at run time
		if (instance != null) {
			return;
		}

		instance = this;
		editorFrame = new JFrame(NAME);
		editorFrame.setSize(900, 600);
		editorFrame.setLocationRelativeTo(null);
		editorFrame.setVisible(true);
	}

}
