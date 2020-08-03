package com.booksaw.testCode;

import javax.swing.JFrame;

import com.booksaw.betterEngine.Game;
import com.booksaw.betterEngine.Logger;
import com.booksaw.betterEngine.event.EventListener;
import com.booksaw.betterEngine.event.EventManager;
import com.booksaw.betterEngine.event.EventPriority;
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

		Logger.error("hi");
		Logger.warning("hit");

		Game game = new Game();
		game.addObject(obj);
		JFrame wrapper = FrameWrapper.buildDefaultFrame(game);
		wrapper.setVisible(true);
	}

	@EventListener
	public void annotatedTestEvent() {

	}

	@EventListener(ignoreCancelled = false)
	public void onEvents(ExampleEvent e) {
		System.out.println("event running NORMAL");
	}

	@EventListener(priority = EventPriority.HIGHEST)
	public void onEvent(ExampleEvent e) {
		e.setCancelled(true);
		System.out.println("event running HIGHEST");
	}

	public void testEvent() {

	}

}
