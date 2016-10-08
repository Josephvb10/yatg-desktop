package cr.tec.yatg.desktop.controllers;

import cr.tec.yatg.desktop.services.ControllerFacade;
import cr.tec.yatg.desktop.services.comms.JsonParser;
import cr.tec.yatg.desktop.services.comms.TronClient;
import cr.tec.yatg.desktop.structures.Item;
import cr.tec.yatg.desktop.structures.ItemType;
import cr.tec.yatg.desktop.structures.SimplePlayer;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Main GUI controller
 * Created by joseph on 22/09/16.
 */
public class Dashboard implements Initializable {

	@FXML
	private Pane dashboard;
	@FXML
	private Matrix matrixController;
	@FXML
	private Dashboard dashboardController;
	@FXML
	private Label serverIp;
	@FXML
	private Label playerNum;
	@FXML
	private ProgressBar fuelBar;
	@FXML
	private ImageView powerImage;

	private SimplePlayer playerData;

	private ItemType currentPower = null;


	@Override
	public void initialize(URL location, ResourceBundle resource) {
		ControllerFacade.getInstance().setMatrix(matrixController);
		ControllerFacade.getInstance().setDashboard(dashboardController);

		serverIp.setText(TronClient.getInstance().getServerIp() + ":" + TronClient.getInstance().getServerPort());



		new AnimationTimer() {
			public void handle(long currentNanoTime) {
				refreshPlayerNumber();
				playerData = JsonParser.getInstance().getPlayerData();
				if (playerData != null) {
					refreshFuel();
					refreshPowers();
				}
			}
		}.start();
	}

	private void refreshPlayerNumber() {
		playerNum.setText(Integer.toString(TronClient.getInstance().getCurrentPlayers()));
	}

	public void refreshPowers() {
		System.out.println(JsonParser.getInstance().getPowerUps().size());
		if (JsonParser.getInstance().getPowerUps().size() == 0) {
			if (currentPower == null) {
				return;
			}
			powerImage.setImage(new Image("/cr/tec/yatg/desktop/resources/images/mystery.png"));
			return;
		}
		Item item = JsonParser.getInstance().getPowerUps().get(0);
		if (item.getType() == ItemType.shield) {
			if (currentPower == ItemType.shield) {
				return;
			}
			powerImage.setImage(new Image("/cr/tec/yatg/desktop/resources/images/iShield.png"));
		} else if (item.getType() == ItemType.turbo) {
			if (currentPower == ItemType.turbo) {
				return;
			}
			powerImage.setImage(new Image("/cr/tec/yatg/desktop/resources/images/iSpeed.png"));
		}


	}


	public void exitGame() {
		System.out.println("Saliendo");
		Platform.exit();
		System.exit(0);
	}

	public void refreshFuel() {
		fuelBar.setProgress(playerData.getFuel() / 100);

	}

	public void kicked() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("You have been kicked!");
		alert.setHeaderText("The server has kicked you from the game.");
		alert.showAndWait();
	}

	public void serverDead() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("The server is gone");
		alert.setContentText("The server has disconnected.");
		alert.showAndWait();
	}


}
