package cr.tec.yatg.desktop.services.comms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/** Clase encargada de leer los Sockets y procesarlos
 * Created by joseph on 10/2/16.
 */
public class ServerRead extends Thread {
	private Socket socket;
	private String ip;
	private BufferedReader in;
	private PrintWriter out;
	private String name;
	private boolean running = true;
	private boolean joined = false;

	ServerRead(Socket socket) {
		try {
			this.socket = socket;
			this.ip = socket.getRemoteSocketAddress().toString();
			this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.out = new PrintWriter(socket.getOutputStream(), true);
			System.out.println("Cliente " + ip + " se intenta conectar");
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error al intentar conectarse con " + ip);
			this.running = false;
			Thread.currentThread().interrupt();
		}
	}


	private void addPlayer() {
		synchronized (TronServer.getClients()) {
			if (!TronServer.getClients().contains(name)) {
				TronServer.getClients().insertAvailable(name, out);
			}
		}
		System.out.println("Cliente " + ip + " se ha unido al juego y se llama " + name);
		System.out.println("Actualmente hay " + TronServer.getClients().getSize() + " clientes conectados");
	}

	public void run() {
		try {
			String line;

			// Este loop se ejecuta al inicio antes de que se una
			while (true) {
				line = in.readLine();
				if (line.equals("PING")) {
					out.println("PONG");
				}

				if (line.substring(0, 2).equals("%J")) {
					if (TronServer.getClients().getSize() >= 4) {
						System.out.println("Cliente removido. Ya hay más de 4");
						out.println("%ELo sentimos. Este servidor ya está lleno.");
						Thread.currentThread().interrupt();
						running = false;
						break;
					} else if (TronServer.getClients().contains(name)) {
						System.out.println("Cliente removido. Se intenta llamar " + name + " pero ya existe con ese nombre");
						out.println("%EEse nombre ya está en uso, por favor elige otro.");
						Thread.currentThread().interrupt();
						running = false;
						break;

					} else {
						this.name = line.substring(2);
						addPlayer();
						out.println("OK");
						this.joined = true;
						break;
					}

				}
			}

			// Este loop se ejecuta cuando está unido
			while (running && joined) {
				while ((line = in.readLine()) != null) {
					// Hacer algo
					System.out.println(name + " dijo: " + line);
				}
			}


		} catch (Exception e) {
			// TODO: 10/2/16 Mostrar error gráficamente por si se despicha el thread
			System.out.println("Desconexión: " + e.getMessage());
		} finally {
			if (running) {
				System.out.println(name + " se ha desconectado");

				TronServer.getClients().remove(name);

				System.out.println("Actualmente hay " + TronServer.getClients().getSize() + " clientes conectados");
				try {
					socket.close();
				} catch (IOException e) {
					// No se hace nada si hay un error al cerrar el thread, ya que de verdad no importa
				}
			}
		}
	}
}
