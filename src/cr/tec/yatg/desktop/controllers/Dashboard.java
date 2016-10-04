package cr.tec.yatg.desktop.controllers;

import cr.tec.yatg.desktop.services.ControllerFacade;
import cr.tec.yatg.desktop.services.comms.ClientRead;
import cr.tec.yatg.desktop.services.comms.JsonParser;
import cr.tec.yatg.desktop.structures.SimplePlayer;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
	private Label serverIp;
	@FXML
	private Label playerNum;
	@FXML
	private ProgressBar fuelBar;

	private SimplePlayer playerData;


	@Override
	public void initialize(URL location, ResourceBundle resource) {
		ControllerFacade.getInstance().setMatrix(matrixController);

		new ClientRead("localhost", 8081).start();


		new AnimationTimer() {
			public void handle(long currentNanoTime) {
				playerData = JsonParser.getInstance().getPlayerData();
				if (playerData != null) {
					refreshFuel();
				}
			}
		}.start();
	}

	@FXML
	protected void doSomething() throws Exception {


		serverIp.setText("192.168.1.0:8043");
		playerNum.setText("1");

		fuelBar.setProgress(0.5);

		//matrixController.setMoto(2, 3, 5);
		//matrixController.setEstela(2, 3, 6);


		//new PaintThread().start();


	}

	public void exitGame() {
		System.out.println("Saliendo");
		Platform.exit();
		System.exit(0);
	}

	public void refreshFuel() {
		fuelBar.setProgress(playerData.getFuel() / 100);

	}


}
