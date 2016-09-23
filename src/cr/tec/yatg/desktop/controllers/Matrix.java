package cr.tec.yatg.desktop.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by joseph on 22/09/16.
 */
public class Matrix {
	private static int size = 20;
	private static int winSize = 680;


	@FXML
	private Pane matrix;

	private Rectangle Square(Color color, int i, int j) {
		Rectangle square = new Rectangle();
		square.setFill(color);

		square.setHeight(size);
		square.setWidth(size);

		square.setX((i - 1) * size);
		square.setY((j - 1) * size);

		return square;
	}

	public void setMoto(int player, int i, int j) {
		Color color;
		switch (player) {
			case 1:
				color = Color.RED;
				break;
			case 2:
				color = Color.GREEN;
				break;
			case 3:
				color = Color.DARKORANGE;
				break;
			case 4:
				color = Color.YELLOW;
				break;
			case 5:
				color = Color.BROWN;
				break;
			case 6:
				color = Color.VIOLET;
				break;
			default:
				color = Color.WHITE;
				break;
		}

		matrix.getChildren().add(Square(color, i, j));

	}

	public void setEstela(int player, int i, int j) {
		Color color;
		switch (player) {
			case 1:
				color = Color.PALEVIOLETRED;
				break;
			case 2:
				color = Color.LIGHTGREEN;
				break;
			case 3:
				color = Color.ORANGE;
				break;
			case 4:
				color = Color.LIGHTYELLOW;
				break;
			case 5:
				color = Color.SANDYBROWN;
				break;
			case 6:
				color = Color.PALEVIOLETRED;
				break;
			default:
				color = Color.WHITE;
				break;
		}

		matrix.getChildren().add(Square(color, i, j));
	}

	public void clean() {
		matrix.getChildren().clear();
	}

	public void setBomba(int type) {
		System.out.println(" BOMBA ");
	}


}
