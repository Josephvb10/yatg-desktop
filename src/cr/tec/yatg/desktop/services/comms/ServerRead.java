package cr.tec.yatg.desktop.services.comms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by joseph on 10/2/16.
 */
public class ServerRead extends Thread {
	private String name;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private String ip;
	private String input;

	ServerRead(Socket socket) {
		this.socket = socket;
		this.ip = socket.getRemoteSocketAddress().toString();
		System.out.println("Cliente " + ip + " conectado");
	}

	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);


			// Este while es curioso, no se ejecuta por siempre, pero hasta que responda el nombre
			while (true) {
				out.println("Escriba su nombre");
				name = in.readLine();
				if (name == null) {
					return;
				}
				TronServer.getMap().put(name, out);
				System.out.println("Actualmente hay " + TronServer.getMap().size() + " clientes conectados");


				System.out.println("Cliente " + ip + " se llama " + name);
				synchronized (TronServer.getNames()) {
					if (!TronServer.getNames().contains(name)) {
						TronServer.getNames().add(name);
						break;
					}
				}
			}

			// Esto se ejecuta cuando ya salió del while al responder el cliente
			out.println("Conexión establecida");
			TronServer.getClients().add(out);
			TronServer.players.insertAvailable(name, out);


			// Este lee los mensajes
			while ((input = in.readLine()) != null) {
				System.out.println(name + "(" + ip + ") dijo: " + input);
				TronServer.players.sendAll(name + "(" + ip + ") dijo: " + input);
			}

		} catch (Exception e) {
			// TODO: 10/2/16 Mostrar error gráficamente por si se despicha el thread
			System.out.println(e);
		} finally {
			System.out.println(name + "se ha desconectado");

			TronServer.players.remove(name);

			System.out.println("Actualmente hay " + TronServer.players.getSize() + " clientes conectados");


			try {
				socket.close();
			} catch (IOException e) {
				// No se hace nada si hay un error al cerrar el thread, ya que de verdad no importa
			}
		}
	}
}
