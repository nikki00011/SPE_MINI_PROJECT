package com.example.spe_mini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class SpeMiniApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpeMiniApplication.class, args);
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Scientific Calculator Menu:");
			System.out.println("1. Square Root");
			System.out.println("2. Factorial");
			System.out.println("3. Natural Logarithm");
			System.out.println("4. Power Function");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();

			switch (choice) {
				case 1:
					System.out.print("Enter a number: ");
					double num = scanner.nextDouble();
					System.out.println("Square root of " + num + " is: " + Math.sqrt(num));
					break;
				case 2:
					System.out.print("Enter a number: ");
					int n = scanner.nextInt();
					System.out.println("Factorial of " + n + " is: " + factorial(n));
					break;
				case 3:
					System.out.print("Enter a number: ");
					double x = scanner.nextDouble();
					System.out.println("Natural logarithm of " + x + " is: " + Math.log(x));
					break;
				case 4:
					System.out.print("Enter base: ");
					double base = scanner.nextDouble();
					System.out.print("Enter exponent: ");
					double exponent = scanner.nextDouble();
					System.out.println(base + " raised to the power of " + exponent + " is: " + Math.pow(base, exponent));
					break;
				case 5:
					System.out.println("Exiting...");
					System.exit(0);
				default:
					System.out.println("Invalid choice. Please enter a valid option.");
			}
		}
	}

	public static int factorial(int n) {
		if (n == 0)
			return 1;
		else
			return (n * factorial(n - 1));
	}

}
