package com.booksaw.testCode;

import java.io.File;
import java.io.IOException;

import org.w3c.dom.NodeList;

import com.booksaw.betterEngine.event.Listener;
import com.booksaw.betterEngine.timing.Updatable;
import com.booksaw.configuration.XmlConfiguration;

public class Main implements Listener, Updatable {

	/*
	 * private static CanvasItem obj; private static Game game; private static
	 * JFrame wrapper;
	 */

	public static void main(String[] args) {
		/*
		 * Main main = new Main();
		 * 
		 * game = new Game(new Dimension(700, 400));
		 * 
		 * // TODO this way of providing the game is not very good, this should be
		 * improved obj = new CanvasItem(game, new Location(5, 15), 5, 10); //
		 * obj.applyVector(Vector.createVectorFromXY(.1, 0)); Sprite obj2 = new
		 * Sprite(game, new Location(15, 25), 10, 30); obj2.addMovement(new
		 * TopDownMovement()); obj2.setMass(1);
		 * 
		 * game.addObject(obj); game.addObject(obj2);
		 * game.getGameClock().addUpdateable(new Main()); game.getCamera().setScale(10,
		 * ScaleType.CORNER);
		 * 
		 * wrapper = FrameWrapper.buildDefaultFrame(game);
		 * wrapper.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 * wrapper.setVisible(true);
		 */

		XmlConfiguration config = new XmlConfiguration();
		try {
			config.load(new File("users.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		NodeList nList = config.getNodeList("user");
		System.out.println(nList.getLength());
	}

	@Override
	public void update() {

//		game.getCamera().setScale(game.getCamera().getScale() + 0.001, ScaleType.CENTRE);
//		obj.setAngle(obj.getAngle() + 0.001);

	}

}
