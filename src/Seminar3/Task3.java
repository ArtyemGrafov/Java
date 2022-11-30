//Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка

package Seminar3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Task3 {
    public static void main(String[] args) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        double average = Double.MIN_VALUE;
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        Iterator<Integer> integerIterator = arrayList.iterator();
        while (integerIterator.hasNext()) {
            int tmp = integerIterator.next();
            max = Math.max(tmp, max);
            min = Math.min(tmp, min);
            average += tmp;
        }

        System.out.printf("min = %d, max = %d, average = %.2f", min, max, average / arrayList.size());
    }
}
