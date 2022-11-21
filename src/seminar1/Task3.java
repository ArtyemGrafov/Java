//Реализовать простой калькулятор

package seminar1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter operand(+-/*) : ");
            String operator = scanner.nextLine();
            System.out.print("Enter a : ");
            int a = scanner.nextInt();
            System.out.print("Enter b : ");
            int b = scanner.nextInt();
            
            if (operator.equals("+")) System.out.println(a + b);
            else if (operator.equals("-")) System.out.println(a - b);
            else if (operator.equals("*")) System.out.println(a * b);
            else if (operator.equals("/")) System.out.println((float)a / b);
            else System.out.println("Unknown operation");
        } catch (InputMismatchException exception) {
            System.out.println(exception);
        } finally {
            scanner.close();
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
