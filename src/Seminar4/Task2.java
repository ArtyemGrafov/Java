//Реализуйте очередь с помощью LinkedList со следующими методами:
//enqueue() - помещает элемент в конец очереди,
//dequeue() - возвращает первый элемент из очереди и удаляет его,
//first() - возвращает первый элемент из очереди, не удаляя.

package Seminar4;

import java.util.LinkedList;

public class Task2 {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("str1");
        linkedList.add("str2");
        linkedList.add("str3");
        linkedList.add("str4");
        linkedList.add("str5");

        System.out.println(linkedList);
        enqueue(linkedList, "str6add");
        System.out.println(linkedList);
        System.out.println(dequeue(linkedList));
        System.out.println(linkedList);
        System.out.println(first(linkedList));
        System.out.println(linkedList);
    }

    private static String first(LinkedList<String> linkedList) {
        return linkedList.getFirst();
    }

    private static String dequeue(LinkedList<String> linkedList) {
        return linkedList.pollFirst();
    }

    private static void enqueue(LinkedList<String> linkedList, String string) {
        linkedList.addLast(string);
    }
}
