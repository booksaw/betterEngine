package com.booksaw.testCode;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.booksaw.betterEngine.Game;
import com.booksaw.betterEngine.event.EventManager;
import com.booksaw.betterEngine.event.Listener;
import com.booksaw.betterEngine.event.events.ExampleEvent;
import com.booksaw.betterEngine.object.CanvasItem;
import com.booksaw.betterEngine.swing.FrameWrapper;
import com.booksaw.betterEngine.timing.Updatable;

public class Main implements Listener, Updatable {

	private static CanvasItem obj;
	private static JFrame wrapper;

	public static void main(String[] args) {
		Main main = new Main();
		EventManager.registerEvents(main);

		EventManager.callEvent(new ExampleEvent());
		EventManager.cancelEvents(main);
		EventManager.callEvent(new ExampleEvent());

		obj = new CanvasItem(30, 25, 10, 30);
		obj.setAngle(Math.toRadians(45));

		Game game = new Game(new Dimension(700, 400));
		game.addObject(obj);
		game.getGameClock().addUpdateable(new Main());
		game.getCamera().setScale(10);

		wrapper = FrameWrapper.buildDefaultFrame(game);
		wrapper.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wrapper.setVisible(true);
	}

	@Override
	public void update() {
		obj.setAngle(obj.getAngle() + 0.0005);
		if (wrapper != null) {
			wrapper.repaint();
		}
	}

}
