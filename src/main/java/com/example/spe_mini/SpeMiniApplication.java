package com.example.spe_mini;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import java.util.Scanner;
//
//@SpringBootApplication
//public class SpeMiniApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(SpeMiniApplication.class, args);
//		Scanner scanner = new Scanner(System.in);
//
//		while (true) {
//			System.out.println("Scientific Calculator Menu:");
//			System.out.println("1. Square Root");
//			System.out.println("2. Factorial");
//			System.out.println("3. Natural Logarithm");
//			System.out.println("4. Power Function");
//			System.out.println("5. Exit");
//			System.out.print("Enter your choice: ");
//
//			int choice = scanner.nextInt();
//
//			switch (choice) {
//				case 1:
//					System.out.print("Enter a number: ");
//					double num = scanner.nextDouble();
//					System.out.println("Square root of " + num + " is: " + Math.sqrt(num));
//					break;
//				case 2:
//					System.out.print("Enter a number: ");
//					int n = scanner.nextInt();
//					System.out.println("Factorial of " + n + " is: " + factorial(n));
//					break;
//				case 3:
//					System.out.print("Enter a number: ");
//					double x = scanner.nextDouble();
//					System.out.println("Natural logarithm of " + x + " is: " + Math.log(x));
//					break;
//				case 4:
//					System.out.print("Enter base: ");
//					double base = scanner.nextDouble();
//					System.out.print("Enter exponent: ");
//					double exponent = scanner.nextDouble();
//					System.out.println(base + " raised to the power of " + exponent + " is: " + Math.pow(base, exponent));
//					break;
//				case 5:
//					System.out.println("Exiting...");
//					System.exit(0);
//				default:
//					System.out.println("Invalid choice. Please enter a valid option.");
//			}
//		}
//	}
//
//	public static int factorial(int n) {
//		if (n == 0)
//			return 1;
//		else
//			return (n * factorial(n - 1));
//	}
//
//}
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
@RestController
public class SpeMiniApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(SpeMiniApplication.class, args);

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			while (true) {
				clearConsole();
				System.out.println("\n***********************************************************");
				System.out.println("*                Welcome to Scientific       *");
				System.out.println("*                     Calculator               *");
				System.out.println("*************************************************************\n");

				System.out.println("Choose an operation:");
				System.out.println("1. Addition (+)");
				System.out.println("2. Subtraction (-)");
				System.out.println("3. Multiplication (x)");
				System.out.println("4. Division (÷)");
				System.out.println("5. Sine (sin)");
				System.out.println("6. Cosine (cos)");
				System.out.println("7. Tangent (tan)");
				System.out.println("8. Power (^)");
				System.out.println("9. Pi (π)");
				System.out.println("10. Square Root (√)");
				System.out.println("11. Factorial (x!)");
				System.out.println("0. Exit");

				System.out.print("\nEnter your choice: ");
				String choice = br.readLine();

				switch (choice) {
					case "1":
						performOperation("Addition", br);
						break;
					case "2":
						performOperation("Subtraction", br);
						break;
					case "3":
						performOperation("Multiplication", br);
						break;
					case "4":
						performOperation("Division", br);
						break;
					case "5":
						performSingleInputOperation("Sine", "sin", br);
						break;
					case "6":
						performSingleInputOperation("Cosine", "cos", br);
						break;
					case "7":
						performSingleInputOperation("Tangent", "tan", br);
						break;
					case "8":
						performOperation("Power", br);
						break;
					case "9":
						printPi();
						break;
					case "10":
						performSingleInputOperation("Square Root", "√", br);
						break;
					case "11":
						performFactorialOperation(br);
						break;
					case "0":
						System.out.println("\nExiting Program...");
						System.exit(0);
						return;
					default:
						System.out.println("\nInvalid choice! Please try again.");
				}
//                Thread.sleep(2000);
			}
		}
	}

	public static void clearConsole() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static void performOperation(String operation, BufferedReader br) throws IOException {
		System.out.print("\nEnter the first number: ");
		double a = Double.parseDouble(br.readLine());
		System.out.print("Enter the second number: ");
		double b = Double.parseDouble(br.readLine());
		double result;
		switch (operation) {
			case "Addition":
				result = performAddition(a, b);
				break;
			case "Subtraction":
				result = performSubtraction(a, b);
				break;
			case "Multiplication":
				result = performMultiplication(a, b);
				break;
			case "Division":
				result = performDivision(a, b);
				break;
			case "Power":
				result = performPower(a, b);
				break;
			default:
				result = 0;
				break;
		}
		System.out.println("Result: " + result);
	}

	public static void performSingleInputOperation(String operation, String symbol, BufferedReader br) throws IOException {
		System.out.print("\nEnter the number: ");
		double input = Double.parseDouble(br.readLine());
		double result;
		switch (operation) {
			case "Sine":
				result = performSine(input);
				break;
			case "Cosine":
				result = performCosine(input);
				break;
			case "Tangent":
				result = performTangent(input);
				break;
			case "Square Root":
				result = performSquareRoot(input);
				break;
			default:
				result = 0;
				break;
		}
		System.out.println("Result: " + symbol + "(" + input + ") = " + result);
	}

	public static void performFactorialOperation(BufferedReader br) throws IOException {
		System.out.print("\nEnter the number: ");
		int input = Integer.parseInt(br.readLine());
		double result = performFactorial(input);
		System.out.println("Result: " + input + "! = " + result);
	}

	public static void printPi() {
		System.out.println("\nπ = " + Math.PI);
	}

	public static double performAddition(double a, double b) {
		return a + b;
	}

	public static double performSubtraction(double a, double b) {
		return a - b;
	}

	public static double performMultiplication(double a, double b) {
		return a * b;
	}

	public static double performDivision(double a, double b) {
		if (b == 0) {
			throw new ArithmeticException("Division by zero!");
		}
		return a / b;
	}

	public static double performSine(double a) {
		return Math.sin(a);
	}

	public static double performCosine(double a) {
		return Math.cos(a);
	}

	public static double performTangent(double a) {
		return Math.tan(a);
	}

	public static double performPower(double a, double b) {
		return Math.pow(a, b);
	}

	public static double performSquareRoot(double a) {
		if (a < 0) {
			System.out.println("Error: Square root of a negative number is undefined!");
			return Double.NaN;
		} else {
			return Math.sqrt(a);
		}
	}

	public static double performFactorial(int n) {
		if (n < 0) {
			System.out.println("Error: Factorial of a negative number is undefined!");
			return Double.NaN;
		} else {
			long factorial = 1;
			for (int i = 1; i <= n; i++) {
				factorial *= i;
			}
			return factorial;
		}
	}
}