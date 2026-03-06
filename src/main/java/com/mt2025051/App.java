package com.mt2025051;

import java.util.Scanner;

public class App {

    public static double squareRoot(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Cannot take square root of negative number");
        }
        return Math.sqrt(x);
    }

    public static long factorial(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("Factorial not defined for negative numbers");
        }
        long result = 1;
        for (int i = 1; i <= x; i++) {
            result *= i;
        }
        return result;
    }

    public static double naturalLog(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("Log undefined for non-positive numbers");
        }
        return Math.log(x);
    }

    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Scientific Calculator ===");
            System.out.println("1. Square Root (√x)");
            System.out.println("2. Factorial (x!)");
            System.out.println("3. Natural Log (ln x)");
            System.out.println("4. Power (x^b)");
            System.out.println("5. Square(x^2)");
	    System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter number: ");
                        double num = sc.nextDouble();
                        System.out.println("Result: " + squareRoot(num));
                        break;

                    case 2:
                        System.out.print("Enter integer: ");
                        int n = sc.nextInt();
                        System.out.println("Result: " + factorial(n));
                        break;

                    case 3:
                        System.out.print("Enter number: ");
                        double logNum = sc.nextDouble();
                        System.out.println("Result: " + naturalLog(logNum));
                        break;

                    case 4:
                        System.out.print("Enter base: ");
                        double base = sc.nextDouble();
                        System.out.print("Enter exponent: ");
                        double exp = sc.nextDouble();
                        System.out.println("Result: " + power(base, exp));
                        break;

                    case 5:
				 System.out.print("Enter number: ");
    				num = sc.nextDouble();
    				System.out.println("Square: " + (num * num));
    				break;

case 6:
    System.exit(0);

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
