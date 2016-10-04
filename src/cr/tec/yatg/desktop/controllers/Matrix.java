package cr.tec.yatg.desktop.controllers;

import cr.tec.yatg.desktop.services.comms.JsonConverter;
import cr.tec.yatg.desktop.structures.Item;
import cr.tec.yatg.desktop.structures.ItemType;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Controller de la Matrix
 * Created by joseph on 22/09/16.
 */
public class Matrix implements Initializable {
	private double size = 20;
	@FXML
	private Pane matrix;
	private int winSize = 680;

	@FXML
	private Canvas gameCanvas;

	private GraphicsContext gc;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		gc = gameCanvas.getGraphicsContext2D();

		new AnimationTimer() {
			public void handle(long currentNanoTime) {
				clean();
				refreshJson();
			}
		}.start();

	}

	private void refreshJson() {
		ArrayList<Item> items = JsonConverter.getInstance().items;
		if (items != null) {
			System.out.println("no es null");
			for (Item data : items) {
				System.out.println("Hay item");
				System.out.println("(" + data.getType() + ")");
				if (data.getType() == ItemType.tronTrail) {
					System.out.println("(Tron trail recibida)");
					if (data.getFirst()) {
						setMoto(data.getOwner().value, data.getIndexI(), data.getIndexJ());
					} else {
						System.out.println("No es first");
						setEstela(data.getOwner().value, data.getIndexI(), data.getIndexJ());

					}
				}
			}
		}
	}


	private void drawImage(Image img, int i, int j) {
		final double HEIGHT = img.getHeight();
		final double WIDTH = img.getWidth();

		gc.drawImage(img, size * i, size * j);

	}

	public void setMoto(int player, double i, double j) {
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
		//drawImage(new Image("/cr/tec/yatg/desktop/resources/images/moto.png"), i, j);
		drawSquare(color, i, j);
	}


	private void drawSquare(Color color, double i, double j) {

		gc.setFill(color);
		gc.fillRect(i * size, j * size, size, size);

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

		drawSquare(color, i, j);
	}

	public void clean() {
		gc.clearRect(0, 0, winSize, winSize);
	}

	public void setBomba(int type) {
		System.out.println(" BOMBA ");
	}


}
