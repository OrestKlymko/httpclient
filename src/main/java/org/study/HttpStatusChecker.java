package org.study;

import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
	private HttpURLConnection connection;

	public String getStatusImage(int code) throws Exception {

		try {
			URL url = new URL("https://http.cat/"+code+".jpg");
			connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			return url.toString();
		}catch (Exception e){
			throw new RuntimeException("Image not found");
		}finally {
			connection.disconnect();
		}

	}
}
