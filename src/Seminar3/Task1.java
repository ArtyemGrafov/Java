//Реализовать алгоритм сортировки слиянием

package Seminar3;

import java.util.Arrays;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) array[i] = random.nextInt();
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(sort(array)));
    }

    public static int[] sort(int[] array) {
        return sortArray(array, new int[array.length], 0, array.length);
    }

    public static int[] sortArray(int[] array1, int[] array2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) return array1;

        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = sortArray(array1, array2, startIndex, middle);
        int[] sorted2 = sortArray(array1, array2, middle, endIndex);

        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = (sorted1 == array1) ? array2 : array1;
        while (index1 < middle && index2 < endIndex)
            result[destIndex++] = sorted1[index1] < sorted2[index2] ? sorted1[index1++] : sorted2[index2++];

        while (index1 < middle)
            result[destIndex++] = sorted1[index1++];

        while (index2 < endIndex)
            result[destIndex++] = sorted2[index2++];

        return result;
    }
}
