//Пусть дан произвольный список целых чисел, удалить из него четные числа

package Seminar3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> array = new ArrayList<>();

        for (int i = 0; i < 10; i++) array.add(random.nextInt());

        System.out.println(array);
        array = removeEven(array);
        System.out.println(array);
    }

    private static ArrayList<Integer> removeEven(ArrayList<Integer> array) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int n : array) if (n % 2 != 0) result.add(n);

        return result;
    }
}
