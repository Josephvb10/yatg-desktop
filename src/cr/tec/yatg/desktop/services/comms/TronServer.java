package cr.tec.yatg.desktop.services.comms;

import java.io.PrintWriter;
import java.net.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by joseph on 10/2/16.
 */
public class TronServer {
	private static final int PORT = 8081;
	public static PlayerArray players = new PlayerArray();
	private static HashSet<String> names = new HashSet<String>();
	private static HashSet<PrintWriter> clients = new HashSet<PrintWriter>();
	private static Map<String, PrintWriter> map = new HashMap<String, PrintWriter>();

	public static HashSet<String> getNames() {
		return names;
	}

	public static HashSet<PrintWriter> getClients() {
		return clients;
	}

	public static Map<String, PrintWriter> getMap() {
		return map;
	}

	public static void main(String[] args) {

		try {

			ServerSocket listener = new ServerSocket(PORT);
			// TODO: 10/2/16 Mostrar la IP visualmente
			System.out.println("IP del server: " + getIP());

			new ServerWrite().start();

			try {
				while (true) {
					System.out.println("Escuchando clientes");
					new ServerRead(listener.accept()).start();
				}
			} finally {
				listener.close();
			}
		} catch (Exception e) {
			// TODO: 10/2/16 Agregar un mensaje visual para el error cuando no puede abrir el server
			System.out.println("Error al abrir el socket");
		}

	}

	public static String getIP() {
		String ip = "no network";
		try {
			Enumeration<NetworkInterface> n = NetworkInterface.getNetworkInterfaces();
			outmost:
			for (; n.hasMoreElements(); ) {
				NetworkInterface e = n.nextElement();
				Enumeration<InetAddress> a = e.getInetAddresses();
				for (; a.hasMoreElements(); ) {
					InetAddress addr = a.nextElement();
					if (addr instanceof Inet4Address) { // return the first IPv4 addr (127.0.1.1 is always last)
						if (addr.isSiteLocalAddress()) {
							ip = addr.getHostAddress();
							break outmost;
						}

					}
				}
			}
		} catch (SocketException e) {
		}
		return ip;
	}
}
