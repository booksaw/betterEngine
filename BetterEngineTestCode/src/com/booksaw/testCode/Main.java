package com.booksaw.testCode;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.booksaw.betterEngine.Game;
import com.booksaw.betterEngine.camera.ScaleType;
import com.booksaw.betterEngine.event.EventManager;
import com.booksaw.betterEngine.event.Listener;
import com.booksaw.betterEngine.event.events.ExampleEvent;
import com.booksaw.betterEngine.object.CanvasItem;
import com.booksaw.betterEngine.swing.FrameWrapper;
import com.booksaw.betterEngine.timing.Updatable;

public class Main implements Listener, Updatable {

	private static CanvasItem obj;
	private static Game game;
	private static JFrame wrapper;

	public static void main(String[] args) {
		Main main = new Main();
		EventManager.registerEvents(main);

		EventManager.callEvent(new ExampleEvent());
		EventManager.cancelEvents(main);
		EventManager.callEvent(new ExampleEvent());

		obj = new CanvasItem(60, 25, 10, 30);
		CanvasItem obj2 = new CanvasItem(15, 25, 10, 30);

		game = new Game(new Dimension(700, 400));
		game.addObject(obj);
		game.addObject(obj2);
		game.getGameClock().addUpdateable(new Main());
		game.getCamera().setScale(10, ScaleType.CORNER);

		wrapper = FrameWrapper.buildDefaultFrame(game);
		wrapper.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wrapper.setVisible(true);
	}

	@Override
	public void update() {

		game.getCamera().setScale(game.getCamera().getScale() + 0.001, ScaleType.CENTRE);
		obj.setAngle(obj.getAngle() + 0.001);

		if (wrapper != null) {
			wrapper.repaint();
		}
	}

}
