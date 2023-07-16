package org.study;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {
		public void askStatus() {
		Scanner scanner = new Scanner(System.in);
		int inputCode = 0;

		try {
			System.out.print("Enter HTTP status code: ");
			inputCode = scanner.nextInt();
			scanner.close();
			new HttpStatusImageDownloader().downloadStatusImage(inputCode);
		} catch (InputMismatchException e) {
			throw new InputMismatchException("Enter valid code");
		} catch (Exception e) {
			throw new RuntimeException("There is not image for HTTP status " + inputCode);
		}
	}
}
