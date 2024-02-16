package com.example.spe_mini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class SpeMiniApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpeMiniApplication.class, args);
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to Java Calculator!");
		System.out.println("Enter two numbers:");
		double num1 = scanner.nextDouble();
		double num2 = scanner.nextDouble();

		System.out.println("Select operation:");
		System.out.println("1. Addition");
		System.out.println("2. Subtraction");
		System.out.println("3. Multiplication");
		System.out.println("4. Division");
		int operation = scanner.nextInt();

		double result = 0;

		switch (operation) {
			case 1:
				result = add(num1, num2);
				break;
			case 2:
				result = subtract(num1, num2);
				break;
			case 3:
				result = multiply(num1, num2);
				break;
			case 4:
				result = divide(num1, num2);
				break;
			default:
				System.out.println("Invalid operation!");
		}

		System.out.println("Result: " + result);

		scanner.close();
	}

	public static double add(double num1, double num2) {
		return num1 + num2;
	}

	public static double subtract(double num1, double num2) {
		return num1 - num2;
	}

	public static double multiply(double num1, double num2) {
		return num1 * num2;
	}

	public static double divide(double num1, double num2) {
		if (num2 == 0) {
			System.out.println("Error: Cannot divide by zero!");
			return Double.NaN;
		}
		return num1 / num2;
	}

}
