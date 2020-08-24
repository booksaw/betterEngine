package com.booksaw.betterEditor.panels;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.booksaw.betterEditor.Constants;

/**
 * Used to control all panels and sub panels within the editor
 * 
 * @author booksaw
 *
 */
public abstract class Panel {

	JPanel panel;
	boolean border = true;
	protected Panel parent;

	public Panel(Panel parent) {
		this.parent = parent;
	}

	public JPanel getPanel() {
		if (panel != null) {
			return panel;
		}
		panel = new JPanel();
		createPanel(panel);
		if (border)
			panel.setBorder(new LineBorder(Constants.border, 2));
		return panel;

	}

	protected abstract void createPanel(JPanel panel);

	public Panel getParent() {
		return parent;
	}

	public void setParent(Panel parent) {
		this.parent = parent;
	}

}
