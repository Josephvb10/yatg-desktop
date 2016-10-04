package cr.tec.yatg.desktop.services.comms;

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

						// O si no es un JSON
					} else {
						JsonParser.getInstance().parseJson(line);
					}
					// TODO: 10/3/16 ESTO HAY QUE QUITARLO Lol
					System.out.println(line);

				}
			} catch (IOException e) {
				System.out.println("Se ha desconectado del servidor");
			}
		}
	}

}
