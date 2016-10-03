package cr.tec.yatg.desktop.controllers;

import cr.tec.yatg.desktop.services.ControllerFacade;
import cr.tec.yatg.desktop.services.comms.ClientRead;
import cr.tec.yatg.desktop.services.comms.PaintThread;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * Main GUI controller
 * Created by joseph on 22/09/16.
 */
public class Dashboard {

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
		ControllerFacade.getInstance().getMatrix().clean();


		serverIp.setText("192.168.1.0:8043");
		playerNum.setText("1");

		fuelBar.setProgress(0.5);

		new PaintThread().start();
		new ClientRead().start();


	}

	public void exitGame() {
		System.out.println("Saliendo");
		Platform.exit();
		System.exit(0);
	}


	public void initialize(MouseEvent mouseEvent) {
		ControllerFacade.getInstance().setMatrix(matrixController);
	}
}
