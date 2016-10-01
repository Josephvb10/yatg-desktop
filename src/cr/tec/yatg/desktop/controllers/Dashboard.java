package cr.tec.yatg.desktop.controllers;

import cr.tec.yatg.desktop.services.ControllerFacade;
import cr.tec.yatg.desktop.services.Runner;
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
		/*Random rand = new Random(System.currentTimeMillis());
		int r = rand.nextInt(255);
		int g = rand.nextInt(255);
		int b = rand.nextInt(255);
		a1.setFill(Color.rgb(r, g, b));

		//clean();
		Matrix.getInstance().setMoto(1, 20, 10);

		//setEstela(1,20,12);
		//setEstela(1,20,13);*/


		//matrixController.setEstela(1, 20, 11);

		Platform.setImplicitExit(false);
		Runner R1 = new Runner("Nombre", matrixController);
		R1.start();

		serverIp.setText("192.168.1.0:8043");
		playerNum.setText("1");

		fuelBar.setProgress(0.5);

	}

	public void exitGame() {
		System.out.println("Saliendo");
		Platform.exit();
		System.exit(0);
	}


	public void initialize(MouseEvent mouseEvent) {
		ControllerFacade.getInstance().setMatrix(matrixController);
		ControllerFacade.getInstance().getMatrix().setEstela(1, 5, 6);
	}
}
