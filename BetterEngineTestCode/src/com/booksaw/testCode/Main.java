package com.booksaw.testCode;

import com.booksaw.betterEngine.Logger;
import com.booksaw.betterEngine.event.EventListener;
import com.booksaw.betterEngine.event.EventManager;
import com.booksaw.betterEngine.event.EventPriority;
import com.booksaw.betterEngine.event.Listener;
import com.booksaw.betterEngine.event.events.ExampleEvent;
import com.booksaw.betterEngine.object.CanvasItem;

public class Main implements Listener {

	public static void main(String[] args) {
		Main main = new Main();
		EventManager.registerEvents(main);

		EventManager.callEvent(new ExampleEvent());
		EventManager.cancelEvents(main);
		EventManager.callEvent(new ExampleEvent());

		CanvasItem obj = new CanvasItem(0, 0, 10, 10);
		obj.getRenderer().getImage();
		
		Logger.error("hi");
		Logger.warning("hit");
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
