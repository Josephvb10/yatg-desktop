package cr.tec.yatg.desktop.services;

import cr.tec.yatg.desktop.controllers.Matrix;
import javafx.application.Platform;

/**
 * Threads del JSON
 * Created by joseph on 22/09/16.
 */
public class Runner implements Runnable {
	private Thread t;
	private String threadName;
	private Matrix matrix;

	public Runner(String name, Matrix controller) {
		threadName = name;
		System.out.println("Creating " + threadName);
		this.matrix = controller;
	}

	public void run() {
		System.out.println("Running " + threadName);
		try {
			for (int i = 1; i < 40; i++) {
				for (int j = 1; j < 40; j++) {
					final int fi = i;
					final int fj = j;
					System.out.println("(" + fi + ", " + fj);
					Platform.runLater(() -> {
						ControllerFacade.getInstance().getMatrix().clean();
						ControllerFacade.getInstance().getMatrix().setEstela(fi, fi, fj);
						ControllerFacade.getInstance().getMatrix().setEstela(fi, fi, fj + 1);
						ControllerFacade.getInstance().getMatrix().setEstela(fi, fi, fj + 2);
						ControllerFacade.getInstance().getMatrix().setMoto(fi, fi, fj + 3);
					});
					Thread.sleep(35);
				}
				//Dashboard.clean();
				// Let the thread sleep for a while.
				//Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread " + threadName + " interrupted.");
		}
		System.out.println("Thread " + threadName + " exiting.");
	}

	public void start() {
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}
}
