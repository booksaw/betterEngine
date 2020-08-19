package com.booksaw.testCode;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.booksaw.betterEngine.Game;
import com.booksaw.betterEngine.camera.ScaleType;
import com.booksaw.betterEngine.event.EventManager;
import com.booksaw.betterEngine.event.Listener;
import com.booksaw.betterEngine.event.events.ExampleEvent;
import com.booksaw.betterEngine.movement.Location;
import com.booksaw.betterEngine.movement.TopDownMovement;
import com.booksaw.betterEngine.object.CanvasItem;
import com.booksaw.betterEngine.object.Sprite;
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

		game = new Game(new Dimension(700, 400));

		// TODO this way of providing the game is not very good, this should be improved
		obj = new CanvasItem(game, new Location(50, 15), 10, 10);
		Sprite obj2 = new Sprite(game, new Location(15, 25.1), 10, 30);
		obj2.addMovement(new TopDownMovement());

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

//		game.getCamera().setScale(game.getCamera().getScale() + 0.001, ScaleType.CENTRE);
//		obj.setAngle(obj.getAngle() + 0.001);

	}

}
