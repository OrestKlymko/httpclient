package org.study;

import java.util.Scanner;

public class HttpImageStatusCli {
	public void askStatus(){

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter HTTP status code: ");
		int inputCode = scanner.nextInt();
		scanner.close();
		try {
			String statusImage = new HttpStatusChecker().getStatusImage(inputCode);
			new HttpStatusImageDownloader().downloadStatusImage(inputCode);
		} catch (Exception e) {
			throw new RuntimeException("There is not image for HTTP status "+inputCode);
		}

	}
}
