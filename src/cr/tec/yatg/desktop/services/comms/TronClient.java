package cr.tec.yatg.desktop.services.comms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by joseph on 10/3/16.
 */
public class TronClient {
	private static TronClient ourInstance = new TronClient();
	private String serverIp;
	private int currentPlayers = 0;
	private int serverPort;
	private BufferedReader in;
	private PrintWriter out;
	private Socket socket;
	//private ClientWrite write;
	private ClientRead read;
	private boolean running = false;
	private TronClient() {
	}

	public static TronClient getInstance() {
		return ourInstance;
	}

	public String getServerIp() {
		return serverIp;
	}

	public int getServerPort() {
		return serverPort;
	}

	public boolean connect(String ip, int port) {
		try {
			this.serverIp = ip;
			this.serverPort = port;
			socket = new Socket();
			socket.connect(new InetSocketAddress(serverIp, serverPort), 3000);
			if (this.socket == null) {
				return false;
			}
			this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.out = new PrintWriter(socket.getOutputStream(), true);
			return ping();

		} catch (Exception e) {
			return false;
		}
	}

	public void disconnect() {
		try {
			socket.close();
		} catch (IOException e) {

		}
	}

	private boolean ping() {
		out.println("TECPING");
		long timeoutMs = 1;
		long timeoutExpiredMs = System.currentTimeMillis() + timeoutMs;
		try {
			String line;
			while (true) {
				if ((line = in.readLine()) != null) {
					System.out.println("TECPONG recibido");
					return line.equals("TECPONG");
				}
				if (System.currentTimeMillis() >= timeoutExpiredMs) {
					System.out.println("Timeout alcanzado");
					return false;
				}
			}
		} catch (IOException e) {
			System.out.println("Error al esperar TECPONG");
			return false;
		}
	}

	public String joinIfCan(String name) {
		out.println("%J" + name);
		long timeoutMs = 1;
		long timeoutExpiredMs = System.currentTimeMillis() + timeoutMs;
		try {
			String line;
			while (true) {
				if ((line = in.readLine()) != null) {
					if (line.equals("OK")) {
						this.running = true;
						//write = new ClientWrite(out);
						//write.start();
						read = new ClientRead(in);
						read.start();
						return "OK";
					} else {
						return line;
					}
				}
				if (System.currentTimeMillis() >= timeoutExpiredMs) {
					return "El servidor no responde.";
				}
			}
		} catch (IOException e) {
			return "El servidor no responde.";
		}
	}

	public void send(String msg) {
		new Thread() {
			public void run() {
				out.println(msg);
			}
		}.start();

	}

	public boolean isRunning() {
		return running;
	}

	public void stop() {
		this.running = false;
	}

	public int getCurrentPlayers() {
		return currentPlayers;
	}

	public void setCurrentPlayers(int currentPlayers) {
		this.currentPlayers = currentPlayers;
	}
}
