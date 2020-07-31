package com.booksaw.testCode;

import com.booksaw.betterEngine.event.EventListener;
import com.booksaw.betterEngine.event.EventManager;
import com.booksaw.betterEngine.event.EventPriority;
import com.booksaw.betterEngine.event.Listener;
import com.booksaw.betterEngine.event.events.ExampleEvent;

public class Main implements Listener {

	public static void main(String[] args) {

		Main main = new Main();
		EventManager.registerEvents(main);

		EventManager.callEvent(new ExampleEvent());
		EventManager.cancelEvents(main);
		EventManager.callEvent(new ExampleEvent());
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
