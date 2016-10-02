package cr.tec.yatg.desktop.controllers;

import cr.tec.yatg.desktop.services.ControllerFacade;
import cr.tec.yatg.desktop.services.comms.OutputMessage;
import cr.tec.yatg.desktop.services.testMalla;
import cr.tec.yatg.desktop.structures.Item;
import cr.tec.yatg.desktop.structures.ItemType;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

/**
 * Main GUI controller
 * Created by joseph on 22/09/16.
 */
public class Dashboard {

	@FXML
	private final Matrix matrixController;
	@FXML
	private final Label serverIp;
	@FXML
	private final Label playerNum;
	@FXML
	private final ProgressBar fuelBar;
	@FXML
	private Pane dashboard;

	@FXML
	protected void doSomething() throws Exception {
		ControllerFacade.getInstance().getMatrix().clean();
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

		//Platform.setImplicitExit(false);
		//Runner R1 = new Runner("Nombre", matrixController);
		//R1.start();

		serverIp.setText("192.168.1.0:8043");
		playerNum.setText("1");

		fuelBar.setProgress(0.5);

		testMalla test = new testMalla();
		OutputMessage msg = test.main();

		ArrayList<Item> items = msg.getItemList();

		for (Item data : items) {
			System.out.println("(" + data.getType() + ")");
			if (data.getType() == ItemType.tronTrail) {
				System.out.println("(" + data.getIndexI() + ", " + data.getIndexJ() + ")");
				if (data.getFirst()) {
					ControllerFacade.getInstance().getMatrix().setMoto(data.getOwner().value, data.getIndexI(), data.getIndexJ());
				} else {
					ControllerFacade.getInstance().getMatrix().setEstela(data.getOwner().value, data.getIndexI(), data.getIndexJ());

				}
			}
		}


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
