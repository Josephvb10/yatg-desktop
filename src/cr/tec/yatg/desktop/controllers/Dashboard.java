package cr.tec.yatg.desktop.controllers;

import cr.tec.yatg.desktop.services.ControllerFacade;
import cr.tec.yatg.desktop.services.comms.JsonParser;
import cr.tec.yatg.desktop.services.comms.TronClient;
import cr.tec.yatg.desktop.structures.SimplePlayer;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
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

	private SimplePlayer playerData;


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
				}
			}
		}.start();
	}

	private void refreshPlayerNumber() {
		playerNum.setText(Integer.toString(TronClient.getInstance().getCurrentPlayers()));
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
