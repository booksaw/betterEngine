package com.booksaw.testCode;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.booksaw.betterEngine.Game;
import com.booksaw.betterEngine.event.EventManager;
import com.booksaw.betterEngine.event.Listener;
import com.booksaw.betterEngine.event.events.ExampleEvent;
import com.booksaw.betterEngine.object.CanvasItem;
import com.booksaw.betterEngine.swing.FrameWrapper;

public class Main implements Listener {

	public static void main(String[] args) {
		Main main = new Main();
		EventManager.registerEvents(main);

		EventManager.callEvent(new ExampleEvent());
		EventManager.cancelEvents(main);
		EventManager.callEvent(new ExampleEvent());

		CanvasItem obj = new CanvasItem(50, 50, 10, 10);

		Game game = new Game(new Dimension(700, 400));
		game.addObject(obj);
		JFrame wrapper = FrameWrapper.buildDefaultFrame(game);
		wrapper.setVisible(true);
	}

}
