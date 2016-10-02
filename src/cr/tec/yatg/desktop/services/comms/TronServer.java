package cr.tec.yatg.desktop.services.comms;

import java.net.*;
import java.util.Enumeration;

/**
 * Created by joseph on 10/2/16.
 */
public class TronServer {
	public static final PlayerArray players = new PlayerArray();
	private static final int PORT = 8081;

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
