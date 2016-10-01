package cr.tec.yatg.desktop.services;

import java.io.IOException;
import java.io.StringWriter;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter {

	public static String objectToJson(Object value) {
		ObjectMapper objectMapper = new ObjectMapper();
		StringWriter stringJson = new StringWriter();
		try {
			objectMapper.writeValue(stringJson, value);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		return stringJson.toString();

	}

}
