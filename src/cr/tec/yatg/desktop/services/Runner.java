package cr.tec.yatg.desktop.services;

import cr.tec.yatg.desktop.controllers.Matrix;

/**
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
			for (int i = 0; i < 40; i++) {
				System.out.println("Thread: " + threadName + ", " + i);
				matrix.clean();
				matrix.setEstela(1, i, 11);
				//Dashboard.clean();
				// Let the thread sleep for a while.
				Thread.sleep(50);
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
