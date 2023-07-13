package org.study;

import java.util.Scanner;

public class HttpImageStatusCli {
		public void askStatus() {
		Scanner scanner = new Scanner(System.in);
		int inputCode = 0;

		try {
			System.out.print("Enter HTTP status code: ");
			inputCode = scanner.nextInt();
			scanner.close();
			new HttpStatusChecker().getStatusImage(inputCode);
			new HttpStatusImageDownloader().downloadStatusImage(inputCode);
		} catch (InputMismatchException e) {
			System.out.println("Enter valid code");
		} catch (Exception e) {
			throw new RuntimeException("There is not image for HTTP status " + inputCode);
		}
	}
}
