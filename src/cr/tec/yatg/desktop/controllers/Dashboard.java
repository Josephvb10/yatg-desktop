package cr.tec.yatg.desktop.controllers;

import cr.tec.yatg.desktop.services.ControllerFacade;
import cr.tec.yatg.desktop.services.comms.ClientRead;
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


	@FXML
	protected void doSomething() throws Exception {


		serverIp.setText("192.168.1.0:8043");
		playerNum.setText("1");

		fuelBar.setProgress(0.5);

		//matrixController.setMoto(2, 3, 5);
		//matrixController.setEstela(2, 3, 6);


		//new PaintThread().start();
		new ClientRead().start();


	}

	public void exitGame() {
		System.out.println("Saliendo");
		Platform.exit();
		System.exit(0);
	}

	@Override
	public void initialize(URL location, ResourceBundle resource) {
		ControllerFacade.getInstance().setMatrix(matrixController);
	}
}
