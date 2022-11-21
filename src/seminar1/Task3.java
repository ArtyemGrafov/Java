//Реализовать простой калькулятор

package seminar1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter operand(+-/*) : ");
            String operator = scanner.nextLine();
            System.out.print("Enter a : ");
            int a = scanner.nextInt();
            System.out.print("Enter b : ");
            int b = scanner.nextInt();

            switch (operator) {
                case "+" -> System.out.println(a + b);
                case "-" -> System.out.println(a - b);
                case "*" -> System.out.println(a * b);
                case "/" -> System.out.println((float) a / b);
                default -> System.out.println("Unknown operation");
            }
        } catch (InputMismatchException exception) {
            exception.printStackTrace();
        }

    }
}

/*public class Task3 {
    public static void main(String[] args) {
        String operand = getOperand("Enter operand(+-/*) : ");
        int a = getInt("Enter a : ");
        int b = getInt("Enter b : ");
        int res = calculate(operand, a, b);
        System.out.println(res);
    }
    private static int calculate(String operand, int a, int b) {
        try {
            if (operand == "+") return a + b;
            else if (operand == "-") return a - b;
            else if (operand == "*") return a * b;
            else if (operand == "/") return a / b;
            else return -1;
        } catch (ArithmeticException exception) {
            exception.printStackTrace();
            return -1;
        }
    }

    private static int getInt(String message) {
        System.out.print(message);
        try {
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            scanner.close();
            return num;
        } catch (Exception exception) {
            exception.printStackTrace();
            return -1;
        }
    }

    private static String getOperand(String message) {
        System.out.print(message);
        Scanner scanner = new Scanner(System.in);
        String operand = scanner.nextLine();
        scanner.close();
        return operand;
    }
}*/
