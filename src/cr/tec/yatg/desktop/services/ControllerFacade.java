package cr.tec.yatg.desktop.services;

import cr.tec.yatg.desktop.controllers.Dashboard;
import cr.tec.yatg.desktop.controllers.Matrix;
import javafx.application.Platform;

/**
 * Created by joseph on 26/09/16.
 */
public class ControllerFacade {
	private static final ControllerFacade ourInstance = new ControllerFacade();

	private Matrix matrixController;
	private Dashboard dashboard;

	private ControllerFacade() {
	}

	public static ControllerFacade getInstance() {
		return ourInstance;
	}

	public Dashboard getDashboard() {
		return dashboard;
	}

	public void setDashboard(Dashboard dashboardController) {
		this.dashboard = dashboardController;
	}

	public Matrix getMatrix() {
		return this.matrixController;
	}

	public void setMatrix(Matrix controller) {
		this.matrixController = controller;
	}

	public void kicked() {
		Platform.runLater(() -> {
			dashboard.kicked();
		});
	}

	public void serverDead() {
		Platform.runLater(() -> {
			dashboard.serverDead();
		});
	}
}
