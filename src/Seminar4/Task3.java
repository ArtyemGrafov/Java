//1) Написать метод, который принимает массив элементов,
//   помещает их в стэк и выводит на консоль содержимое стэка.
//2) Написать метод, который принимает массив элементов,
//   помещает их в очередь и выводит на консоль содержимое очереди.

package Seminar4;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Task3 {
    public static void main(String[] args) {
        String[] strings = new String[]{"str1", "str2", "str3", "str4", "str5"};
        printStack(strings);
        printQueue(strings);
    }

    private static void printQueue(String[] strings) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(List.of(strings));
        System.out.println(queue);
    }

    private static void printStack(String[] strings) {
        Stack<String> stack = new Stack<>();
        stack.addAll(List.of(strings));
        System.out.println(stack);
    }
}
