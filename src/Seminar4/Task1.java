//Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.

package Seminar4;

import java.util.LinkedList;

public class Task1 {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("str1");
        linkedList.add("str2");
        linkedList.add("str3");
        linkedList.add("str4");
        linkedList.add("str5");

        System.out.println(linkedList);
        System.out.println(reverseList(linkedList));
    }

    private static LinkedList reverseList(LinkedList<String> linkedList) {
        if (linkedList != null) {
            for (int i = 0; i < linkedList.size() / 2; i++) {
                var temp = linkedList.get(i);
                linkedList.set(i, linkedList.get(linkedList.size() - 1 - i));
                linkedList.set(linkedList.size() - 1 - i, temp);
            }
            return linkedList;
        }
        return null;
    }
}
