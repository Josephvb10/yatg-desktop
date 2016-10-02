package cr.tec.yatg.desktop.services.comms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by joseph on 10/2/16.
 */
public class ServerWrite extends Thread {
	BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));


	public void run() {
		while (true) {
			String userInput = null;
			try {
				userInput = stdIn.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (userInput != null) {
				System.out.println("Server dije:" + userInput);
				for (PrintWriter writer : TronServer.getClients()) {
					writer.println("Servidor dijo: " + userInput);
					writer.flush();
				}
			}
		}
	}
}
