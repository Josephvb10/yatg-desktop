package cr.tec.yatg.desktop.services;

/**
 * Created by joseph on 22/09/16.
 */
public class JsonDecoder {
	private static JsonDecoder ourInstance = new JsonDecoder();

	private JsonDecoder() {
	}

	public static JsonDecoder getInstance() {
		return ourInstance;
	}
}
