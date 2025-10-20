import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Calculator Application Solution for Assignment 2
 * - Demonstrates method overloading in the Calculator class
 * - Provides a menu-driven UserInterface with input validation
 *
 * Save this file as: UserInterface.java
 * Compile: javac UserInterface.java
 * Run: java UserInterface
 */

// Calculator class with overloaded methods
class Calculator {

    // Addition overloads
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Subtraction
    public int subtract(int a, int b) {
        return a - b;
    }

    // Multiplication
    public double multiply(double a, double b) {
        return a * b;
    }

    // Division (throws ArithmeticException for divide-by-zero)
    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return (double) a / b;
    }
}

// User interface and main menu
public class UserInterface {

    private final Scanner scanner;
    private final Calculator calc;

    public UserInterface() {
        scanner = new Scanner(System.in);
        calc = new Calculator();
    }

    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String line = scanner.nextLine().trim();
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer. Please try again.");
            }
        }
    }

    private double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String line = scanner.nextLine().trim();
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            }
        }
    }

    public void performAddition() {
        System.out.println("Choose addition variant:");
        System.out.println("1. add(int a, int b)");
        System.out.println("2. add(double a, double b)");
        System.out.println("3. add(int a, int b, int c)");
        int choice = readInt("Enter choice: ");
        switch (choice) {
            case 1: {
                int a = readInt("Enter first integer: ");
                int b = readInt("Enter second integer: ");
                int res = calc.add(a, b);
                System.out.println("Result: " + res);
                break;
            }
            case 2: {
                double a = readDouble("Enter first double: ");
                double b = readDouble("Enter second double: ");
                double res = calc.add(a, b);
                System.out.println("Result: " + res);
                break;
            }
            case 3: {
                int a = readInt("Enter first integer: ");
                int b = readInt("Enter second integer: ");
                int c = readInt("Enter third integer: ");
                int res = calc.add(a, b, c);
                System.out.println("Result: " + res);
                break;
            }
            default:
                System.out.println("Invalid choice for addition.");
        }
    }

    public void performSubtraction() {
        int a = readInt("Enter first integer: ");
        int b = readInt("Enter second integer: ");
        int res = calc.subtract(a, b);
        System.out.println("Result: " + res);
    }

    public void performMultiplication() {
        double a = readDouble("Enter first double: ");
        double b = readDouble("Enter second double: ");
        double res = calc.multiply(a, b);
        System.out.println("Result: " + res);
    }

    public void performDivision() {
        int a = readInt("Enter dividend (integer): ");
        int b = readInt("Enter divisor (integer): ");
        try {
            double res = calc.divide(a, b);
            System.out.println("Result: " + res);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void mainMenu() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to the Calculator Application!");
            System.out.println("1. Add Numbers");
            System.out.println("2. Subtract Numbers");
            System.out.println("3. Multiply Numbers");
            System.out.println("4. Divide Numbers");
            System.out.println("5. Exit");
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    performAddition();
                    break;
                case 2:
                    performSubtraction();
                    break;
                case 3:
                    performMultiplication();
                    break;
                case 4:
                    performDivision();
                    break;
                case 5:
                    System.out.println("Thank you for using the Calculator. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please select 1-5.");
            }
        }
    }

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.mainMenu();
    }
}
