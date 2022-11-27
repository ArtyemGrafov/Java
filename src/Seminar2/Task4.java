//К калькулятору из предыдущего дз добавить логирование.

package Seminar2;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task4 {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(Task2.class.getName());
        FileHandler fileHandler = new FileHandler("src\\Seminar2\\task4log.txt", true);
        SimpleFormatter simpleFormatter = new SimpleFormatter();

        logger.addHandler(fileHandler);
        fileHandler.setFormatter(simpleFormatter);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter operand(+-/*) : ");
            String operator = scanner.nextLine();
            System.out.print("Enter a : ");
            int a = scanner.nextInt();
            System.out.print("Enter b : ");
            int b = scanner.nextInt();

            switch (operator) {
                case "+" -> {
                    String res = String.valueOf((a + b));
                    System.out.println(res);
                    logger.info(a + operator + b + "=" + res);
                }
                case "-" -> {
                    String res = String.valueOf((a - b));
                    System.out.println(res);
                    logger.info(a + operator + b + "=" + res);
                }
                case "*" -> {
                    String res = String.valueOf((a * b));
                    System.out.println(res);
                    logger.info(a + operator + b + "=" + res);
                }
                case "/" -> {
                    if (b != 0) {
                        String res = String.valueOf(((float) a / b));
                        System.out.println(res);
                        logger.info(a + operator + b + "=" + res);
                    } else {
                        System.out.println("infinity");
                        logger.info("Division dy zero");
                    }
                }
                default -> {
                    String res = "Unknown operation";
                    System.out.println(res);
                    logger.info(a + operator + b + "=" + res);
                }
            }
        } catch (InputMismatchException exception) {
            exception.printStackTrace();
            logger.info("error");
        }

    }
}
