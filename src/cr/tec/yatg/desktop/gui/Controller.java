package cr.tec.yatg.desktop.gui;

import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

/**
 * Main GUI controller
 * Created by joseph on 22/09/16.
 */
public class Controller {

	@FXML
	private Rectangle a1;


	@FXML
	protected void doSomething() {
		Random rand = new Random(System.currentTimeMillis());
		int r = rand.nextInt(255);
		int g = rand.nextInt(255);
		int b = rand.nextInt(255);
		System.out.println("The button was clicked!");
		a1.setFill(Color.rgb(r, g, b));
	}


}
