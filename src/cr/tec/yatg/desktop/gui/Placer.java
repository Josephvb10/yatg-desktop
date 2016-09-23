package cr.tec.yatg.desktop.gui;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by joseph on 22/09/16.
 */
public class Placer {
	private static int size = 20;
	private static int winSize = 680;

	@FXML
	private Pane matrix;

	public void setMoto(int player, int i, int j) {
		Color color;
		switch (player) {
			case 1:
				color = Color.RED;
				break;
			case 2:
				color = Color.GREEN;
				break;
			default:
				color = Color.WHITE;
				break;
		}

		Rectangle moto = new Rectangle();
		moto.setFill(color);

		moto.setHeight(size);
		moto.setWidth(size);

		moto.setX((i - 1) * size);
		moto.setY((j - 1) * size);

		matrix.getChildren().add(moto);


	}

	public void setBomba(int type) {
		System.out.println(" BOMBA ");
	}


}
