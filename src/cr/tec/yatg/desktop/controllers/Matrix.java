package cr.tec.yatg.desktop.controllers;

import cr.tec.yatg.desktop.services.ControllerFacade;
import cr.tec.yatg.desktop.services.MusicPlayer;
import cr.tec.yatg.desktop.services.comms.JsonParser;
import cr.tec.yatg.desktop.services.comms.TronClient;
import cr.tec.yatg.desktop.structures.Item;
import cr.tec.yatg.desktop.structures.ItemType;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
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

	private ArrayList<Item> currentMatrixData;

	private boolean star = false;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		gc = gameCanvas.getGraphicsContext2D();
		MusicPlayer.play("src/cr/tec/yatg/desktop/resources/music/title.mp3");

		new AnimationTimer() {
			public void handle(long currentNanoTime) {
				ArrayList<Item> newData = JsonParser.getInstance().getPlayerItems();
				if (currentMatrixData == newData) {
					return;
				}
				clean();
				refreshJson(newData);
			}
		}.start();

	}

	public void keyListener(KeyEvent event) {
		if (event.getCode() == KeyCode.UP) {
			TronClient.getInstance().send("%DL");
		} else if (event.getCode() == KeyCode.DOWN) {
			TronClient.getInstance().send("%DR");
		} else if (event.getCode() == KeyCode.LEFT) {
			TronClient.getInstance().send("%DU");
		} else if (event.getCode() == KeyCode.RIGHT) {
			TronClient.getInstance().send("%DD");
		} else if (event.getCode() == KeyCode.Z) {
			TronClient.getInstance().send("%IT");
		} else if (event.getCode() == KeyCode.X) {
			TronClient.getInstance().send("%IN");
		}
	}

	private void refreshJson(ArrayList<Item> matrixData) {
		if (matrixData != null) {
			Color g = Color.BLACK;
			for (Item data : matrixData) {
				Boolean drawStar = false;
				if (data == null) {
					g = Color.BLACK;
				} else {
					if (data.getType() == ItemType.tronTrail) {
						if (data.getOwner() == JsonParser.getInstance().getPlayerData().getOwner()) {
							drawStar = true;
							if (JsonParser.getInstance().getPlayerData().isShieldActivated()) {
								if (!star) {
									MusicPlayer.play("src/cr/tec/yatg/desktop/resources/music/starman.mp3");
									star = true;
								}

							} else {
								if (star) {
									MusicPlayer.play("src/cr/tec/yatg/desktop/resources/music/title.mp3");
									star = false;
								}
							}

							g = Color.CYAN;
						} else {
							g = Color.WHITE;
						}
					} else if (data.getType() == ItemType.bomb) {
						drawImage(new Image("/cr/tec/yatg/desktop/resources/images/bomb.png"), data.getIndexI(), data.getIndexJ());
						continue;
					} else if (data.getType() == ItemType.shield) {
						drawImage(new Image("/cr/tec/yatg/desktop/resources/images/shield.png"), data.getIndexI(), data.getIndexJ());
						continue;
					} else if (data.getType() == ItemType.turbo) {
						drawImage(new Image("/cr/tec/yatg/desktop/resources/images/turbo.png"), data.getIndexI(), data.getIndexJ());
						continue;
					} else if (data.getType() == ItemType.increaseTail) {
						drawImage(new Image("/cr/tec/yatg/desktop/resources/images/plus.png"), data.getIndexI(), data.getIndexJ());
						continue;
					} else if (data.getType() == ItemType.fuel) {
						drawImage(new Image("/cr/tec/yatg/desktop/resources/images/fuel.png"), data.getIndexI(), data.getIndexJ());
						continue;
					}

				}

				drawSquare(g, data.getIndexI(), data.getIndexJ());
				if (star && drawStar) {
					drawHalfSquare(Color.BLUE, data.getIndexI(), data.getIndexJ());
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
		gc.setStroke(Color.BLACK);
		gc.strokeRect(i * size, j * size, size, size);
	}

	private void drawHalfSquare(Color color, double i, double j) {

		gc.setFill(color);
		gc.fillRect(i * size, j * size, size / 2, size / 2);
		gc.setStroke(Color.BLACK);
		gc.strokeRect(i * size, j * size, size / 2, size / 2);
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


	public void died() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("You died");
		alert.setContentText("You are dead. Better luck next time  ¯\\_(ツ)_/¯");
		alert.showAndWait();
		TronClient.getInstance().disconnect();

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../resources/views/login.fxml"));
		Parent mainScreen = null;
		try {
			mainScreen = fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Yet Another Tron Game");
		stage.setResizable(false);
		Scene scene = new Scene(mainScreen);
		scene.setOnKeyPressed(t -> ControllerFacade.getInstance().getMatrix().keyListener(t));
		stage.setScene(scene);
		Stage mainStage = (Stage) gameCanvas.getScene().getWindow();
		mainStage.close();

		mainStage.setOnCloseRequest(e -> {
		});

		stage.setOnCloseRequest(e -> {
			Platform.exit();
			System.exit(0);
		});

		stage.show();

		MusicPlayer.play("src/cr/tec/yatg/desktop/resources/music/title.mp3");
	}
}
