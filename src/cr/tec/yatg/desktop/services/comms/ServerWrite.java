package cr.tec.yatg.desktop.services.comms;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by joseph on 10/2/16.
 */
public class ServerWrite extends Thread {
	private final BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));


	public void run() {
		while (true) {
			int i = 0;
			while (true) {
				i++;

				String json = "{\"id\":1,\"player\":{\"owner\":\"player1\",\"speed\":2,\"fuel\":98.79999999999998,\"currentDirection\":\"right\",\"extraTrail\":1,\"powerUpSteps\":0,\"powerUpActivated\":false,\"dead\":false,\"itemsPriorityQueue\":null},\"itemList\":[{\"type\":\"bomb\",\"indexI\":1,\"indexJ\":0,\"value\":0,\"first\":false,\"owner\":null},{\"type\":\"bomb\",\"indexI\":1,\"indexJ\":1,\"value\":0,\"first\":false,\"owner\":null},{\"type\":\"increaseTail\",\"indexI\":1,\"indexJ\":2,\"value\":8,\"first\":false,\"owner\":null},{\"type\":\"increaseTail\",\"indexI\":1,\"indexJ\":3,\"value\":6,\"first\":false,\"owner\":null},{\"type\":\"shield\",\"indexI\":2,\"indexJ\":1,\"value\":20,\"first\":false,\"owner\":null},{\"type\":\"turbo\",\"indexI\":3,\"indexJ\":2,\"value\":1,\"first\":false,\"owner\":null},{\"type\":\"fuel\",\"indexI\":5,\"indexJ\":3,\"value\":38,\"first\":false,\"owner\":null},{\"type\":\"tronTrail\",\"indexI\":8,\"indexJ\":0,\"value\":0,\"first\":false,\"owner\":\"player1\"},{\"type\":\"tronTrail\",\"indexI\":" + i + ",\"indexJ\":1,\"value\":0,\"first\":false,\"owner\":\"player1\"},{\"type\":\"tronTrail\",\"indexI\":8,\"indexJ\":2,\"value\":0,\"first\":false,\"owner\":\"player1\"},{\"type\":\"tronTrail\",\"indexI\":8,\"indexJ\":3,\"value\":0,\"first\":false,\"owner\":\"player1\"},{\"type\":\"tronTrail\",\"indexI\":8,\"indexJ\":4,\"value\":0,\"first\":true,\"owner\":\"player1\"},{\"type\":\"tronTrail\",\"indexI\":9,\"indexJ\":0,\"value\":0,\"first\":false,\"owner\":\"player1\"}]}";
				TronServer.getClients().sendAll(json);
				if (i == 29) {
					i = 1;
					TronServer.getClients().sendAll("%K");
				}
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			/*
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
					TronServer.players.sendAll(userInput);
				}
			}

			*/
		}
	}
}
