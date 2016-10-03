package cr.tec.yatg.desktop.services.comms;

import cr.tec.yatg.desktop.services.ControllerFacade;
import cr.tec.yatg.desktop.structures.Item;
import cr.tec.yatg.desktop.structures.ItemType;
import javafx.application.Platform;

import java.util.ArrayList;

/**
 * Created by joseph on 10/2/16.
 */
public class PaintThread extends Thread {
	public void run() {
		while (true) {
			Platform.runLater(() -> {
						ControllerFacade.getInstance().getMatrix().clean();
						System.out.println("Voy a graficar a    jajajajajaja");
						ArrayList<Item> items = JsonConverter.getInstance().items;
						if (items != null) {
							System.out.println("no es null");
							for (Item data : items) {
								System.out.println("Hay item");
								System.out.println("(" + data.getType() + ")");
								if (data.getType() == ItemType.tronTrail) {
									System.out.println("(Tron trail recibida)");
									if (data.getFirst()) {
										ControllerFacade.getInstance().getMatrix().setMoto(data.getOwner().value, data.getIndexI(), data.getIndexJ());
									} else {
										System.out.println("No es first");
										ControllerFacade.getInstance().getMatrix().setEstela(data.getOwner().value, data.getIndexI(), data.getIndexJ());

									}
								}
							}
						}
					}
			);

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}


		}
	}
}
