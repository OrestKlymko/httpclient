package org.study;

import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
	private HttpURLConnection connection;

	public String getStatusImage(int code) throws Exception {
		URL url = new URL("https://http.cat/"+code+".jpg");
		connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		connection.disconnect();

		if(connection.getResponseCode()==200) {
			return url.toString();
		}
		else {
			throw new RuntimeException("Image not found");
		}
	}
}
