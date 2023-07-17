package org.study;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class HttpStatusImageDownloader {
	private HttpURLConnection connection;

	public void downloadStatusImage(int code) throws IOException {

		try {
			HttpStatusChecker checker = new HttpStatusChecker();
			URL url = new URL(checker.getStatusImage(code));
			InputStream in = new BufferedInputStream(url.openStream());
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int n = 0;

			while (-1!=(n=in.read(buf)))
			{
				out.write(buf, 0, n);
			}
			out.close();
			in.close();
			InputStream inDocWrite = url.openStream();
			Files.copy(inDocWrite, Paths.get("src/main/resources/"+code+".jpg"));


		} catch (Exception e) {
			throw new RuntimeException("Image not found");
		}


	}
}



