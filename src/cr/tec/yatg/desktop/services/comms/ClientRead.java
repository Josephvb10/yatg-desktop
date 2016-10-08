package cr.tec.yatg.desktop.services.comms;

import cr.tec.yatg.desktop.services.ControllerFacade;
import javafx.application.Platform;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by joseph on 10/2/16.
 */
public class ClientRead extends Thread {
	private final BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	private String serverIp;
	private int serverPort;
	private BufferedReader in;

	public ClientRead(BufferedReader in) {
		this.in = in;
	}


	@Override
	public void run() {
		if (TronClient.getInstance().isRunning()) {
			try {
				String line;
				while ((line = in.readLine()) != null) {
					// Si el mensaje es un comando
					if (line.substring(0, 1).equals("%")) {
						String cmd = line.substring(1, 2);
						switch (cmd){
							case "C":
								final String fLine = line.replace("@@#", "\n");
								ControllerFacade.getInstance().printPlayers(fLine.substring(2));
								break;
							case "L":
								long result = System.currentTimeMillis() - Long.parseLong(line.substring(2));
								System.out.println("Latencia: " + result + "ms");
								break;
							case "D":
								Platform.runLater(() -> {
									ControllerFacade.getInstance().getMatrix().died();
								});
								break;
							case "K":
								//TronClient.getInstance().stop();
								//ControllerFacade.getInstance().kicked();
								break;
							case "P":
								System.out.println("PlayNo Recibido");
								TronClient.getInstance().setCurrentPlayers(Integer.parseInt(line.substring(2,3)));
							default:
								break;
						}
					} else {
						JsonParser.getInstance().parseJson(line);
					}
					// TODO: 10/3/16 ESTO HAY QUE QUITARLO Lol
					//System.out.println(line);

				}
			} catch (IOException e) {
				//ControllerFacade.getInstance().serverDead();
				System.out.println("Se ha desconectado del servidor");
			}
		}
	}

}
