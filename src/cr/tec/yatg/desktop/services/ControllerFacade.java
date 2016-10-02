package cr.tec.yatg.desktop.services;

import cr.tec.yatg.desktop.controllers.Matrix;

/**
 * Created by joseph on 26/09/16.
 */
public class ControllerFacade {
	private static final ControllerFacade ourInstance = new ControllerFacade();

	private Matrix matrixController;

	private ControllerFacade() {
	}

	public static ControllerFacade getInstance() {
		return ourInstance;
	}

	public Matrix getMatrix() {
		return this.matrixController;
	}

	public void setMatrix(Matrix controller) {
		this.matrixController = controller;
	}
}
