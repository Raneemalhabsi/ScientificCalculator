import java.util.Scanner;
import java.util.InputMismatchException;

public class ScientificCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("Choose an option: ");
            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // Clear invalid input
                continue; // Restart loop
            }

            switch (choice) {
                case 1:
                    performAddition(scanner);
                    break;
                case 2:
                    performSubtraction(scanner);
                    break;
                case 3:
                    performMultiplication(scanner);
                    break;
                case 4:
                    performDivision(scanner);
                    break;
                case 5:
                    performSquareRoot(scanner);
                    break;
                case 6:
                    performPower(scanner);
                    break;
                case 7:
                    performSine(scanner);
                    break;
                case 8:
                    performCosine(scanner);
                    break;
                case 9:
                    performTangent(scanner);
                    break;
                case 10:
                    performNaturalLog(scanner);
                    break;
                case 11:
                    performLogBase10(scanner);
                    break;
                case 12:
                    performAbsoluteValue(scanner);
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting calculator. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("\n=== SCIENTIFIC CALCULATOR MENU ===");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Square Root");
        System.out.println("6. Power (x^y)");
        System.out.println("7. Sine (in degrees)");
        System.out.println("8. Cosine (in degrees)");
        System.out.println("9. Tangent (in degrees)");
        System.out.println("10. Natural Logarithm");
        System.out.println("11. Base-10 Logarithm (log₁₀)");
        System.out.println("12. Absolute Value");
        System.out.println("0. Exit");
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
    public static double divide(double num1, double num2) throws ArithmeticException {
        if (num2 == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return num1 / num2;
    }
    public static double squareRoot(double num) throws ArithmeticException {
        if (num < 0) {
            throw new ArithmeticException("Cannot calculate square root of a negative number.");
        }
        return Math.sqrt(num);
    }
    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
    public static double sine(double degrees) {
        double radians = Math.toRadians(degrees);  // Convert degrees to radians
        return Math.sin(radians);
    }
    public static double cosine(double degrees) {
        double radians = Math.toRadians(degrees);  // Convert degrees to radians
        return Math.cos(radians);
    }
    public static double tangent(double degrees) throws ArithmeticException {
        // Tangent is undefined at 90°, 270°, etc. (odd multiples of 90 where cos = 0)
        double angleMod = degrees % 180;
        if (angleMod == 90 || angleMod == -90) {
            throw new ArithmeticException("Tangent is undefined at " + degrees + "°.");
        }
        double radians = Math.toRadians(degrees);
        return Math.tan(radians);
    }
    public static double naturalLog(double num) throws ArithmeticException {
        if (num <= 0) {
            throw new ArithmeticException("Natural logarithm is undefined for zero or negative numbers.");
        }
        return Math.log(num); // Math.log() is ln in Java
    }
    public static double logBase10(double num) throws ArithmeticException {
        if (num <= 0) {
            throw new ArithmeticException("Base-10 logarithm is undefined for zero or negative numbers.");
        }
        return Math.log10(num); // Math.log10() gives log base 10
    }
    public static double absoluteValue(double num) {
        return Math.abs(num);
    }











    private static void performAddition(Scanner scanner) {
        try {
            System.out.print("Enter first number: ");
            double a = scanner.nextDouble();

            System.out.print("Enter second number: ");
            double b = scanner.nextDouble();

            double result = add(a, b);
            System.out.println("Result: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter numeric values.");
            scanner.nextLine();
        }
    }
    private static void performSubtraction(Scanner scanner) {
        try {
            System.out.print("Enter first number: ");
            double a = scanner.nextDouble();

            System.out.print("Enter second number: ");
            double b = scanner.nextDouble();

            double result = subtract(a, b);
            System.out.println("Result: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter numeric values.");
            scanner.nextLine();
        }
    }
    private static void performMultiplication(Scanner scanner) {
        try {
            System.out.print("Enter first number: ");
            double a = scanner.nextDouble();

            System.out.print("Enter second number: ");
            double b = scanner.nextDouble();

            double result = multiply(a, b);
            System.out.println("Result: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter numeric values.");
            scanner.nextLine();
        }
    }
    private static void performDivision(Scanner scanner) {
        try {
            System.out.print("Enter numerator: ");
            double a = scanner.nextDouble();

            System.out.print("Enter denominator: ");
            double b = scanner.nextDouble();

            double result = divide(a, b);
            System.out.println("Result: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter numeric values.");
            scanner.nextLine(); // clear buffer
        } catch (ArithmeticException e) {
            System.out.println("Math error: " + e.getMessage());
        }
    }
    private static void performSquareRoot(Scanner scanner) {
        try {
            System.out.print("Enter a number: ");
            double num = scanner.nextDouble();

            double result = squareRoot(num);
            System.out.println("Result: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a numeric value.");
            scanner.nextLine(); // clear buffer
        } catch (ArithmeticException e) {
            System.out.println("Math error: " + e.getMessage());
        }
    }
    private static void performPower(Scanner scanner) {
        try {
            System.out.print("Enter the base: ");
            double base = scanner.nextDouble();

            System.out.print("Enter the exponent: ");
            double exponent = scanner.nextDouble();

            double result = power(base, exponent);
            System.out.println("Result: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter numeric values.");
            scanner.nextLine(); // clear buffer
        }
    }
    private static void performSine(Scanner scanner) {
        try {
            System.out.print("Enter angle in degrees: ");
            double degrees = scanner.nextDouble();

            double result = sine(degrees);
            System.out.println("Result (sin(" + degrees + "°)): " + result);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a numeric value.");
            scanner.nextLine(); // clear buffer
        }
    }
    private static void performCosine(Scanner scanner) {
        try {
            System.out.print("Enter angle in degrees: ");
            double degrees = scanner.nextDouble();

            double result = cosine(degrees);
            System.out.println("Result (cos(" + degrees + "°)): " + result);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a numeric value.");
            scanner.nextLine(); // clear buffer
        }
    }
    private static void performTangent(Scanner scanner) {
        try {
            System.out.print("Enter angle in degrees: ");
            double degrees = scanner.nextDouble();

            double result = tangent(degrees);
            System.out.println("Result (tan(" + degrees + "°)): " + result);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a numeric value.");
            scanner.nextLine(); // clear buffer
        } catch (ArithmeticException e) {
            System.out.println("Math error: " + e.getMessage());
        }
    }
    private static void performNaturalLog(Scanner scanner) {
        try {
            System.out.print("Enter a positive number: ");
            double num = scanner.nextDouble();

            double result = naturalLog(num);
            System.out.println("Result (ln(" + num + ")): " + result);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a numeric value.");
            scanner.nextLine(); // clear buffer
        } catch (ArithmeticException e) {
            System.out.println("Math error: " + e.getMessage());
        }
    }
    private static void performLogBase10(Scanner scanner) {
        try {
            System.out.print("Enter a positive number: ");
            double num = scanner.nextDouble();

            double result = logBase10(num);
            System.out.println("Result (log₁₀(" + num + ")): " + result);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a numeric value.");
            scanner.nextLine(); // clear buffer
        } catch (ArithmeticException e) {
            System.out.println("Math error: " + e.getMessage());
        }
    }
    private static void performAbsoluteValue(Scanner scanner) {
        try {
            System.out.print("Enter a number: ");
            double num = scanner.nextDouble();

            double result = absoluteValue(num);
            System.out.println("Result (|"+ num + "|): " + result);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a numeric value.");
            scanner.nextLine(); // clear buffer
        }
    }









}

