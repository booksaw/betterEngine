package com.booksaw.betterEditor.panels;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuBar extends Panel {

	public MenuBar(Panel parent) {
		super(parent);
	}

	@Override
	protected void createPanel(JPanel panel) {
		panel.add(new JLabel("TODO: MenuBar"));
	}

}
