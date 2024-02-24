package com.example.spe_mini;
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
				System.out.println("\n============================================================");
				System.out.println("||               Welcome to Scientific                    ||");
				System.out.println("||                   Calculator                           ||");
				System.out.println("============================================================\n");

				System.out.println("Choose an operation:");
				System.out.println("1. Power (^)");
				System.out.println("2. logarithm with base e(ln)");
				System.out.println("3. Square Root (√)");
				System.out.println("4. Factorial (x!)");
				System.out.println("0. Exit");

				System.out.print("\nEnter your choice: ");
				String choice = br.readLine();

				switch (choice) {
					case "1":
						performOperation("Power", br);
						break;
					case "2":
						try {
							performOperationlog("Logarithm", br); // Call the modified method here
						} catch (IllegalArgumentException e) {
							System.out.println(e.getMessage());
						}
						break;
					case "3":
						performSingleInputOperation("Square Root", "√", br);
						break;
					case "4":
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
			case "Power":
				result = performPower(a, b);
				break;

			default:
				result = 0;
				break;
		}
		System.out.println("Result: " + result);
	}

    public static void performOperationlog(String operation, BufferedReader br) throws IOException {
        System.out.print("\nEnter the number: ");
        double a = Double.parseDouble(br.readLine());

        double result;
        switch (operation) {
            case "Logarithm":
                result = performLogarithmOperation(a);
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
	public static double performLogarithmOperation(double input) {
		if (input <= 0) {
			throw new IllegalArgumentException("Error: Logarithm of a non-positive number is undefined!");
		}
		return Math.log(input);
	}
}