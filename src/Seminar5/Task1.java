//Реализуйте структуру телефонной книги с помощью HashMap,
//учитывая, что 1 человек может иметь несколько телефонов.

package Seminar5;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        HashMap<String, LinkedList<Integer>> phoneBook = new HashMap<>();
        phoneBook.put("Ivanov", new LinkedList<>(Arrays.asList(456, 3456, 766)));
        phoneBook.put("Petrov", new LinkedList<>(Arrays.asList(45644, 3656, 796)));
        phoneBook.put("Sidorov", new LinkedList<>(Arrays.asList(4446, 2256, 76622)));

        System.out.println("Enter name from : " + phoneBook.keySet());
        try (Scanner scanner = new Scanner(System.in)) {
            String name = scanner.nextLine();
            if (phoneBook.containsKey(name))
                System.out.println(phoneBook.get(name));
            else
                System.out.println("Incorrect name");
        }

        phoneBook.get("Ivanov").add(1234);
        System.out.println(phoneBook.get("Ivanov"));
        System.out.println(phoneBook.entrySet());
        for (Map.Entry<String, LinkedList<Integer>> entry: phoneBook.entrySet()) {
            System.out.printf("Name %s, phones %s\n",entry.getKey(), entry.getValue());
        }

    }
}
