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

		// creating the editor frame with default settings
		editorFrame = new JFrame(NAME);
		editorFrame.setSize(900, 600);
		editorFrame.setLocationRelativeTo(null);
		editorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// showing the editor frame
		editorFrame.setVisible(true);
	}

}
