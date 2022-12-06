//В калькулятор добавьте возможность отменить последнюю операцию

package Seminar4;

import java.util.*;

public class Task4 {
    static Queue<List> queue = new LinkedList<>();

    public static void main(String[] args) {
        String str = "";
        Scanner scanner = new Scanner(System.in);
        while (!str.equals("e")) {
            try {
                System.out.println("To exit press 'e', to cansel press 'c', to continue press any key");
                str = scanner.nextLine();
                if (str.equals("e")) {
                    System.out.println("Good bye");
                    break;
                } else if (str.equals("c")) {
                    if (!queue.isEmpty()) {
                        calculate((LinkedList<String>) queue.peek());
                    } else {
                        System.out.println("No more command to cancel");
                        break;
                    }
                } else {
                    LinkedList<String> data = readData();
                    if (data != null) calculate(data);
                }

            } catch (Exception e) {
                return;
            }
            scanner.close();
        }
    }

    private static LinkedList readData() {
        LinkedList<String> linkedList = new LinkedList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter operation +-*/ : ");
            linkedList.add(scanner.nextLine());
            System.out.println("Enter int operand a : ");
            linkedList.add(String.valueOf(scanner.nextInt()));
            System.out.println("Enter int operand b : ");
            linkedList.add(String.valueOf(scanner.nextInt()));
            return linkedList;
        } catch (Exception e) {
            return null;
        }
    }

    private static void calculate(LinkedList<String> linkedList) {
        String operator = linkedList.pollFirst();
        int a = Integer.parseInt(linkedList.pollFirst());
        int b = Integer.parseInt(linkedList.pollFirst());
        switch (operator) {
            case "+" -> {
                queue.add(List.of(operator, String.valueOf(a), String.valueOf(b)));
                System.out.println(a + b);
            }
            case "-" -> {
                queue.add(List.of(operator, String.valueOf(a), String.valueOf(b)));
                System.out.println(a - b);
            }
            case "*" -> {
                queue.add(List.of(operator, String.valueOf(a), String.valueOf(b)));
                System.out.println(a * b);
            }
            case "/" -> {
                queue.add(List.of(operator, String.valueOf(a), String.valueOf(b)));
                System.out.println((float) a / b);
            }
            default -> {
                queue.add(List.of(operator, String.valueOf(a), String.valueOf(b)));
                System.out.println("Unknown operation");
            }
        }
        queue.add(List.of(operator, String.valueOf(a), String.valueOf(b)));
    }
}
