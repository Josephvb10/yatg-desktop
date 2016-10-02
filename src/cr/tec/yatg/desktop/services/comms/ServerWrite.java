package cr.tec.yatg.desktop.services.comms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by joseph on 10/2/16.
 */
public class ServerWrite extends Thread {
	private final BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));


	public void run() {
		while (true) {
			String userInput = null;
			try {
				userInput = stdIn.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (userInput != null) {
				if (userInput.trim().equals("p")) {
					System.out.println("Lista de jugadores:");
					for (int j = 1; j <= 4; j++) {
						System.out.println("Jugador " + j + ": " + TronServer.players.get(j).getName());
					}
				} else {
					System.out.println("Server dije: " + userInput);
					TronServer.players.sendAll("Servidor dijo: " + userInput);
				}
			}
		}
	}
}
